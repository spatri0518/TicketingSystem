package com.walmart.ts.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.apache.commons.lang.math.RandomUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.walmart.ts.dto.CommonErrorCodeEnumDto;
import com.walmart.ts.enums.ReservationStatusType;
import com.walmart.ts.enums.SeatStatusType;
import com.walmart.ts.exception.DataInvalidException;
import com.walmart.ts.exception.SeatsUnAvailableException;
import com.walmart.ts.mock.MockData;
import com.walmart.ts.model.Customer;
import com.walmart.ts.model.Seat;
import com.walmart.ts.model.SeatHold;
import com.walmart.ts.model.VenueLevel;

@Repository
public class MockResevationDaoImpl implements ReservationDao {

	private static final String RESERVE_PREFIX = "RS";

	private int holdTimeInSeconds;

	@Value("${seatHold.release.executionDelayInSec}")
	public void setHoldTimeInSeconds(int holdTimeInSeconds) {
		this.holdTimeInSeconds = holdTimeInSeconds;
	}

	@Override
	public Integer getNumSeatsAvailable(Optional<Integer> venueLevel) {
		int numSeatsAvailable = 0;
		for (VenueLevel level : MockData.levels) {
			if (!venueLevel.isPresent()
					|| level.getLevelId() == venueLevel.get()) {
					for (Seat seat : MockData.seatsMap.get(level)) {
						if (SeatStatusType.AVAILABLE.equals(seat.getStatus())) {
							numSeatsAvailable++;
						}
				}
			}
		}
		return numSeatsAvailable;
	}

	@Override
	public SeatHold findAndHoldSeats(int numSeats, Optional<Integer> minLevel,
			Optional<Integer> maxLevel, String customerEmail) {

		List<Seat> seatsList = new ArrayList<Seat>();
		
		int seatsHoldCount = 0;
		
		EXTLOOP: for(VenueLevel level : MockData.levels){
			if ((!minLevel.isPresent() || level.getLevelId() >= minLevel.get())
					&& (!maxLevel.isPresent() || level.getLevelId() <= maxLevel.get())) {
				synchronized (MockData.seatsMap.get(level)) {
					Iterator<Seat> itr = MockData.seatsMap.get(level).iterator();
					while (itr.hasNext()) {
						Seat seat = itr.next();
						// if
						// (SeatStatusType.AVAILABLE.equals(seat.getStatus())) {
							MockData.seatsMap.get(level).remove(seat);
							seatsList.add(seat);
							seatsHoldCount++;
						// }
						if (seatsHoldCount == numSeats) {
							break EXTLOOP;
						}
					}
				}
			}
		}
		
		SeatHold seatHold = new SeatHold();

		if(seatsHoldCount < numSeats){
			this.releaseSeats(seatsList);
			throw new SeatsUnAvailableException("Seats not available.");
		} else {
			seatHold.setHoldId(RandomUtils.nextInt());
			seatHold.setStatus(ReservationStatusType.HOLD);
			seatHold.setHoldTimestamp(Calendar.getInstance().getTimeInMillis());
			// seatHold.setSeats(seatsList);
			seatHold.setCustomer(new Customer(RandomUtils.nextLong(), null,
					customerEmail));
			for (Seat seat : seatsList) {
				seat.setStatus(SeatStatusType.HOLD);
				seatHold.getSeats().add(seat);
			}
			MockData.holdsMap.put(seatHold.getHoldId(), seatHold);
		}
		return seatHold;
	}

	private void releaseSeats(List<Seat> seats) {
		for (Seat seat : seats) {
			MockData.seatsMap.get(seat.getVenueLevel()).add(seat);
		}
	}

	@Override
	public String reserveSeats(int seatHoldId, String customerEmail) {
		SeatHold seatHold = MockData.holdsMap.get(seatHoldId);
		if (seatHold == null) {
			throw new DataInvalidException(CommonErrorCodeEnumDto.INVALID_INPUT_DATA, "Invalid seatHoldId.");
		} else {
			for (Seat seat : seatHold.getSeats()) {
				seat.setStatus(SeatStatusType.BOOKED);
			}
		}
		seatHold.setStatus(ReservationStatusType.CONFIRMED);
		String reserveToken = RESERVE_PREFIX + RandomUtils.nextLong();

		MockData.reservedMap.put(reserveToken, seatHold);

		return reserveToken;
	}

	@Override
	public void releaseHoldOrders() {
		for (SeatHold seatHold : MockData.holdsMap.values()) {
			if (ReservationStatusType.HOLD.equals(seatHold.getStatus())) {
				synchronized (seatHold) {
					if (Calendar.getInstance().getTimeInMillis()
							- seatHold.getHoldTimestamp() > holdTimeInSeconds * 1000) {
						for (Seat seat : seatHold.getSeats()) {
							seat.setStatus(SeatStatusType.AVAILABLE);
							MockData.seatsMap.get(seat.getVenueLevel()).add(
									seat);
						}
						seatHold.setStatus(ReservationStatusType.RELEASED);
					}
				}
			}
		}
	}

	@Override
	public List<VenueLevel> getAllVenueLevels() {
		return Arrays.asList(MockData.levels);
	}

}

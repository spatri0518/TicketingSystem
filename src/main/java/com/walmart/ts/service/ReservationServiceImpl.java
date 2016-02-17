package com.walmart.ts.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.walmart.ts.dao.ReservationDao;
import com.walmart.ts.dto.CommonErrorCodeEnumDto;
import com.walmart.ts.exception.DataInvalidException;
import com.walmart.ts.model.SeatHold;
import com.walmart.ts.model.VenueLevel;
import com.walmart.ts.util.Assert;

@Service
public class ReservationServiceImpl implements ReservationService {

	private ReservationDao ticketingServiceDao;

	@Autowired
	public void setTicketingServiceDao(ReservationDao ticketingServiceDao) {
		this.ticketingServiceDao = ticketingServiceDao;
	}

	@Override
	public int numSeatsAvailable(Optional<Integer> venueLevel) {
		if (venueLevel.isPresent()) {
			assertValidVenueLevel(venueLevel);
		}
		return ticketingServiceDao.getNumSeatsAvailable(venueLevel);
	}

	private void assertValidVenueLevel(Optional<Integer> venueLevel) {
		List<VenueLevel> venueLevelsList = ticketingServiceDao
				.getAllVenueLevels();

		boolean found = false;

		for (VenueLevel level : venueLevelsList) {
			if (level.getLevelId() == venueLevel.get()) {
				found = true;
				break;
			}
		}
		if(!found){
			throw new DataInvalidException("Invalid venue Level");
		}
	}

	@Override
	public SeatHold findAndHoldSeats(Integer numSeats, Optional<Integer> minLevel,
			Optional<Integer> maxLevel, String customerEmail) {
		this.validateFindAndHoldSeatsRequest(numSeats, minLevel, maxLevel,
				customerEmail);

		return ticketingServiceDao.findAndHoldSeats(numSeats, minLevel,
				maxLevel, customerEmail);
	}


	private void validateFindAndHoldSeatsRequest(Integer numSeats,
			Optional<Integer> minLevel, Optional<Integer> maxLevel,
			String customerEmail) {
		Assert.assertNotNull("numSeats", numSeats);
		Assert.assertNotEmpty("customerEmail", customerEmail);
		
		if (minLevel.isPresent() && maxLevel.isPresent()
				&& minLevel.get() > maxLevel.get()) {
			throw new DataInvalidException(
					CommonErrorCodeEnumDto.INVALID_INPUT_DATA,
					"Invalid min and max Level values.");
		}
	}

	@Override
	public String reserveSeats(Integer seatHoldId, String customerEmail) {
		Assert.assertNotNull("seatHoldId", seatHoldId);
		Assert.assertNotEmpty("customerEmail", customerEmail);
		return ticketingServiceDao.reserveSeats(seatHoldId, customerEmail);
	}

}

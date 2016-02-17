package com.walmart.ts.dao;

import java.util.List;
import java.util.Optional;

import com.walmart.ts.model.SeatHold;
import com.walmart.ts.model.VenueLevel;

//@Repository
public class ReservationDaoImpl implements ReservationDao {


	@Override
	public Integer getNumSeatsAvailable(Optional<Integer> venueLevel) {
		return 100;
	}


	@Override
	public void releaseHoldOrders() {
		// TODO: implement the logic to release the orders
	}

	@Override
	public SeatHold findAndHoldSeats(int numSeats, Optional<Integer> minLevel,
			Optional<Integer> maxLevel, String customerEmail) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String reserveSeats(int seatHoldId, String customerEmail) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<VenueLevel> getAllVenueLevels() {
		// TODO Auto-generated method stub
		return null;
	}

}

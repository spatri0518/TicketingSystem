package com.walmart.ts.dao;

import java.util.List;
import java.util.Optional;

import com.walmart.ts.model.SeatHold;
import com.walmart.ts.model.VenueLevel;

public interface ReservationDao {

	Integer getNumSeatsAvailable(Optional<Integer> venueLevel);

	public SeatHold findAndHoldSeats(int numSeats, Optional<Integer> minLevel,
			Optional<Integer> maxLevel, String customerEmail);

	public String reserveSeats(int seatHoldId, String customerEmail);

	void releaseHoldOrders();

	public List<VenueLevel> getAllVenueLevels();
}

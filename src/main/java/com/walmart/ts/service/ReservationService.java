package com.walmart.ts.service;

import java.util.Optional;

import com.walmart.ts.model.SeatHold;

public interface ReservationService {
	
	public int numSeatsAvailable(Optional<Integer> venuLevel);

	public SeatHold findAndHoldSeats(Integer numSeats,
			Optional<Integer> minLevel,
			Optional<Integer> maxLevel, String customerEmail);

	public String reserveSeats(Integer seatHoldId, String customerEmail);


}

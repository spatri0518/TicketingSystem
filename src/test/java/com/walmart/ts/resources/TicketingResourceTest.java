package com.walmart.ts.resources;


import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.walmart.ts.BaseTest;
import com.walmart.ts.Data;
import com.walmart.ts.dto.ReservationDto;
import com.walmart.ts.dto.SeatHoldDto;
import com.walmart.ts.dto.SeatsAvailabilityDto;
import com.walmart.ts.exception.DataInvalidException;

public class TicketingResourceTest extends BaseTest {

	@Autowired
	private TicketingResource ticketingResource;

	@Test
	public void testNumSeatsAvailable() {
		SeatsAvailabilityDto dto = ticketingResource
				.numSeatsAvailable(Data.VENUE_LVL);
		assertTrue(dto.getNumOfSeatsAvailable() > 0);
	}

	@Test(expected = DataInvalidException.class)
	public void testNumSeatsAvailableInvalidParams() {
		SeatsAvailabilityDto dto = ticketingResource
				.numSeatsAvailable(Data.INVALID_VENUE_LVL);
	}

	@Test
	public void testFindAndHoldSeats() {
		SeatHoldDto dto = ticketingResource
				.findAndHoldSeats(Data.NUM_SEATS, Data.MIN_LEVEL, Data.MAX_LEVEL, Data.CUST_EMAIL);
		assertTrue(dto.getHoldId() > 0);
	}

	@Test(expected = DataInvalidException.class)
	public void testFindAndHoldSeatsInvalidRequest() {
		// email id null
		SeatHoldDto dto = ticketingResource.findAndHoldSeats(10,
				Data.MIN_LEVEL, Data.MAX_LEVEL, null);

	}

	@Test
	public void testReserveSeats() {
		SeatHoldDto dto = ticketingResource
				.findAndHoldSeats(Data.NUM_SEATS, Data.MIN_LEVEL, Data.MAX_LEVEL, Data.CUST_EMAIL);
		
		assertTrue(dto.getHoldId() > 0);
		ReservationDto reservationDto = ticketingResource.reserveSeats(
				dto.getHoldId(), Data.CUST_EMAIL);
		assertNotNull(reservationDto.getReservationId());
		
	}

	@Test(expected = DataInvalidException.class)
	public void testReserveSeatsInvalidRequest() {
		ReservationDto reservationDto = ticketingResource.reserveSeats(123,
				Data.CUST_EMAIL);
		assertNotNull(reservationDto.getReservationId());

	}

	@Override
	protected void setupInternal() throws Exception {
		// TODO Auto-generated method stub
	}

}
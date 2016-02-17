package com.walmart.ts.resources;

import java.util.Calendar;
import java.util.Optional;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.walmart.ts.dto.CodeDescriptionDto;
import com.walmart.ts.dto.CustomerDto;
import com.walmart.ts.dto.ReservationDto;
import com.walmart.ts.dto.SeatHoldDto;
import com.walmart.ts.dto.SeatsAvailabilityDto;
import com.walmart.ts.model.Customer;
import com.walmart.ts.model.SeatHold;
import com.walmart.ts.service.ReservationService;
import com.walmart.ts.util.DateUtility;

@Component
@Path("/ticketing")
@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
public class TicketingResource {

	private static final Logger LOG = LoggerFactory.getLogger(TicketingResource.class);
	private static final String CLASS_NAME = TicketingResource.class.getName();

	private ReservationService reservationService;

	@Autowired
	public void setTicketingService(ReservationService reservationService) {
		this.reservationService = reservationService;
	}

	@GET
	public String heartbeat() {
		return "I am Alive";
	}

	@GET
	@Path("numSeatsAvailable")
	public SeatsAvailabilityDto numSeatsAvailable(
			@QueryParam("venueLevel") Integer venueLevel) {
		final String METHOD_NAME = "numSeatsAvailable";
		LOG.debug("Entered Class:" + CLASS_NAME + "." + METHOD_NAME);

		LOG.error("venueLevel::" + venueLevel);

		return toDto(reservationService.numSeatsAvailable(Optional
				.ofNullable(venueLevel)));
	}

	private SeatsAvailabilityDto toDto(Integer numOfSeatsAvailable) {
		SeatsAvailabilityDto avaiabilityDto = new SeatsAvailabilityDto();
		avaiabilityDto.setNumOfSeatsAvailable(numOfSeatsAvailable.longValue());
		return avaiabilityDto;
	}

	@GET
	@Path("findAndHoldSeats")
	public SeatHoldDto findAndHoldSeats(
			@QueryParam("numSeats") Integer numSeats,
			@QueryParam("minLevel") Integer minLevel,
			@QueryParam("maxLevel") Integer maxLevel,
			@QueryParam("customerEmail") String customerEmail) {

		SeatHold seatHold = reservationService.findAndHoldSeats(numSeats,
				Optional.ofNullable(minLevel), Optional.ofNullable(maxLevel),
				customerEmail);

		return toDto(seatHold);

	}

	private SeatHoldDto toDto(SeatHold seatHold) {
		SeatHoldDto dto = new SeatHoldDto();

		dto.setHoldId(seatHold.getHoldId());

		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(seatHold.getHoldTimestamp());
		dto.setHoldDate(DateUtility.formatSimpleLiteralDate(calendar.getTime()));

		dto.setHoldStatus(new CodeDescriptionDto(String.valueOf(seatHold
				.getStatus().getStatuCode()), seatHold.getStatus().getDesc()));

		Customer customer = seatHold.getCustomer();
		dto.setCustomer(new CustomerDto(customer.getCustomerId(), customer
				.getName(), customer.getEmailId()));

		dto.setSeatNumbers(seatHold.getSeatNumbers());

		return dto;
	}

	@GET
	@Path("reserveSeats")
	public ReservationDto reserveSeats(
			@QueryParam("seatHoldId") Integer seatHoldId,
			@QueryParam("customerEmail") String customerEmail) {
		String reservationId = reservationService.reserveSeats(seatHoldId,
				customerEmail);
		return new ReservationDto(reservationId);
	}

}
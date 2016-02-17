package com.walmart.ts.dto;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "Reservation")
@XmlRootElement(name = "Reservation")
public class ReservationDto {
	private String reservationId;

	public ReservationDto(String reservationId) {
		this.reservationId = reservationId;
	}

	public ReservationDto() {
		super();
	}

	public String getReservationId() {
		return reservationId;
	}

	public void setReservationId(String reservationId) {
		this.reservationId = reservationId;
	}

}

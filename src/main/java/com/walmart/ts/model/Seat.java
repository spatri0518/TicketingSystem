package com.walmart.ts.model;

import java.io.Serializable;

import com.walmart.ts.enums.SeatStatusType;

/**
 * Model Class for Seat
 *
 */
public class Seat implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String seatId;
	private SeatStatusType status;
	private VenueLevel venueLevel;

	public Seat() {
		super();
	}

	public Seat(String seatId, SeatStatusType status, VenueLevel venueLevel) {
		super();
		this.seatId = seatId;
		this.status = status;
		this.venueLevel = venueLevel;
	}

	public String getSeatId() {
		return seatId;
	}

	public void setSeatId(String seatId) {
		this.seatId = seatId;
	}

	public SeatStatusType getStatus() {
		return status;
	}

	public void setStatus(SeatStatusType status) {
		this.status = status;
	}

	public VenueLevel getVenueLevel() {
		return venueLevel;
	}

	public void setVenueLevel(VenueLevel venueLevel) {
		this.venueLevel = venueLevel;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
 + ((seatId == null) ? 0 : seatId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Seat other = (Seat) obj;
		if (seatId == null) {
			if (other.seatId != null)
				return false;
		} else if (!seatId.equals(other.seatId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Seat [seatId=" + seatId + ", venue =" + venueLevel
				+ ", status=" + status.getDesc() + "]";
	}

}

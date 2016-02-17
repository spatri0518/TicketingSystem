package com.walmart.ts.enums;

/**
 * 
 * Enumeration of Reservation Statuses.
 * 
 */
public enum ReservationStatusType {

	HOLD(1, "Hold"), RELEASED(2, "Released"), CONFIRMED(3, "Confirmed");

	private int statuCode;
	private String desc;

	private ReservationStatusType(int statusCode, String desc) {
		this.statuCode = statusCode;
		this.desc = desc;
	}

	public int getStatuCode() {
		return statuCode;
	}

	public String getDesc() {
		return desc;
	}

	private ReservationStatusType getByCode(int code) {
		for (ReservationStatusType status : ReservationStatusType.values()) {
			if (status.getStatuCode() == code) {
				return status;
			}
		}
		return null;
	}

}

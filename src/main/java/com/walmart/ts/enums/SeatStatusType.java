package com.walmart.ts.enums;

/**
 * Enumeration of Seat Statuses
 *
 */
public enum SeatStatusType {

	AVAILABLE(1, "Available"), HOLD(2, "Hold"), BOOKED(3, "Booked");

	private int code;
	private String desc;

	private SeatStatusType(int statusCode, String desc) {
		this.code = statusCode;
		this.desc = desc;
	}

	public int getCode() {
		return code;
	}

	public String getDesc() {
		return desc;
	}

	private SeatStatusType getByCode(int code) {
		for (SeatStatusType status : SeatStatusType.values()) {
			if (status.getCode() == code) {
				return status;
			}
		}
		return null;
	}

}

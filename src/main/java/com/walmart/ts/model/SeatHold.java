package com.walmart.ts.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.walmart.ts.enums.ReservationStatusType;

public class SeatHold implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer holdId;
	private Customer customer;
	private List<Seat> seats;
	private Long holdTimestamp;
	private ReservationStatusType status;

	public Integer getHoldId() {
		return holdId;
	}

	public void setHoldId(Integer holdId) {
		this.holdId = holdId;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<Seat> getSeats() {
		if (seats == null) {
			this.setSeats(new ArrayList<Seat>());
		}
		return seats;
	}

	public void setSeats(List<Seat> seats) {
		this.seats = seats;
	}

	public Long getHoldTimestamp() {
		return holdTimestamp;
	}

	public void setHoldTimestamp(Long holdTimestamp) {
		this.holdTimestamp = holdTimestamp;
	}

	public ReservationStatusType getStatus() {
		return status;
	}

	public void setStatus(ReservationStatusType status) {
		this.status = status;
	}

	public String getSeatsNumbersAsString(){
		StringBuilder strBuilder = new StringBuilder();
		for(Seat seat: seats){
			strBuilder.append(seat.getSeatId()).append(", ");
		}
		return strBuilder.substring(0, strBuilder.length() - 1);
	}

	public List<String> getSeatNumbers() {
		List<String> seatNumbers = new ArrayList<String>();
		for (Seat seat : seats) {
			seatNumbers.add(seat.getSeatId());
		}
		return seatNumbers;
	}

}

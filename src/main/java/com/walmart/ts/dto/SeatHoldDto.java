package com.walmart.ts.dto;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "SeatHold")
public class SeatHoldDto {

	private Integer holdId;
	private CustomerDto customer;
	private List<String> seatNumbers;
	private String holdDate;
	private CodeDescriptionDto holdStatus;

	public Integer getHoldId() {
		return holdId;
	}

	public void setHoldId(Integer holdId) {
		this.holdId = holdId;
	}

	public CustomerDto getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerDto customer) {
		this.customer = customer;
	}

	public List<String> getSeatNumbers() {
		return seatNumbers;
	}

	public void setSeatNumbers(List<String> seatNumbers) {
		this.seatNumbers = seatNumbers;
	}

	public String getHoldDate() {
		return holdDate;
	}

	public void setHoldDate(String holdDate) {
		this.holdDate = holdDate;
	}

	public CodeDescriptionDto getHoldStatus() {
		return holdStatus;
	}

	public void setHoldStatus(CodeDescriptionDto status) {
		this.holdStatus = status;
	}




}

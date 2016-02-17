package com.walmart.ts.dto;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "SeatsAvailability")
public class SeatsAvailabilityDto {

	private Long numOfSeatsAvailable;

	public Long getNumOfSeatsAvailable() {
		return numOfSeatsAvailable;
	}

	public void setNumOfSeatsAvailable(Long numOfSeatsAvailable) {
		this.numOfSeatsAvailable = numOfSeatsAvailable;
	}

}

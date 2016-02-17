package com.walmart.ts.dto;

import javax.xml.bind.annotation.XmlType;

@XmlType(name = "Customer")
public class CustomerDto {

	private Long customerId;
	private String name;
	private String emailId;

	public CustomerDto() {
		super();
	}

	public CustomerDto(Long customerId, String name, String emailId) {
		super();
		this.customerId = customerId;
		this.name = name;
		this.emailId = emailId;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

}

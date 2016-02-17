package com.walmart.ts.dto;

import javax.xml.bind.annotation.XmlType;

@XmlType(name = "CodeDescriptionDto")
public class CodeDescriptionDto {

	private String code;
	private String description;

	public CodeDescriptionDto() {
		super();
	}

	public CodeDescriptionDto(String code, String description) {
		super();
		this.code = code;
		this.description = description;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}

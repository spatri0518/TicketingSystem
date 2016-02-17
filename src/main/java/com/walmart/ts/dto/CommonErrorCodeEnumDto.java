package com.walmart.ts.dto;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "errorCode")
@XmlType(name = "errorCode")
public enum CommonErrorCodeEnumDto {
	TMP_UNAVAILABLE, UNAVAILABLE, INVALID_DATA_FORMAT, INVALID_INPUT_ID, INVALID_INPUT_DATA, NULL_INPUT_DATA, UNKNOWN, CONNECTION_TIMEOUT, READ_TIMEOUT, NOT_FOUND;
}

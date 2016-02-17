package com.walmart.ts.dto;

import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "errorInfo")
public class ErrorInfoDto {

	private CommonErrorCodeEnumDto errorCode;
	private String msg;
	private Date timestamp;

	public ErrorInfoDto() {
	}

	public String toString() {
		StringBuilder buf = new StringBuilder();
		buf.append("ErrorInfo:\n");
		if (this.errorCode != null) {
			buf.append("Code::").append(this.errorCode.name());
		}
		buf.append(" Message::").append(msg).append(".");
		return buf.toString();
	}


	@XmlElement(name = "errorCode")
	public CommonErrorCodeEnumDto getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(CommonErrorCodeEnumDto theCode) {
		this.errorCode = theCode;
	}

	public String getMsg() {
		return msg;
	}

	@XmlElement(name = "message")
	public void setMsg(String msg) {
		this.msg = msg;
	}

	@XmlElement(name = "timestamp")
	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}


}


package com.walmart.ts.exception;

import com.walmart.ts.dto.CommonErrorCodeEnumDto;
import com.walmart.ts.dto.ErrorInfoDto;

public class ServiceException extends RuntimeException {
	private static final long serialVersionUID = -7744379986697673670L;

	protected ErrorInfoDto errorInfo = new ErrorInfoDto();
	protected boolean isLogged = false;

	public ServiceException(String msg) {
		super(msg);
		errorInfo.setMsg(msg);
	}

	public ServiceException(CommonErrorCodeEnumDto errorCode, String msg) {
		super(msg);
		errorInfo.setErrorCode(errorCode);
		errorInfo.setMsg(msg);
	}

	public ServiceException(CommonErrorCodeEnumDto errorCode, String msg,
			Throwable cause) {
		super(msg, cause);
		errorInfo.setErrorCode(errorCode);
		errorInfo.setMsg(msg);
	}

	public ErrorInfoDto getErrorInfo() {
		return errorInfo;
	}

	public boolean hasBeenLogged() {
		return isLogged;
	}

	public void setLogged(boolean isLogged) {
		this.isLogged = isLogged;
	}

}

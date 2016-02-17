package com.walmart.ts.exception;

import com.walmart.ts.dto.CommonErrorCodeEnumDto;

public class SeatsUnAvailableException extends ServiceException {

	private static final long serialVersionUID = -7744379986697673670L;

	public SeatsUnAvailableException(String msg) {
		super(msg);
	}

	public SeatsUnAvailableException(CommonErrorCodeEnumDto errorCode,
			String msg) {
		super(errorCode, msg);
	}

	public SeatsUnAvailableException(CommonErrorCodeEnumDto errorCode,
			String msg,
			Throwable cause) {
		super(errorCode, msg, cause);
	}

}

package com.walmart.ts.exception;

import com.walmart.ts.dto.CommonErrorCodeEnumDto;

public class DataInvalidException extends ServiceException {
	private static final long serialVersionUID = -7744379986697673670L;

	public DataInvalidException(String msg) {
		super(msg);
	}

	public DataInvalidException(CommonErrorCodeEnumDto errorCode, String msg) {
		super(errorCode, msg);
	}

	public DataInvalidException(CommonErrorCodeEnumDto errorCode, String msg,
			Throwable cause) {
		super(errorCode, msg, cause);
	}

}

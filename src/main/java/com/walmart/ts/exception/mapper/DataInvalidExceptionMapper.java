package com.walmart.ts.exception.mapper;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.walmart.ts.exception.DataInvalidException;

/**
 * This mapper catches a DataInvalidException and throws a 400 (validation)
 * exception
 */
@Provider
@Component
public class DataInvalidExceptionMapper implements
		ExceptionMapper<DataInvalidException> {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(DataInvalidExceptionMapper.class);

	@Override
	public Response toResponse(DataInvalidException ex) {
		LOGGER.error(ex.getErrorInfo().getMsg(), ex);
		return Response.status(Status.BAD_REQUEST)
				.entity(ex.getErrorInfo()).build();
	}
}

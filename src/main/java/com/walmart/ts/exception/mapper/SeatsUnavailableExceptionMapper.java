package com.walmart.ts.exception.mapper;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.walmart.ts.exception.SeatsUnAvailableException;

/**
 * This mapper catches a NOT Found Exception and throws a 404 (validation)
 * exception
 */
@Provider
@Component
public class SeatsUnavailableExceptionMapper implements
		ExceptionMapper<SeatsUnAvailableException> {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(SeatsUnavailableExceptionMapper.class);

	@Override
	public Response toResponse(SeatsUnAvailableException ex) {
		LOGGER.error(ex.getErrorInfo().getMsg(), ex);
		return Response.status(Status.NOT_FOUND)
				.entity(ex.getErrorInfo()).build();
	}
}

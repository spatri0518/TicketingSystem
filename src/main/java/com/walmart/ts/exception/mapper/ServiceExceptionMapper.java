package com.walmart.ts.exception.mapper;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.walmart.ts.exception.DataInvalidException;
import com.walmart.ts.resources.TicketingResource;

/**
 * This mapper catches a DataInvalidException and throws a 400 (validation)
 * exception
 */
@Provider
@Component
public class ServiceExceptionMapper implements
		ExceptionMapper<DataInvalidException> {

	private static final Logger LOG = LoggerFactory
			.getLogger(ServiceExceptionMapper.class);
	private static final String CLASS_NAME = TicketingResource.class.getName();

	@Override
	public Response toResponse(DataInvalidException ex) {
		LOG.error(ex.getErrorInfo().getMsg(), ex);
		return Response.status(Status.INTERNAL_SERVER_ERROR)
				.entity(ex.getErrorInfo())
				.build();
	}

}

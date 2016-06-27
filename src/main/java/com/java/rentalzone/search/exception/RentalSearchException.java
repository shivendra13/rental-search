package com.java.rentalzone.search.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

public class RentalSearchException extends Exception implements ExceptionMapper<SearchException> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4789482211123561139L;

	public RentalSearchException()
	{
		super("Request is not processed due to some internal issue.Please try after some time!!");
	}
	public RentalSearchException(String message)
	{
		super(message);
	}
	@Override
	public Response toResponse(SearchException exception) {
		
		 return Response.status(exception.getErrorCode()).entity(exception.getMessage()).build();
	}
	
}

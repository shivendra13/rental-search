package com.java.rentalzone.search.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.StatusType;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class SearchException extends RuntimeException implements ExceptionMapper<SearchException> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4379686338268442077L;
	
	private StatusType errorCode;
	
	public SearchException(StatusType errorCode,String errorMessage) {
		super(errorMessage);
		this.errorCode=errorCode;
		
	}
	public SearchException()
	{
		super("Request is not processed due to some internal issue.Please try after some time!!");
	}

	public StatusType getErrorCode(){
        return this.errorCode;
    }

	
	
	@Override
	public Response toResponse(SearchException exception) {
		return Response.status(exception.getErrorCode()).entity(exception.getMessage()).build();
	}
}

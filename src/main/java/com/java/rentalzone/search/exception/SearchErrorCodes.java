package com.java.rentalzone.search.exception;

import javax.ws.rs.core.Response.Status.Family;
import javax.ws.rs.core.Response.StatusType;

public enum SearchErrorCodes implements StatusType{
	INVALID_QUERY(444,"INVALID_QUERY"),
	INVALID_JSON_ES(554,"INVALID_JSON_ES"),
	AWS_DOWN(555,"AWS_DOWN");
	
	private final int code;
    private final String reason;
    private final Family family;
    
    SearchErrorCodes(final int statusCode, final String reasonPhrase) {
        this.code = statusCode;
        this.reason = reasonPhrase;
        this.family = Family.familyOf(statusCode);
    }
 
	@Override
	public int getStatusCode() {
		// TODO Auto-generated method stub
		return code;
	}

	@Override
	public Family getFamily() {
		// TODO Auto-generated method stub
		return family;
	}

	@Override
	public String getReasonPhrase() {
		// TODO Auto-generated method stub
		return reason;
	}

	
	
}

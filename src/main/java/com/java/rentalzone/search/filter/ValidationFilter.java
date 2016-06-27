package com.java.rentalzone.search.filter;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.PreMatching;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.Provider;

import com.java.rentalzone.search.exception.SearchErrorCodes;
import com.java.rentalzone.search.exception.SearchException;

@Provider

@ValidateQueryParams
public class ValidationFilter implements ContainerRequestFilter{

	@Override
	public void filter(ContainerRequestContext requestContext)
			throws IOException {
				validateQueryParams(requestContext); 
			
	}

	private void validateQueryParams(ContainerRequestContext requestContext) throws SearchException {
		
		 MultivaluedMap<String, String> requestQueryParamMap = requestContext.getUriInfo().getQueryParameters(); 
		 List<String> from_date= requestQueryParamMap.get("from_date");
		 List<String> to_date= requestQueryParamMap.get("to_date");
		 if(from_date.size()==1 && to_date.size()==1)
		 {
			 	try {
					validateDate(from_date.get(0));
					validateDate(to_date.get(0));
				} catch (ParseException e) {
					 throw new SearchException(SearchErrorCodes.INVALID_QUERY,"The input dates are invalid.Please enter dates in {yyyy-MM-dd} format.");
				}
			 	
		 }
		 else
		 {
			  throw new SearchException(SearchErrorCodes.INVALID_QUERY,"The input dates are not in valide format");
		 }
		 
		 
	}

	private void validateDate(String date) throws ParseException
	{
		if(date.matches("^\\d{4}-\\d{2}-\\d{2}$"))
		{
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			format.parse(date);
		}
		else
		{
			throw new ParseException(date, 0);
		}
	}

	
}

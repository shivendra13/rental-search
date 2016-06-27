package com.java.rentalzone.search;

import java.util.Date;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import search.SearchService;
import src.main.java.generatable.ESResultSet;

import com.java.rentalzone.search.exception.RentalSearchException;
import com.java.rentalzone.search.exception.SearchException;
import com.java.rentalzone.search.filter.ValidateQueryParams;

@Path("/")
public class SearchApiController {
	
	
	@GET	
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	@Path("{keyword}")
	public Response getSearchByKeyword(@PathParam("keyword") String keyword) throws RentalSearchException
	{
		
		SearchService  service = new SearchService();
		ESResultSet esResultSet = null;
		try {
			esResultSet = service.getByKeyword(keyword);
		}catch(Exception e)
		{
		 if(e instanceof SearchException)
		 {
			 throw new SearchException(((SearchException) e).getErrorCode(), e.getMessage());
		 }
		 else
			 throw new SearchException(Response.Status.INTERNAL_SERVER_ERROR, "An Internal Error is occured, Please try after sometime!!");
		}
		return Response.status(200).entity(esResultSet).build();
		
	}
	
	@GET	
	@Path("getSearchByEntity")
	@ValidateQueryParams
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Response getSearchByEntity(@QueryParam("keyword") String keyword,@QueryParam("from_date") String from_date,@QueryParam("to_date") String to_date
										,@QueryParam("lat") double lat,@QueryParam("lon") double lon) 
	{
		
		SearchService  service = new SearchService();
		
		ESResultSet esResultSet = null;
		try{
				esResultSet = service.getByEntity(keyword,from_date,to_date,lat,lon);
			}catch(Exception e)
			{
			 if(e instanceof SearchException)
			 {
				 throw new SearchException(((SearchException) e).getErrorCode(), e.getMessage());
			 }
			 else
				 throw new SearchException(Response.Status.INTERNAL_SERVER_ERROR, "An Internal Error is occured, Please try after sometime!!");
			}
		
		return Response.status(200).entity(esResultSet).build();
		
	}
	
	
	
	 @GET
	 @Produces(MediaType.TEXT_HTML)
		public Response getStartingPage()
		{
			String output = "<h1>Hello Frnzsss!<h1>" +
					"<p>Rental Search Service is running ... <br>@ " + new Date().toString() + "</p<br>";
			return Response.status(200).entity(output).build();
		}
	
	
}

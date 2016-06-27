package search;



import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.java.rentalzone.search.exception.SearchErrorCodes;
import com.java.rentalzone.search.exception.SearchException;

import src.main.java.generatable.ESResultSet;
import src.main.java.generatable.SearchRequest;




public class SearchService {
	
	
	
	
	public ESResultSet getByKeyword(String keyword) throws SearchException 
	{
		RentalSearchImpl impl= new RentalSearchImpl();
		impl.preExecute();
		SearchRequest request= new SearchRequest();
		request.setSearchKeyword(keyword);
		ESResultSet esResult=impl.execute(request);
		impl.postExeute();
		return esResult;
	}

	public ESResultSet getByEntity(String keyword, String from_date,
			String to_date, double lat, double lon) throws SearchException {
		
		RentalSearchImpl impl= new RentalSearchImpl();
		SearchRequest request= new SearchRequest();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		ESResultSet esResult=null;
		try {
			impl.preExecute();
			request.setSearchKeyword(keyword);
			request.setFrom_Date(format.parse(from_date));
			request.setTo_Date(format.parse(to_date));
			request.setLat(lat);
			request.setLon(lon);
			esResult=impl.execute(request);
			impl.postExeute();
		} catch (ParseException e) {
			throw new SearchException(SearchErrorCodes.INVALID_QUERY,"The input dates are not are invalid.Please enter dates in {yyyy-MM-dd} format.");
		}
		
		
		return esResult;
	}
}

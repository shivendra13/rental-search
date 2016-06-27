package search;

import src.main.java.generatable.ESResultSet;
import src.main.java.generatable.SearchRequest;

import com.java.rentalzone.search.exception.SearchException;




public interface RentalSearch {

	
	public void preExecute();
	public ESResultSet execute(SearchRequest request) throws SearchException;
	public  void postExeute();
}

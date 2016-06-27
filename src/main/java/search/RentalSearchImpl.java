package search;



import java.io.IOException;

import org.codehaus.jackson.Version;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.module.SimpleModule;

import com.java.rentalzone.search.exception.SearchErrorCodes;
import com.java.rentalzone.search.exception.SearchException;

import src.main.java.generatable.ESResultSet;
import src.main.java.generatable.SearchRequest;
import common.AWSAccessUnit;
import common.EsSerializer;
import elasticsearch.ElasticQueryBuilder;

public class RentalSearchImpl implements RentalSearch {

	private static AWSAccessUnit awsUnit = null;


	public void preExecute() {
		if(awsUnit==null)
		{
		awsUnit=new AWSAccessUnit();
		}
	}

	public ESResultSet execute(SearchRequest request) throws  SearchException {
		ESResultSet esResultSet=null;
		
		String esQuery = ElasticQueryBuilder.getESQuery(request);
		
		try {
			String result = awsUnit.esPostCall(esQuery);
			ObjectMapper mapper = getEsJsonMapper(result);
			esResultSet=mapper.readValue(result, ESResultSet.class);
		} catch (IOException e) {
			throw new SearchException(SearchErrorCodes.INVALID_JSON_ES, "We have received an invalid json response from ES");
		} catch (Exception e) {
			throw new SearchException(SearchErrorCodes.AWS_DOWN, "AWS is down, we are unable to reach to AWS ES custer");
		}
		return esResultSet;
	}

	public void postExeute() {
		
		
	}
	
	private ObjectMapper getEsJsonMapper(String result)
	{
		ObjectMapper mapper = new ObjectMapper();
		Version version = new Version(1, 0, 0, "SNAPSHOT");
		SimpleModule module = new SimpleModule(result, version);
		module.addDeserializer(ESResultSet.class, new EsSerializer());
		mapper.registerModule(module);
		return mapper;
	}
	
		 
			 
		 
	

}

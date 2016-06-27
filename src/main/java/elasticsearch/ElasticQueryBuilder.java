package elasticsearch;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.elasticsearch.common.geo.GeoDistance;
import org.elasticsearch.common.unit.DistanceUnit;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;

import src.main.java.generatable.SearchRequest;

import com.java.rentalzone.search.exception.SearchErrorCodes;
import com.java.rentalzone.search.exception.SearchException;

public class ElasticQueryBuilder {
	
	
	private static QueryBuilder keywordMatchQuery=null;
	private static QueryBuilder availabilityFilter=null;
	private static QueryBuilder geoFilter=null;	
	
	private static QueryBuilder getESQueryForKeyword(String keyword,String Value)
	{
			
		QueryBuilder qb = QueryBuilders.matchQuery(keyword, Value);
		BoolQueryBuilder bl= new BoolQueryBuilder();
		bl.must(qb);
		return bl;
	}
	
	public static String getESQuery(SearchRequest request) throws SearchException
	{
		QueryBuilder[] filters=null;
		QueryBuilder qb1=null;
		try {
		if(request.getSearchKeyword()!=null)
		{
			 keywordMatchQuery=getESQueryForKeyword("TITLE", request.getSearchKeyword());
		}
		filters = addESFilters(request);
		QueryBuilder filterBuilder=QueryBuilders.andQuery(filters);
		QueryBuilder filterBuilder1=QueryBuilders.filteredQuery(keywordMatchQuery, filterBuilder);
		qb1=QueryBuilders.queryFilter(filterBuilder1);
		}	catch (Exception e) {
				throw new SearchException(SearchErrorCodes.INVALID_QUERY,"Query is not formted correctly");
		}
		
	return qb1.toString();
		
	}
	
	private static QueryBuilder addAvailabilityFilter(Date availabilityFrom, Date availabilityTo) 
	{
//		Date availabilityFrom=null;
//		Date availabilityTo=null;
//		SimpleDateFormat formate= new SimpleDateFormat("yyyy-MM-dd");
//		 availabilityFrom = formate.parse(availability_from);
//		 availabilityTo = formate.parse(availability_to);
		QueryBuilder queryBuilder=QueryBuilders.nestedQuery("AVAILABILITY",               // Path
                		QueryBuilders.boolQuery()       // Your query
                        .must(QueryBuilders.rangeQuery("AVAILABILITY.TO_DATE").gte(availabilityTo).lte(availabilityFrom))
                        .must(QueryBuilders.rangeQuery("AVAILABILITY.FROM_DATE").lte(availabilityFrom).gte(availabilityTo)));
		return queryBuilder;
		
	}
	
	private static QueryBuilder addGeoFilter(double lat, double lon)
	{
		QueryBuilder queryBuilder=QueryBuilders.geoDistanceQuery("LOCATION").point(lat,lon).distance(5,DistanceUnit.KILOMETERS).optimizeBbox("memory").geoDistance(GeoDistance.ARC);
		
		return queryBuilder;
	}
	
	private static QueryBuilder[] addESFilters(SearchRequest request) 
	{
		List<QueryBuilder> filters=  new ArrayList<>();
	
		if(request.getTo_Date()!=null && request.getFrom_Date()!=null)
		{
			availabilityFilter=addAvailabilityFilter(request.getTo_Date(), request.getFrom_Date());
			filters.add(availabilityFilter);
		}
		
		if(request.getLat()!=0 && request.getLon()!=0)
		{
			 geoFilter=addGeoFilter(request.getLat(),request.getLon());
			 filters.add(geoFilter);
		}
		QueryBuilder[] filterQuery=filters.toArray(new QueryBuilder[filters.size()]);
		return filterQuery;
	}
}

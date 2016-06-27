package common;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeConstants;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.JsonDeserializer;

import src.main.java.generatable.Availability;
import src.main.java.generatable.ESResultSet;
import src.main.java.generatable.Hit;
import src.main.java.generatable.Hits;
import src.main.java.generatable.Location;
import src.main.java.generatable.Shards;
import src.main.java.generatable.Source;

public class EsSerializer extends JsonDeserializer<ESResultSet>{

	@Override
	public ESResultSet deserialize(JsonParser jp, DeserializationContext ctxt)		throws IOException, JsonProcessingException {

		ESResultSet resultSet= new ESResultSet();
		
		 JsonNode node = jp.getCodec().readTree(jp);
		 boolean timed_Out = node.get("timed_out").asBoolean();
		 BigInteger took = (BigInteger) node.get("took").getBigIntegerValue();
	
		// For Shards
		 Shards shards = new Shards();
		 JsonNode shard=node.get("_shards");
		 BigInteger total = (BigInteger) shard.get("total").getBigIntegerValue();
		 BigInteger successful = (BigInteger)  shard.get("successful").getBigIntegerValue();
		 BigInteger failed = (BigInteger)  shard.get("failed").getBigIntegerValue();
		 shards.setTotal(total);
		 shards.setSuccessful(successful);
		 shards.setFailed(failed);
		 
		 //For Hit
		 Hit hits= new Hit();
		 JsonNode hit=node.get("hits");
		 BigInteger totalHits = (BigInteger) hit.get("total").getBigIntegerValue();
		 BigDecimal max_score = (BigDecimal) hit.get("max_score").getDecimalValue();
		 
		 hits.setTotal(totalHits);
		 hits.setMax_Score(max_score);
		 
		 
		 //For Hits
		 JsonNode hit2= hit.findValue("hits");
		 
		 for (Iterator<JsonNode> iterator = hit2.iterator(); iterator.hasNext();) {
			JsonNode hitJsonNode = (JsonNode) iterator.next();
		
		
		 Hits hits2= new Hits();
		 String index= hitJsonNode.get("_index").getTextValue();
		 String type= hitJsonNode.get("_type").getTextValue();
		 String id= hitJsonNode.get("_id").getTextValue();
		 BigDecimal score = (BigDecimal) hitJsonNode.get("_score").getDecimalValue();
		 
		 hits2.setId(id);
		 hits2.setIndex(index);
		 hits2.setScore(score);
		 hits2.setType(type);
		 
		 
		 //For Source
		 
		 JsonNode source=hitJsonNode.get("_source");
		 Source sources= new Source();
		 
		 long item_id=source.get("ITEM_ID").getLongValue();
		 long PRODUCT_REF_ID=source.get("PRODUCT_REF_ID").getLongValue();
		 String TITLE= source.get("TITLE").getTextValue();
		 BigInteger CATEGORY_ID = (BigInteger) source.get("CATEGORY_ID").getBigIntegerValue();
		 String CATEGORY_DATA= source.get("CATEGORY_DATA").getTextValue();
		 BigDecimal PRICE = (BigDecimal) source.get("PRICE").getDecimalValue();
		 BigInteger SELLER_RATING = (BigInteger) source.get("SELLER_RATING").getBigIntegerValue();
		 String CONDITION= source.get("CONDITION").getTextValue();
		 long SELLER_ID=source.get("SELLER_ID").getLongValue();
		 BigInteger QUANTITY = (BigInteger) source.get("QUANTITY").getBigIntegerValue();
		 
		 sources.setItem_Id(item_id);
		 sources.setProduct_Ref_Id(PRODUCT_REF_ID);
		 sources.setTitle(TITLE);
		 sources.setCategory_Id(CATEGORY_ID);
		 sources.setCategory_Data(CATEGORY_DATA);
		 sources.setPrice(PRICE);
		 sources.setSeller_Id(SELLER_ID);
		 sources.setCondition(CONDITION);
		 sources.setSeller_Rating(SELLER_RATING);
		 sources.setQuantity(QUANTITY);
		 
		 //For Location
		 
		 JsonNode location=source.get("LOCATION");
		 Location locations= new Location();
		 String lat=location.get("lat").getTextValue();
		 String lon=location.get("lon").getTextValue();
		 
		 locations.setLat(Double.valueOf(lat));
		 locations.setLon(Double.valueOf(lon));
		 sources.setLocation(locations);
		 
		 // For Availability
			
		 JsonNode availabilityJson=source.findValue("AVAILABILITY");
		
		 for (Iterator<JsonNode> iterator1 = availabilityJson.iterator(); iterator1.hasNext();) {
			 
			JsonNode  availability= (JsonNode) iterator1.next();
			Availability availabilitys= new Availability();
			String to_date=availability.get("TO_DATE").getTextValue();
			String from_date =availability.get("FROM_DATE").getTextValue();
			SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd");
			try {
			
			Date toDate =dateFormat.parse(to_date);
			Date fromDate =dateFormat.parse(from_date);
//			GregorianCalendar cal = new GregorianCalendar();
//			cal.setTime(dob);
//			XMLGregorianCalendar xmlDate2 = DatatypeFactory.newInstance().newXMLGregorianCalendar(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH)+1, cal.get(Calendar.DAY_OF_MONTH), dob.getHours(),dob.getMinutes(),dob.getSeconds(),DatatypeConstants.FIELD_UNDEFINED, cal.getTimeZone().LONG).normalize();
//			cal.setTime(dob1);
//			XMLGregorianCalendar xmlDate3 = DatatypeFactory.newInstance().newXMLGregorianCalendar(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH)+1, cal.get(Calendar.DAY_OF_MONTH), dob1.getHours(),dob1.getMinutes(),dob1.getSeconds(),DatatypeConstants.FIELD_UNDEFINED, cal.getTimeZone().LONG).normalize();
			availabilitys.setTo_Date(toDate);
			availabilitys.setFrom_Date(fromDate);
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
			sources.getAvailability().add(availabilitys);
		 }
		 hits2.setSource(sources);
		 hits.getHits().add(hits2);
		 }
		 
				 
		 resultSet.setTimed_Out(timed_Out);
		 resultSet.setTook(took);
		 resultSet.setShards(shards);
		 resultSet.setHit(hits);
		return resultSet;
	}




}

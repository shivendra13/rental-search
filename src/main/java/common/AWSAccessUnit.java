package common;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;


public class AWSAccessUnit {

 public static final String AWSACCESSKEYID = "";
 public static final String AWSSECRETKEY = "";
 
 public static final String REGION = "us-west-2";
 public static final String SERVICE = "es";
 public static final String ALGORITHM = "AWS4-HMAC-SHA256";
 public static final String HOST = "search-rentalhub-v7mpqb7zzdhgbkom3s6uikgbva"+"."+"us-west-2"+"."+"es"+".amazonaws.com";
 public static final String URI = "/_search";
 public static final String URL = "https://"+HOST+URI;
 public static final String QUERYSTRING = "";

 
 public String esPostCall(String data) throws Exception {
  AmazonSigner signer = new AmazonSigner(AWSACCESSKEYID, AWSSECRETKEY, REGION, SERVICE, URL, HOST);
  HttpPost request = signer.getSignedPostRequest( URI, QUERYSTRING, new HashMap<String, String>(), data);
  HttpClient client = HttpClientBuilder.create().build();
  client.execute(request);
  HttpResponse response = client.execute(request);
  System.out.println("Response Code : " + response.getStatusLine().getStatusCode());
  BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
  StringBuffer result = new StringBuffer();
  String line = "";
  while ((line = rd.readLine()) != null) {
   result.append(line);
  }
  return result.toString();
 } 

}

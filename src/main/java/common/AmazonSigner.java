package common;

import java.security.MessageDigest;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Map;
import java.util.SortedMap;
import java.util.TimeZone;
import java.util.TreeMap;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Hex;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;

/**
 * http://docs.aws.amazon.com/general/latest/gr/sigv4-create-canonical-request.html <br />
 * http://docs.aws.amazon.com/general/latest/gr/sigv4-create-string-to-sign.html <br />
 * http://docs.aws.amazon.com/general/latest/gr/sigv4-calculate-signature.html <br />
 * http://docs.aws.amazon.com/general/latest/gr/sigv4-add-signature-to-request.html <br />
 * 
 * CanonicalRequest = <br />
 * HTTPRequestMethod + '\n' + <br />
 * CanonicalURI + '\n' + <br />
 * CanonicalQueryString + '\n' + <br />
 * CanonicalHeaders + '\n' + <br />
 * SignedHeaders + '\n' + <br />
 * HexEncode(Hash(RequestPayload))
 *
 * StringToSign = <br />
 * Algorithm + '\n' + <br />
 * RequestDate + '\n' + <br />
 * CredentialScope + '\n' + <br />
 * HashedCanonicalRequest))
 * 
 * Authorization: AWS4-HMAC-SHA256 Credential=AKIDEXAMPLE/20110909/us-east-1/iam/aws4_request, SignedHeaders=content-type;host;x-amz-date,
 * Signature=ced6826de92d2bdeed8f846f0bf508e8559e98e4b0199114b84c54174deb456c
 * 
 */
public class AmazonSigner {
 
 public static final String POST_METHOD = "POST";
 private final static char[] BASE16MAP = new char[] { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
  
 private String timestamp;
 private String date;
 private String signedHeaders;
 private String awsAccessKeyId;
 private String awsSecretKey;
 private String region;
 private String service;
 private String url;
 private String host;
 
 public AmazonSigner(String awsAccessKeyId, String awsSecretKey, String region, String service, String url, String host) {
  this.awsAccessKeyId = awsAccessKeyId;
  this.awsSecretKey = awsSecretKey;
  this.region = region;
  this.service = service;
  this.url = url;
  this.host = host;
 }

 public HttpPost getSignedPostRequest(String uri, String queryString, Map<String, String> headersInput, String payload) throws Exception{
  setCurrentTimedate();
  headersInput.put("host", host);
  headersInput.put("x-amz-date", getTimestamp());
  String canonicalRequest = createCanonicalRequest(POST_METHOD, uri, queryString, headersInput, payload);
//  System.out.println("\nCanonicalRequest: \n" + canonicalRequest);
  String stringToSign = createStringToSign(canonicalRequest);
//  System.out.println("\nStringToSign: \n" + stringToSign);
  String signature = sign(stringToSign);
//  System.out.println("\nSignature: \n" + signature);
  String autorizationHeader = "AWS4-HMAC-SHA256 Credential="+awsAccessKeyId+"/" + getCredentialScope() + ", SignedHeaders="+signedHeaders+", Signature=" + signature;
//  System.out.println("\nAutorizationHeader: \n" + autorizationHeader);

  HttpPost request = new HttpPost(url);
  for (String key : headersInput.keySet()) {
    request.addHeader(key, headersInput.get(key));
  }
  request.addHeader("Authorization", autorizationHeader);
  StringEntity input = new StringEntity(payload);
  request.setEntity(input);
  return request;
 }
 
 private String sign(String stringToSign) throws Exception {
  return Hex.encodeHexString(hmacSHA256(stringToSign, getSignatureKey()));
 }
 
 private void setCurrentTimedate() {
  Calendar cal = Calendar.getInstance();
  DateFormat dfmT = new SimpleDateFormat("yyyyMMdd'T'HHmmss'Z'");
  dfmT.setTimeZone(TimeZone.getTimeZone("GMT"));
  timestamp = dfmT.format(cal.getTime());
  DateFormat dfmD = new SimpleDateFormat("yyyyMMdd");
  dfmD.setTimeZone(TimeZone.getTimeZone("GMT"));
  date = dfmD.format(cal.getTime());
 }
 
 private String createCanonicalRequest(String method, String uri, String queryString, Map<String, String> headersInput, String payload) throws Exception {
  SortedMap<String, String> headersSorted = new TreeMap<String, String>(headersInput);
  StringBuffer headers = new StringBuffer();
  StringBuffer signedHeaders = new StringBuffer();
  Iterator<Map.Entry<String, String>> iter = headersSorted.entrySet().iterator();
  while (iter.hasNext()) {
   Map.Entry<String, String> kvpair = iter.next();
   headers.append(kvpair.getKey() + ":" + kvpair.getValue() + "\n");
   signedHeaders.append(kvpair.getKey());
   if (iter.hasNext()) {
    signedHeaders.append(";");
   }
  }
  this.signedHeaders = signedHeaders.toString();
  String result = method + "\n" + uri + "\n" + queryString + "\n" + headers.toString() + "\n" + signedHeaders.toString() + "\n" + toBase16(hash(payload));
  return result;
 }
 
 private String createStringToSign(String data) throws Exception {
  return "AWS4-HMAC-SHA256\n" + getTimestamp() + "\n" + getCredentialScope() + "\n" + toBase16(hash(data));
 }
 
 private String getCredentialScope() {
  return getDate() + "/"+region+"/"+service+"/aws4_request";
 }
 
 private static byte[] hash(String data) throws Exception {
  MessageDigest md = MessageDigest.getInstance("SHA-256");
  md.update(data.getBytes("UTF-8"));
  byte[] digest = md.digest();
  return digest;
 }
 
 private static String toBase16(byte[] data) {
  StringBuffer hexBuffer = new StringBuffer(data.length * 2);
  for (int i = 0; i < data.length; i++) {
   hexBuffer.append(BASE16MAP[(data[i] >> (4)) & 0xF]);
   hexBuffer.append(BASE16MAP[(data[i] >> (0)) & 0xF]);
  }
  return hexBuffer.toString();
 }
 
 private byte[] getSignatureKey() throws Exception {
  byte[] kSecret = ("AWS4" + awsSecretKey).getBytes("UTF8");
  byte[] kDate = hmacSHA256(getDate(), kSecret);
  byte[] kRegion = hmacSHA256(region, kDate);
  byte[] kService = hmacSHA256(service, kRegion);
  byte[] kSigning = hmacSHA256("aws4_request", kService);
  return kSigning;
 }
 
 private static byte[] hmacSHA256(String data, byte[] key) throws Exception {
  String algorithm = "HmacSHA256";
  Mac mac = Mac.getInstance(algorithm);
  mac.init(new SecretKeySpec(key, algorithm));
  return mac.doFinal(data.getBytes("UTF8"));
 }
 
 private String getTimestamp() {
  return timestamp;
 }
 
 private String getDate() {
  return date;
 }

}
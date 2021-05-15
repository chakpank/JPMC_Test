package resources;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Utils {
	
	public static RequestSpecification req;
	public static ResponseSpecification resp;
	
	private static FileReader fr;
	private static Properties prop;
	private static String fileName = "src/test/java/resources/TestProperty.properties";
	public static String baseURL = "URL";
	public static String invalid_resource = "INVALID_RESOURCE";
	public static String attribute = "ID_ATTRIBUTE";
	public static String server = "SERVER";
	public static String attribute_Body = "BODY_ATTRIBUTE";


	// Method for creating and sharing the Request Specification using RequestSpecBuilder
	
	public RequestSpecification requestSpecification() throws FileNotFoundException {
		
		if(req == null) {
			
			PrintStream log = new PrintStream("logger.txt");
			
			req =  new RequestSpecBuilder().setBaseUri(Utils.getbaseURL())
					.addFilter(RequestLoggingFilter.logRequestTo(log))
					.addFilter(ResponseLoggingFilter.logResponseTo(log))
					.setContentType(ContentType.JSON).build();
			
			return req;
			
		}
		
		
		return req;
	}
	
	// Method for creating and sharing the Response Specification using ResponseSpecBuilder
	
	public ResponseSpecification responseSpecification(int statuscode) {
		
		
		resp = new ResponseSpecBuilder().expectStatusCode(statuscode)
				.expectContentType(ContentType.JSON).build();
		
		return resp;
	}
	
	
	// Utilty Method to read the properties file
	public static String readPropertyValue(String attributeName, String path) {
		
		try {
			fr = new FileReader(path);
			prop = new Properties();
			prop.load(fr);
			
			// Getting required attributes from properties file
			String attributeValue = prop.getProperty(attributeName);
			return attributeValue;
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	
		
	// Method to return the Base URI from properties file
	public static String getbaseURL() {		
		String value = readPropertyValue(baseURL,fileName);
		return value;
	}
	

	//Method to return the invalid resource to perform in Social Media from properties file
	public static String getInvalidResource() {		
		String value = readPropertyValue(invalid_resource,fileName);
		return value;
	}
	
	// Method to return the attribute name to be validated in the response from properties file 
	public static String validateAttributeFromResponse() {
		String value = readPropertyValue(attribute,fileName);
		return value;
	}
	
	// Method to return the attribute name to be validated in the response from properties file 
	public static String validateBodyAttributeFromResponse() {
		String value = readPropertyValue(attribute_Body,fileName);
		return value;
	}
	
	// Method to return the attribute name to be validated in the response from properties file
	public static String validateServerAttributeFromResponse() {
		String value = readPropertyValue(server,fileName);
		return value;
	}	

}

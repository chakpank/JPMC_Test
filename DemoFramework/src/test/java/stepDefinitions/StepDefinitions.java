package stepDefinitions;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.util.HashMap;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import pojo.CreatePost;
import resources.ApiResources;
import resources.TestDataBuilder;
import resources.Utils;

public class StepDefinitions extends Utils{
	
	TestDataBuilder dataBuider;
	RequestSpecification reqSpec;
	Response response;
	Response incorrectresponse;
	JsonPath jsPath;
	
	HashMap<String,String> headerMap;
	
	@Given("Setup is ready to list users")
	public void setup_is_ready_to_list_users() {
		
		try {
			reqSpec = given().spec(requestSpecification());	

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}

	}

	
	
	@Given("Create Post Payload")
	public void create_post_payload() {
		
		try {
			reqSpec = given().headers(TestDataBuilder.getHeaders())
					.spec(requestSpecification())
					.body(TestDataBuilder.CreatePostPayload());
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}
				
	}
	
	@Given("Create Comment Payload is ready")
	public void create_comment_payload_is_ready() {
		try {
			reqSpec = given().headers(TestDataBuilder.getHeaders())
					.spec(requestSpecification())
					.body(TestDataBuilder.CreateCommentPayload());
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}
	}
	
	@Given("Create Post Payload with {int} {int} {string} {string}")
	public void create_post_payload_with(Integer int1, Integer int2, String string, String string2) {
		
		try {
			reqSpec = given().headers(TestDataBuilder.getHeaders())
					.spec(requestSpecification())
					.body(TestDataBuilder.CreatePostPayloadWithData(int1, int2, string, string2));
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}
		
	}
	
	@Given("Create Comment Payload with {int} {int} {string} {string} {string}")
	public void create_comment_payload_with(Integer postId, Integer id, String name, String email, String text) {
		
		try {
				reqSpec = given().spec(requestSpecification())
						.body(TestDataBuilder.CreateCommentPayloadWithData(postId, id, name, email, text));
			} catch (FileNotFoundException e) {

				e.printStackTrace();
			}

	}
	

	@When("User calls {string} with {string} http request")
	public void user_calls_with_post_http_request(String resource, String httpMethod) {
	
		ApiResources resourceAPI = ApiResources.valueOf(resource);
		if(httpMethod.equalsIgnoreCase("POST")) {
			
			response = reqSpec.when().post(resourceAPI.getResource())
					.then().spec(responseSpecification(201)).extract().response();
			
		}else if (httpMethod.equalsIgnoreCase("GET")) {
			
			response = reqSpec.when().get(resourceAPI.getResource())
						.then().spec(responseSpecification(200)).extract().response();
		}
		
		
	}
	
	@When("User calls {string} with {string} http request and invalid resource")
	public void user_calls_with_post_http_request_with_invalid_resource(String resource, String httpMethod) {
	
		
		if(httpMethod.equalsIgnoreCase("POST")) {
			
			incorrectresponse = reqSpec.when().post(Utils.getInvalidResource())
					.then().spec(responseSpecification(404)).extract().response();
			
		}else if (httpMethod.equalsIgnoreCase("GET")) {
			
			incorrectresponse = reqSpec.when().get(Utils.getInvalidResource())
						.then().spec(responseSpecification(404)).extract().response();
		}
		
	}

	@Then("the API call is successful with status code {int}")
	public void the_api_call_is_successful_with_status_code(int int1) {
		assertEquals(response.getStatusCode(),int1);

	}
	
	@Then("the API call is unsuccessful with status code {int}")
	public void the_api_call_is_unsuccessful_with_status_code(int int1) {
		assertEquals(incorrectresponse.getStatusCode(),int1);

	}

	@Then("Post {string} is {int}")
	public void post(String str, int int1) {
		String resp = response.asString();
		jsPath = new JsonPath(resp);	
		assertEquals(jsPath.getInt(Utils.validateAttributeFromResponse()),int1);	

	}
	
	@Then("Post {string} is {string}")
	public void postServer(String headerAttribute, String serverName) {
		assertEquals(response.getHeader(headerAttribute),serverName);

	}
	
	@Then("Verify content of Post matches with {string}")
	public void verify_content_of_post_matches_with(String string) {

		String resp = response.asString();
		jsPath = new JsonPath(resp);	
		assertEquals(jsPath.get(Utils.validateBodyAttributeFromResponse()),string);
	  
	}

}

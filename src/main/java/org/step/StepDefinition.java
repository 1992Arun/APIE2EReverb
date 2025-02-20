package org.step;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Assert;
import org.utility.APIEndPoints;
import org.utility.Builder;
import org.utility.ExcelReader;

import com.fasterxml.jackson.core.JsonProcessingException;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class StepDefinition extends Builder {

	public static RequestSpecification spec;

	public static Response response;

	public static List<Integer> id = new ArrayList();;

	public static String[][] reader;

	@Given("I added baseuri and RequestSpec")
	public void i_added_baseuri_and_RequestSpec() {

		spec = RestAssured.given().spec(getRequestSpecBuilder());
		
		

	}

	@When("I send the {string} request with {string} endpoint")
	public void i_send_the_request_with_endpoint(String string, String string2)
			throws ParseException, JsonProcessingException {

		APIEndPoints valueOf = APIEndPoints.valueOf(string2);

		String endpoint = valueOf.getResource();

		if (string.equalsIgnoreCase("GET")) {

			response = spec.when().get(endpoint);

		} else if (string.equalsIgnoreCase("POST")) {

			// for (int i = 0; i < reader.length; i++) {

			reader = ExcelReader.reader(System.getProperty("user.dir") + "\\src\\test\\resources\\NewFile.xlsx",
					"POST");

			for (int i = 0; i < reader.length; i++) {

				String title = reader[i][0];

				String description = reader[i][1];

				String amount = reader[i][2];

				String currency = reader[i][3];

				String uuid = reader[i][4];

				String price = reader[i][5];

				String region = reader[i][6];

				spec = spec.body(postRequestBody(title, description, amount, currency, uuid, price, region));

				response = spec.when().post(endpoint);

				i_verify_request_response_is(string, getResponseCode(response));

			}

		} else if (string.equalsIgnoreCase("PUT")) {

			reader = ExcelReader.reader(System.getProperty("user.dir") + "\\src\\test\\resources\\NewFile.xlsx",
					"PUT");
			
			System.out.println(id);

			for (int i = 0; i < reader.length; i++) {

				String updatedtitle = reader[i][0];

				String updateddescription = reader[i][1];

				String updatedamount = reader[i][2];

				String currency = reader[i][3];

				String uuid = reader[i][4];

				spec = spec.body(putRequestbody(updatedtitle, updateddescription, updatedamount, currency, uuid));

				response = spec.when().put(endpoint + id.get(i));

				i_verify_request_response_is(string, getResponseCode(response));

			}

		} else if (string.equalsIgnoreCase("DELETE")) {
			
			for(int i=0;i<id.size()-1;i++) {

			response = spec.when().delete(endpoint + id.get(i));
			
			i_verify_request_response_is(string, getResponseCode(response));
			
			}
		}

	}

	@Then("I verify {string} request response is {int}")
	public void i_verify_request_response_is(String string, int int1) throws ParseException {

		if (string.equalsIgnoreCase("GET")) {
			
			
			
			response = response.then().spec(getResponseSpecBuilder(int1)).extract().response();
			
			
			JSONParser jo = new JSONParser();

			Object parse = jo.parse(getResponseBody(response));

			JSONObject ob = (JSONObject) parse;

			Object listings = ob.get("listings");

			JSONArray ob1 = (JSONArray) listings;

			Object object = ob1.get(0);

			JSONObject ob3 = (JSONObject) object;

			Object id = ob3.get("id");

			Object model = ob3.get("model");

			// JSONObject ob2 = (JSONObject)object;
			//
			// Object object2 = ob2.get("href");

			System.out.println("GET response Code: " + getResponseCode(response));

			Assert.assertTrue((id instanceof Long));

			Assert.assertTrue((model instanceof String));

		}

		else if (string.equalsIgnoreCase("POST")) {

			response = response.then().spec(getResponseSpecBuilder(int1)).extract().response();
			
			response.then().body(JsonSchemaValidator.matchesJsonSchema(schema()));
			
			response.then().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schema/Post.json"));

			
			JsonPath j = new JsonPath(response.body().asString());
			
			id.add((Integer) j.get("listing.id"));

			System.out.println("POST response Code: " + getResponseCode(response));
			
			Assert.assertEquals(int1, getResponseCode(response));

		} else if (string.equalsIgnoreCase("PUT")) {

			response = response.then().spec(getResponseSpecBuilder(int1)).extract().response();

			response.then().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schema/put.json"));
	
			JsonPath j = new JsonPath(response.body().asString());

			System.out.println("PUT response Code: " + getResponseCode(response));
			
			if(getResponseCode(response)!=200) {
				
				Assert.fail();
				
		         }else {
		        	 
		        	 Assert.assertEquals(int1, getResponseCode(response));
		        	 
		         }
			

		} else if (string.equalsIgnoreCase("DELETE")) {

			response = response.then().spec(getResponseSpecBuilder(int1)).extract().response();

			System.out.println("DELETE response Code: " + getResponseCode(response));
			

			Assert.assertEquals(int1, getResponseCode(response));
		}

	}



}

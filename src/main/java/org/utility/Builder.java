package org.utility;

import java.io.FileNotFoundException;
import java.io.PrintStream;

import io.restassured.authentication.PreemptiveOAuth2HeaderScheme;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Builder extends Utility {
	
	
	public static RequestSpecification getRequestSpecBuilder(){
		
		PrintStream p = null;
		
		try {
			
			p = new PrintStream("log.txt");
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
			
		RequestSpecBuilder spec = new RequestSpecBuilder();
		
		spec.setBaseUri(getProperty("baseURI"));
		
		spec.addHeader(getProperty("verion"), getProperty("value"));
		
		spec.setContentType(getProperty("content"));
		
		spec.addFilter(RequestLoggingFilter.logRequestTo(p));
		
		spec.addFilter(ResponseLoggingFilter.logResponseTo(p));
		
		PreemptiveOAuth2HeaderScheme au  = new PreemptiveOAuth2HeaderScheme();
		
		au.setAccessToken(getProperty("token"));
		
		spec.setAuth(au);
		
		RequestSpecification build = spec.build();
		
		return build;
		 
		
	}
	
	
	public static ResponseSpecification getResponseSpecBuilder(int code){
		
		
		ResponseSpecBuilder spec = new ResponseSpecBuilder();
		
		ResponseSpecification build = spec.expectStatusCode(code).build();
		
		
		return build;
		
		
	}
	
	
	

}

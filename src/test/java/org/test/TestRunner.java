package org.test;

import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.utility.Utility;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)

@CucumberOptions(features="src/test/resources", glue="org.step", tags="@E2E", plugin="json:src\\test\\resources\\Reports\\jsonreport.json")
public class TestRunner {

	
	@AfterClass
	public static void reports() {
		
		
		Utility.getJVMReport("src\\test\\resources\\Reports\\jsonreport.json");
		
		
	}
	
}



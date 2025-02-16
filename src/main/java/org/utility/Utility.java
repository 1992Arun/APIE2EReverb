package org.utility;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

import org.postRequest.Condition;
import org.postRequest.Domestic;
import org.postRequest.Parent;
import org.postRequest.Price;
import org.postRequest.Shipping;
import org.putRequestBody.PutCondition;
import org.putRequestBody.PutParent;
import org.putRequestBody.PutPrice;

import io.restassured.response.Response;
import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

public class Utility {


	public static String getResponseBody(Response response) {

		return response.getBody().asString();

	}

	public static int getResponseCode(Response response) {

		return response.getStatusCode();

	}




	public static String getProperty(String key) {

		Properties p = null ;

		try {

			FileReader f = new FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\Confic.properties");

			p = new Properties();

			p.load(f);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}



		return p.getProperty(key);

	}



	public static Parent postRequestBody(String title, String description, String amount, String currency, String uuid, String price, String region )  {
		
		Parent p = new Parent();

		Domestic d = new Domestic();

		d.setPrice(price);
		
		d.setRegion(region);

		Shipping s = new Shipping();

		s.setDomestic(d);

		Condition c = new Condition();

		c.setUuid(uuid);

		Price pr = new Price();

		pr.setAmount(amount);

		pr.setCurrency(currency);

		p.setDescription(description);

		p.setTitle(title);

		p.setPrice(pr);

		p.setShipping(s);

		p.setCondition(c);

//		ObjectMapper ob = new ObjectMapper();
//
//		String writer = ob.writeValueAsString(p);
//
//		System.out.println(writer);
		return p;
	
	}
		
		public static Parent postRequestBody() {

		Parent p = new Parent();

		Domestic d = new Domestic();

		d.setPrice(getProperty("price"));
		
		d.setRegion(getProperty("region"));

		Shipping s = new Shipping();

		s.setDomestic(d);

		Condition c = new Condition();

		c.setUuid(getProperty("uuid"));

		Price pr = new Price();

		pr.setAmount(getProperty("amount"));

		pr.setCurrency(getProperty("currency"));

		p.setDescription(getProperty("description"));

		p.setTitle(getProperty("title"));

		p.setPrice(pr);

		p.setShipping(s);

		p.setCondition(c);

//		ObjectMapper ob = new ObjectMapper();
//
//		String writer = ob.writeValueAsString(p);
//
//		System.out.println(writer);
		return p;


	}
	
	
	
	public static PutParent putRequestbody(){
		
		PutParent pput = new PutParent();
		
		PutPrice pr = new PutPrice();
		
		PutCondition c = new PutCondition();
		
		pr.setAmount(getProperty("updatedamount"));
		
		pr.setCurrency(getProperty("currency"));
		
		c.setUuid(getProperty("uuid"));
		
		pput.setCondition(c);
		
		pput.setPrice(pr);
		
		pput.setDescription(getProperty("updateddescription"));
		
		pput.setTitle(getProperty("updatedtitle"));
		
		return pput;
		
//		ObjectMapper ob = new ObjectMapper();
//
//		String writer = ob.writeValueAsString(pput);
//
//		System.out.println(writer);
		
	}
	
	
	public static void getJVMReport(String json) {
		
		File f = new File(System.getProperty("user.dir")+"\\src\\test\\resources\\Reports\\JVM.html");
		
		Configuration conf = new Configuration(f, "API Requests");
		
		conf.addClassifications("UserName", System.getProperty("user.name"));
		
		List<String> li = new LinkedList();
		
		li.add(json);
		
		ReportBuilder rb = new ReportBuilder(li, conf);
		
		rb.generateReports();
		
	}
	

}

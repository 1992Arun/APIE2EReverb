package org.utility;

public enum APIEndPoints {
	
	getRequest("listings"),
	
	createListing("listings"),
	
	updateListing("listings/"),
	
	deleteDraft("listings/");
	
	String resource;
	
	APIEndPoints(String reo){
		
		this.resource=reo;
		
	}

	public String getResource() {
		return resource;
	}
	
	
	

}

package org.putRequestBody;

public class PutParent {

	private String title;

	private String description;

	private PutPrice price;

	public String getTitle() {
		return title;
	}

	public String getDescription() {
		return description;
	}

	public PutPrice getPrice() {
		return price;
	}

	public PutCondition getCondition() {
		return condition;
	}

	private PutCondition condition;
	
	
	

	public void setTitle(String title) {
		this.title = title;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setPrice(PutPrice price) {
		this.price = price;
	}

	public void setCondition(PutCondition condition) {
		this.condition = condition;
	}

	
}

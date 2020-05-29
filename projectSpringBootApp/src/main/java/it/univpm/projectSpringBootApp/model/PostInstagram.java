package it.univpm.projectSpringBootApp.model;

import com.fasterxml.jackson.annotation.JsonPropertyDescription;

public class PostInstagram {
	
	@JsonPropertyDescription("id del post")
	private String id;
	
	@JsonPropertyDescription("Data del post")
	private String creation_date;
	
	@JsonPropertyDescription("tipologia del post")
	private String type;

	public PostInstagram() {
		
	}
	
	public PostInstagram(String id, String creation_date, String type) {
		
	}
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCreation_date() {
		return creation_date;
	}

	public void setCreation_date(String creation_date) {
		this.creation_date = creation_date;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}

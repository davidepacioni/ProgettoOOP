package it.univpm.projectSpringBootApp.model;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

import com.fasterxml.jackson.annotation.JsonPropertyDescription;

public class PostInstagram {

	@JsonPropertyDescription("id del post")
	private String id;

	@JsonPropertyDescription("Data del post")
	private LocalDate creation_date;

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

	public LocalDate getCreation_date() {
		return creation_date;
	}

	public void setCreation_date(String date) throws ParseException {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss+SSSS", Locale.ITALY);
		LocalDateTime creation = LocalDateTime.parse(date, formatter);
		creation_date= creation.toLocalDate();
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;

	}
	
	@Override
	public String toString() {
		return "id: " + id + "\ttipologia: " + type + "\tdata: " + creation_date+"\n";
	}
}

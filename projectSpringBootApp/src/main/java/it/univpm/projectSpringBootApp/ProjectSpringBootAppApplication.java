package it.univpm.projectSpringBootApp;

import org.json.JSONObject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import it.univpm.projectSpringBootApp.utility.DownloadJSON;

@SpringBootApplication
public class ProjectSpringBootAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectSpringBootAppApplication.class, args);
		JSONObject json = DownloadJSON.JSONfromURL();
		
		System.out.println(json);
		
	}

}

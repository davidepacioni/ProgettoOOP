package it.univpm.projectSpringBootApp;

import java.util.ArrayList;


import org.json.JSONObject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import it.univpm.projectSpringBootApp.utility.*;
import it.univpm.projectSpringBootApp.model.*;
@SpringBootApplication
public class ProjectSpringBootAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectSpringBootAppApplication.class, args);
		JSONObject json = DownloadJSON.getCompleteJSON();
		ArrayList<PostInstagram> lista = ParseJSON.JSONParsr(json);
		System.out.println(lista);
		
	}

}

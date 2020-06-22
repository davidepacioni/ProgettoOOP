package it.univpm.projectSpringBootApp.service;

import java.util.ArrayList;
import java.util.Collection;

import org.json.JSONObject;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.module.jsonSchema.JsonSchemaGenerator;

import it.univpm.projectSpringBootApp.model.PostInstagram;
import it.univpm.projectSpringBootApp.utility.DownloadJSON;
import it.univpm.projectSpringBootApp.utility.ParseJSON;

@Service
public class PostServiceImp implements PostService {

	private static ArrayList<PostInstagram> lista;
	
	public PostServiceImp() {
		try {
			lista = ParseJSON.JSONParsr(DownloadJSON.getCompleteJSON());
			//System.out.println(lista);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public static Collection<PostInstagram> getPost(){
		if(lista.isEmpty()) {
			//TODO creare e lanciare eccezione lista vuota
		}
		return lista;
	}


	public String getMetadata(Class<?> classe) {
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			JsonSchemaGenerator schemaGenerator = new JsonSchemaGenerator(objectMapper);
			com.fasterxml.jackson.module.jsonSchema.JsonSchema schema = schemaGenerator.generateSchema(classe);
			return objectMapper.writeValueAsString(schema);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
}

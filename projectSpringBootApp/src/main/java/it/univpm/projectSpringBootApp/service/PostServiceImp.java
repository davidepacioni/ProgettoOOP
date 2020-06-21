package it.univpm.projectSpringBootApp.service;

import java.util.ArrayList;
import java.util.Collection;

import org.json.JSONObject;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.stereotype.Service;

import it.univpm.projectSpringBootApp.model.PostInstagram;
import it.univpm.projectSpringBootApp.utility.DownloadJSON;
import it.univpm.projectSpringBootApp.utility.ParseJSON;

@Service
public class PostServiceImp implements PostService {

	private static ArrayList<PostInstagram> lista;
	
	public PostServiceImp() {
		try {
			lista = ParseJSON.JSONParsr(DownloadJSON.getCompleteJSON());
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public static Collection<PostInstagram> getPost(){
		if(lista.isEmpty()) {
			//lanciare eccezione lista vuota
		}
		return lista;
	}
}

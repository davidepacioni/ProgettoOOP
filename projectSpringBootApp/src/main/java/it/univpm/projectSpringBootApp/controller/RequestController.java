package it.univpm.projectSpringBootApp.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RequestController {
	
	/**
	 * Rotta che mostra tutti i post presenti nel JSON scaricato
	 * @return Restituisce i post 
	 */
	@RequestMapping(value = "/data", method = RequestMethod.GET)
	public ResponseEntity<Object> getPosts() {
		
		return new ResponseEntity<>(service.getPost(), HttpStatus.OK);
	}
}

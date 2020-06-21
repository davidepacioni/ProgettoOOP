package it.univpm.projectSpringBootApp.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import it.univpm.projectSpringBootApp.service.PostServiceImp;

@RestController
public class RequestController {
	
	/**
	 * Rotta che restituisce i post in formato JSON
	 * @return Restituisce i post in formato JSON
	 */
	@RequestMapping(value = "/data", method = RequestMethod.GET)
	public ResponseEntity<Object> getPosts() {
		return new ResponseEntity<Object>(PostServiceImp.getPost(), HttpStatus.OK);
	}
}

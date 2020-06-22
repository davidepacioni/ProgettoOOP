package it.univpm.projectSpringBootApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParser;

import it.univpm.projectSpringBootApp.service.PostServiceImp;
import it.univpm.projectSpringBootApp.utility.ParseJSON;
import it.univpm.projectSpringBootApp.exception.FilterIllegalArgumentException;
import it.univpm.projectSpringBootApp.exception.FilterNotFoundException;
import it.univpm.projectSpringBootApp.exception.InternalGeneralException;
import it.univpm.projectSpringBootApp.model.*;
@RestController
public class RequestController {
	
	@Autowired
	PostServiceImp service;
	/**
	 * Rotta che restituisce i post in formato JSON
	 * @return Restituisce i post in formato JSON
	 */
	@RequestMapping(value = "/data", method = RequestMethod.GET)
	public ResponseEntity<Object> getPosts() {
		return new ResponseEntity<Object>(PostServiceImp.getPost(), HttpStatus.OK);
	}
	
	/**
	 * Rotta che restituisce i metadati in formato JSON, ossia l'elenco delgi attributi e i relativi tipi di dato
	 * @return Restituisce i metadati in formato JSON
	 */
	@RequestMapping(value = "/metadata", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<Object> getMetadati() {
		String meta = service.getMetadata(PostInstagram.class);
		return new ResponseEntity<Object>(meta, HttpStatus.OK);
	}
	
	/**
	 * Rotta che restituisce i metadati in formato JSON, ossia l'elenco delgi attributi e i relativi tipi di dato
	 * @return Restituisce i metadati in formato JSON
	 * @throws InternalGeneralException 
	 * @throws FilterIllegalArgumentException 
	 * @throws FilterNotFoundException 
	 */
	@RequestMapping(value = "/data", method = RequestMethod.POST)
	public ResponseEntity<Object> getFilteredPosts(@RequestBody Object filter) throws FilterNotFoundException, FilterIllegalArgumentException, InternalGeneralException {
		System.out.println("dentro 2");
		System.out.println(filter);
		return new ResponseEntity<>(ParseJSON.JsonParserColumn(filter), HttpStatus.CREATED);
	}
	
	
}

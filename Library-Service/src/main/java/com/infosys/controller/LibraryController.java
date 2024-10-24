package com.infosys.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.infosys.entity.Library;
import com.infosys.response.LibraryResponse;
import com.infosys.service.LibraryService;

@RestController
public class LibraryController {
	
	@Autowired
	private LibraryService service;

	@GetMapping("/get")
	public ResponseEntity<List<Library>> getAll(){
		List<Library> libraries = service.getAll();
		return new ResponseEntity<List<Library>>(libraries,HttpStatus.OK);
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<LibraryResponse> getById(@PathVariable("id") Integer id){
		LibraryResponse libraryResponse = service.getLibraryResponse(id);
		
		return new ResponseEntity<LibraryResponse>(libraryResponse,HttpStatus.OK);
		
	}
	
	@GetMapping("/get/book/{bid}")
	public ResponseEntity<List<Library>> getByBid(@PathVariable("bid") Integer bid){
		List<Library> library = service.getByBid(bid);
		return new ResponseEntity<List<Library>>(library,HttpStatus.OK);
		
	}
	
}

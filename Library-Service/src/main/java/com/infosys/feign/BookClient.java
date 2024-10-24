package com.infosys.feign;


import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;





@FeignClient(name = "Book-Service",url ="http://localhost:8081",path = "/book")
public interface BookClient {

	@GetMapping(value = "/get", produces = "application/json")
	public ResponseEntity<List<Book>> getAll();

	@GetMapping(value = "/get/{id}", produces = "application/json")
	public ResponseEntity<Book> getById(@PathVariable("id") Integer id);

	@PostMapping(value = "/add", consumes = "application/json")
	public ResponseEntity<Book> addBook(@RequestBody Book book);

	@DeleteMapping("/del/{id}")
	public ResponseEntity<Book> deleteBook(@PathVariable("id") Integer id);

	@PutMapping(value = "/upadte/{id}", consumes = "application/json")
	public ResponseEntity<Book> UpdateBook(@PathVariable("id") Integer id, @RequestBody Book book);
}

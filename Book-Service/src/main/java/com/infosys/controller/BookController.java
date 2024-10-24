package com.infosys.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.infosys.entity.Book;
import com.infosys.service.BookService;

@RestController
public class BookController {

	@Autowired
	private BookService service;

	@GetMapping(value = "/get", produces = "application/json")
	public ResponseEntity<List<Book>> getAll() {
		List<Book> books = service.getAll();
		return new ResponseEntity<List<Book>>(books, HttpStatus.OK);

	}

	@GetMapping(value = "/get/{id}", produces = "application/json")
	public ResponseEntity<Book> getById(@PathVariable("id") Integer id) {
		Book book = service.getByid(id);
		return new ResponseEntity<Book>(book, HttpStatus.OK);
	}

	@PostMapping(value = "/add", consumes = "application/json")
	public ResponseEntity<Book> addBook(@RequestBody Book book) {
		service.addBook(book);
		return new ResponseEntity<Book>(book, HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/del/{id}")
	public ResponseEntity<Book> deleteBook(@PathVariable("id") Integer id) {
		Book book = service.deleteById(id);
		return new ResponseEntity<Book>(book, HttpStatus.OK);
	}

	@PutMapping(value = "/upadte/{id}", consumes = "application/json")
	public ResponseEntity<Book> UpdateBook(@PathVariable("id") Integer id, @RequestBody Book book) {
		Book book1 = service.updateBook(book);
		return new ResponseEntity<Book>(book1,HttpStatus.ACCEPTED);

	}

}

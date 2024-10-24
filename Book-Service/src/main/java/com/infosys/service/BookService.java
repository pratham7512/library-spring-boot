package com.infosys.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infosys.entity.Book;
import com.infosys.repository.BookRepository;

@Service
public class BookService {

	@Autowired
	private BookRepository bookRepository;
	
	public List<Book> getAll(){
		List<Book> books = bookRepository.findAll();
		return books;
	}
	
	public Book getByid(Integer id) {
		return bookRepository.findById(id).get();
	}
	
	public void addBook(Book book) {
		bookRepository.save(book);
	}
	
	public Book deleteById(Integer id) {
		Book book = bookRepository.findById(id).get();
		bookRepository.delete(book);
		return book;
	}
	
	public Book updateBook(Book book) {
		bookRepository.updateBookById(book.getPublicationYear(), book.getAuthor(), book.getId());
		return bookRepository.findById(book.getId()).get();
	}
}

package com.infosys.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infosys.entity.Library;
import com.infosys.feign.Book;
import com.infosys.feign.BookClient;
import com.infosys.repository.LibraryRepository;
import com.infosys.response.BookResponse;
import com.infosys.response.LibraryResponse;

@Service
public class LibraryService {
	
	@Autowired
	private BookClient bookClient;
	
	@Autowired
	private LibraryRepository libraryRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	public List<Library> getAll(){
		List<Library> libraries = libraryRepository.findAll();
		return libraries;
	}
	
	public LibraryResponse getLibraryResponse(Integer id) {
		Library library = libraryRepository.findById(id).get();
		LibraryResponse libraryResponse = modelMapper.map(library, LibraryResponse.class);
		Book book = bookClient.getById(id).getBody();
		BookResponse bookResponse = modelMapper.map(book, BookResponse.class);
		libraryResponse.setBook(bookResponse);
		return libraryResponse;
	}
	
	public List<Library> getByBid(Integer id) {
		return libraryRepository.findByBookid(id);
	}

}

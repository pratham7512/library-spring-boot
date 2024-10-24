package com.infosys.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.infosys.entity.Book;

import jakarta.transaction.Transactional;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
	
	@Transactional
	@Modifying(clearAutomatically = true)
	@Query(value = "update book set publication_year=?,author=? where id=?",nativeQuery = true)
	public void updateBookById(Long publicationYear,String author,Integer id );

}

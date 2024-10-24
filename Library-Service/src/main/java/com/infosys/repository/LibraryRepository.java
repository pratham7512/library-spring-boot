package com.infosys.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.infosys.entity.Library;

@Repository
public interface LibraryRepository extends JpaRepository<Library, Integer>{
	
	public List<Library> findByBookid(Integer id);

}

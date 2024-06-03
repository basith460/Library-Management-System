package com.gl.springboot8.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gl.springboot8.model.Library;

@Repository
public interface LibraryRepository extends JpaRepository<Library,Integer>{
	
	
	
	
}

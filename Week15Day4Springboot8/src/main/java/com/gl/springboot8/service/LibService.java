package com.gl.springboot8.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.gl.springboot8.model.Library;
import com.gl.springboot8.repository.LibraryRepository;

@Service
public class LibService {

	@Autowired
	LibraryRepository lrepo;

	public void add(Library lib) {
		lrepo.save(lib);

	}

	public List<Library> getAll(){
		return lrepo.findAll();
	}

	public Library getById(int id) {
		Optional<Library> loptional=lrepo.findById(id);

		Library temp=null;
		if(loptional.get()!=null) {
			temp=loptional.get();

		}
		return temp;

	}
	public Library findById(int id) {
		if(lrepo.findById(id).isEmpty()) {
			return null;
		}
		else {
			return lrepo.findById(id).get();
		}
	}

	public void delete(Library lib) {
		lrepo.delete(lib);
	}

	public void addBulk(List<Library> lib) {
		lrepo.saveAll(lib);
	}


	public Page<Library> getBypageSort(int pageNumber,Direction direction,String columnName,int rowPerPage){

		//does not care about the ordering/direction
		//Pageable page=PageRequest.of(pageNumber, rowPerPage);

		Pageable page=PageRequest.of(pageNumber,rowPerPage,direction,columnName);

		return lrepo.findAll(page);	
	}

	public Page<Library> getBypageOnly(int pageNumber,int rowPerPage){
		Pageable page=PageRequest.of(pageNumber, rowPerPage);
		return lrepo.findAll(page);
	}

	public List<Library> getBySortOnly(String columns,Direction direction){

		return lrepo.findAll(Sort.by(direction,columns));
	}

	//filter
//	public List<Library> filter(String columnName,String searchKey) {
//		//		if(columnName.equals("name")) {
	//			dummy.setName(searchKey);
	//		}
	//		else if(columnName.equals("publisher")) {
	//			dummy.setPublisher(searchKey);
	//		}
//		
//		
//	}

		public List<Library> filterByName(String searchKey){


			//1.create a dummy obj based on the searchKey
			Library dummy=new Library();
			dummy.setName(searchKey);

			
			//		
			//2. create Example JPA -- where

			ExampleMatcher em=ExampleMatcher.matching().withMatcher("name", ExampleMatcher.GenericPropertyMatchers.contains()).withIgnorePaths("id","comma_separated_booknames","subject","publisher");

			//3.combining dummy with where

			Example<Library> example=Example.of(dummy,em);

			return lrepo.findAll(example);

		}
		
		
		

	}





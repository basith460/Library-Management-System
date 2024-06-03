package com.gl.springboot8.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gl.springboot8.model.Library;
import com.gl.springboot8.service.LibService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
public class SwaggerController {
	
	@Autowired
	LibService libservice;
	
		@GetMapping(value="/api/addition")
		public int add(@RequestParam int a,@RequestParam int b) {
			
			return a+b;
		}
		
		@GetMapping("/api/getAllLibraries")
		public List<Library> getAllLib(){
			return libservice.getAll();
			
		}
		
		@GetMapping("api/getById")
		public Library getById(@RequestParam int id) {
			return libservice.getById(id);
		}
		
		@PostMapping("api/addNewLib")
		public String addLib(@RequestParam int id,@RequestParam String name,@RequestParam String books,@RequestParam String subject,@RequestParam String publisher ) {
			
			Library lib=libservice.findById(id);
			
			if(lib!=null) {
				
				return "duplicate-id (primary key)";
			}
			else {
			
			Library lib1=new Library(id,name,books,subject,publisher);
				
			libservice.add(lib1);
			
			return "Library added";
			}
		}
		
		
		@PutMapping("api/UpdateLibrary")
		public String UpdateLib(@RequestParam int id,@RequestParam String name,@RequestParam String books,@RequestParam String subject,@RequestParam String publisher ) {
			
			Library lib1=new Library(id,name,books,subject,publisher);
			
			libservice.add(lib1);
			
			return "Library Updatedd";
		}
		
		
		@DeleteMapping("api/deleteLibrary")
		public String deleteLibrary(@RequestParam int id) {
			
			Library libdel=new Library(id,"","","","");
			
			libservice.delete(libdel);
			
			return "Library deleted";
		}
		
		
		
		@Operation(summary="For Getting data in Asc oreder give '1' in Direction , For Descending order give 2 in Direction")
		@GetMapping("api/sorting")
		public Page<Library> getBySorting(@RequestParam int pageNumber,@RequestParam int direction,@RequestParam (defaultValue="subject") String columnName ,@RequestParam (defaultValue="3") int rowPerPage){
			
			if(direction==1) {
				Page<Library> plib=libservice.getBypageSort(pageNumber, Direction.ASC, columnName, rowPerPage);
				return plib;
			}
			else {
				Page<Library> plib=libservice.getBypageSort(pageNumber, Direction.DESC, columnName, rowPerPage);
				return plib;
			
		}
}
		
	//	@Deprecated //this means this function is going to end like that
		@Operation(summary="this will show all the data filtered with name")
		@GetMapping("api/getByName")
		public List<Library> getByname(@RequestParam String name){
			
			//List<Library> filterByName=libservice.filterByName(name);
			
			return libservice.filterByName(name);
		}
		
		
		@Operation(summary="get by page only")
		@GetMapping("api/getByPageOnly")
		public Page<Library> getbyPage(@RequestParam int pageNumber,@RequestParam int rowPerPage){
			
			return libservice.getBypageOnly(pageNumber, rowPerPage);
			
		}
		
		
		@GetMapping("/api/getBySort")
		public List<Library> getBySortOnly(@RequestParam (defaultValue="name")String columns,int direction){
			if(direction==1) {
			return libservice.getBySortOnly(columns, Direction.ASC);
			}
			else {
				return libservice.getBySortOnly(columns, Direction.DESC);
			}
		}
}


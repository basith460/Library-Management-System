package com.gl.springboot8.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gl.springboot8.model.Library;
import com.gl.springboot8.service.LibService;

//@Controller
public class LibController {
	
	
	@Autowired
	LibService lservice;
	
	@RequestMapping("/list")
	public String libDirectory(Model model) {
		
	//	Library library=new Library(id,name,books,subject,publisher);
		
		List<Library> liblist=lservice.getAll();
		
		model.addAttribute("lib",liblist);
		
		
		return "first-page";
		
	    
	}
	
	@RequestMapping("/addlibrary")
	public String addForm() {
		
		return "addlib-form";
	}
	
	@PostMapping("/addlibrary")
	public String insertLib(@RequestParam int id,@RequestParam String name,@RequestParam String books,@RequestParam String subject,@RequestParam String publisher,Model model) {
		
		Library library=new Library(id,name,books,subject,publisher);
		
		lservice.add(library);
		
        List<Library> liblist=lservice.getAll();
		
		model.addAttribute("lib",liblist);
		
	
		return "first-page";
	}
	
	@GetMapping("/update-library")
	public String updateLib(@RequestParam int id,Model model) {
		
		Library lib=lservice.getById(id);
		
		if(lib!=null) {
			model.addAttribute("lib",lib);
			return "update-library-form";
			
		}else {
			List<Library> liblist=lservice.getAll();
			
			model.addAttribute("lib",liblist);
			
		
			return "first-page";
			
		}
		
		
		
	}
	
	@PostMapping("/updatelibrary")
	public String saveUpdate(@RequestParam int id,@RequestParam String name,@RequestParam String books,@RequestParam String subject,@RequestParam String publisher,Model model) {
		
		Library library=new Library(id,name,books,subject,publisher);
		
		lservice.add(library);
		
        List<Library> liblist=lservice.getAll();
		
		model.addAttribute("lib",liblist);
		
	
		return "first-page";
	}
	 
	@GetMapping("/delete-library")
	public String deleteLibrary(@RequestParam int id,Model model) {
		
		Library delLib=new Library(id,null,null,null,null);
		
		lservice.delete(delLib);
		
        List<Library> liblist=lservice.getAll();
		
		model.addAttribute("lib",liblist);
		
	
		return "first-page";
		
	}
}

//@RequestParam int id,@RequestParam String name,@RequestParam String books,@RequestParam String subject,@RequestParam String publisher,

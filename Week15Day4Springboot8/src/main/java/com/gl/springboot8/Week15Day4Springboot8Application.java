package com.gl.springboot8;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort.Direction;

import com.gl.springboot8.model.Library;
import com.gl.springboot8.service.LibService;

@SpringBootApplication
public class Week15Day4Springboot8Application implements CommandLineRunner{
	
	 @Autowired
		LibService libService;
	public static void main(String[] args) {
		SpringApplication.run(Week15Day4Springboot8Application.class, args);
	}

	//regular insert
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Library lib=new Library(11,"Govt lib3","Tamil,English","chool","Teacher1");
		libService.add(lib);
		
		//bulk insert
		
		Library l1=new Library(12,"Govt lib3","maths","crescent","Teacher2");
		Library l2=new Library(13,"Govt lib3","science, social","sastra","Teacher3");
		List<Library> list=new ArrayList<>();
		
		list.add(l1);
		list.add(l2);
		
		libService.addBulk(list);
		
//		
//		List<Library> allLibraries=libService.getBySortOnly("name", Direction.DESC);
//		
//		for(Library temp: allLibraries) {
//			System.out.println("Name: "+temp.getName());
//		}
		

		List<Library> allLibraries=libService.getBySortOnly("publisher", Direction.ASC);
		
		for(Library temp: allLibraries) {
			System.out.println("publisher : "+temp.getPublisher());
		}
		
		//A page is a sublist of a list of objects. It allows gain information about the position of it in the containingentire list.
		Page<Library> pageLibraries=libService.getBypageOnly(1, 5);
		
		System.out.println("page by");
		for(Library temp: pageLibraries) {
			System.out.println("Name : "+temp.getName() +" , Books: "+temp.getCommaSeparatedBooknames());
		}
		
		List<Library> filter1=libService.filterByName("Govt");
		
		System.out.println("Filter by name having Govt in it");
		
		for(Library temp:filter1) {
			System.out.println(" "+temp);
		}
		
	}
	
	
}

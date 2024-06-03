package com.gl.springboot8.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Library {
	
	@Id
	private int id;
	private String name;
	private String commaSeparatedBooknames;
	private String subject;
	private String publisher;
}

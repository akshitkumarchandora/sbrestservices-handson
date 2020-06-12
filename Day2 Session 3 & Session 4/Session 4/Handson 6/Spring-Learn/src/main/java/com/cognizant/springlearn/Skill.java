package com.cognizant.springlearn;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Skill {

	@NotNull
	@Pattern(regexp = "\\d+")
	private String id;

	@NotNull
	@NotBlank
	@Size(min = 1, max = 30)
	private String name;
	private static final Logger LOGGER = LoggerFactory.getLogger(Department.class);
	public Skill()
	{
		LOGGER.info("Inside Skill Constructor");
		
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Skill [id=" + id + ", name=" + name + "]";
	}
	
}

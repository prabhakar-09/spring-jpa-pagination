package com.spring.pagination.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.pagination.model.Person;
import com.spring.pagination.repository.PersonRepository;

@RestController
@RequestMapping("/api/people")
public class PersonController {

	
	private final PersonRepository personRepository;
	
	public PersonController(PersonRepository personRepository) {
		
		this.personRepository = personRepository;
	}
	
	@GetMapping()
	public Page<Person> findAll(@RequestParam int offset, @RequestParam int batch){
		
		PageRequest pgr = PageRequest.of(offset, batch);
		
		return personRepository.findAll(pgr);
	}
}

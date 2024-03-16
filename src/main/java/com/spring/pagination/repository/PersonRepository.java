package com.spring.pagination.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.pagination.model.Person;

public interface PersonRepository extends JpaRepository<Person, Integer>{

	
}

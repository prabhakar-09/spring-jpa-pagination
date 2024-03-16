package com.spring.pagination.data;

import java.util.List;
import java.util.stream.IntStream;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.github.javafaker.Faker;
import com.spring.pagination.model.Address;
import com.spring.pagination.model.Person;
import com.spring.pagination.repository.PersonRepository;

import ch.qos.logback.classic.Logger;

/*@Component Annotation: This annotation marks the DataLoader class as a Spring component, 
allowing it to be automatically detected and instantiated by Spring's component scanning mechanism.
*/

@Component

/*
 * By implementing the CommandLineRunner interface, the DataLoader class must
 * provide an implementation for the run method. This method is invoked when the
 * Spring Boot application starts up.
 */
public class DataLoader implements CommandLineRunner{
	
	private Logger logger = (Logger) LoggerFactory.getLogger(DataLoader.class);
	
	private final PersonRepository repository;
	
	private final Faker faker;
	
	public DataLoader(PersonRepository repository, Faker faker) { // constructor injection
		this.repository = repository;
		this.faker = faker;
	}
	
	/*
	 * When the Spring Boot application starts up, Spring will detect the DataLoader
	 * component due to the @Component annotation. Then, it will automatically
	 * invoke the run method, executing the logic inside it.
	 */
	@Override
	public void run(String... args) throws Exception {

		logger.info("Loading sample data...");
		
//		Person person = new Person("Peeku", "Neeku", "9986554770", 
//							"peekuneeku@gmail.com",new Address("Street", "City", "State", "Zip"));
//		
//		repository.save(person);
		
//		Creating 100 rows of people in the database
		List<Person> people = IntStream.rangeClosed(1, 100)
					.mapToObj(i -> new Person(
							
							faker.name().firstName(),
							faker.name().lastName(),
							faker.phoneNumber().cellPhone(),
							faker.internet().emailAddress(),
							new Address(
									
									faker.address().streetAddress(),
									faker.address().city(),
									faker.address().state(),
									faker.address().zipCode()
									
									)
							
							)).toList();
		
		repository.saveAll(people);
		
	}

	
}

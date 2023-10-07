package br.com.mkriiger.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import br.com.mkriiger.models.Person;

@Service
public class PersonServices {
	
	private final AtomicLong counter = new AtomicLong();
	private Logger logger = Logger.getLogger(PersonServices.class.getName());
	
	public List<Person> findAll() {
		List<Person> persons = new ArrayList<>();
		for (int i = 0; i < 8; i++) {
			Person p = mockPerson(i);
			persons.add(p);
		}
		
		return persons ;
	}

	public Person findById(String id) {
		
		logger.info("Finding one person..."); 
		
		Person p =  new Person();
		p.setId(counter.incrementAndGet());
		p.setFirstName("Marcio");
		p.setLastName("Santos");
		p.setAddress("Rio de Janeiro - RJ - Brasil");
		p.setGender("M");
		return p;
	}
	
	public Person create(Person p) {
		
		logger.info("Creating one person..."); 
		return p;
	}
	
	public Person update(Person p) {
		
		logger.info("Updating one person..."); 
		return p;
	}
	
	public void delete(String id) {
		logger.info("Deleting one person..."); 
	}
	
	private Person mockPerson(int i) {
		
		logger.info("Finding all persons..."); 
		
		Person p =  new Person();
		p.setId(counter.incrementAndGet());
		p.setFirstName("First Name " + i);
		p.setLastName("Last Name " + i);
		p.setAddress("Some Address");
		p.setGender("M");
		return p;
	}

}

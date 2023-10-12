package br.com.mkriiger.services;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mkriiger.exceptions.ResourceNotFoundException;
import br.com.mkriiger.models.Person;
import br.com.mkriiger.repositories.PersonRepository;

@Service
public class PersonServices {
	
	private Logger logger = Logger.getLogger(PersonServices.class.getName());
	
	@Autowired
	PersonRepository personRepository;
	
	public List<Person> findAll() {
		logger.info("Finding all people...");
		
		return personRepository.findAll() ;
	}

	public Person findById(Long id) {
		logger.info("Finding one person..."); 		
		
		return personRepository.findById(id).orElseThrow(
					() -> new ResourceNotFoundException(
							"No records found for this ID!"));
	}
	
	public Person create(Person p) {
		logger.info("Creating one person..."); 
		
		return personRepository.save(p);
	}
	
	public Person update(Person p) {
		logger.info("Updating one person...");
		
		var entity = personRepository.
						findById(p.getId()).orElseThrow(
								() -> new ResourceNotFoundException(
										"No records found for this ID!"));
		
		entity.setFirstName(p.getFirstName());
		entity.setLastName(p.getLastName());
		entity.setAddress(p.getAddress());
		entity.setGender(p.getGender());
		
		return personRepository.save(entity);
	}
	
	public void delete(Long id) {
		logger.info("Deleting one person...");
		
		var entity = personRepository.
				findById(id).orElseThrow(
						() -> new ResourceNotFoundException(
								"No records found for this ID!"));
		
		personRepository.delete(entity);
	}

}

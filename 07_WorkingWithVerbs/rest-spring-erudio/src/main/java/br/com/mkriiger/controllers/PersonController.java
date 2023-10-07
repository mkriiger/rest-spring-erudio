package br.com.mkriiger.controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.mkriiger.models.Person;
import br.com.mkriiger.services.PersonServices;

@RestController
@RequestMapping("/person")
public class PersonController {
	
	
	//COM INJECAO DE DEPENDENCIA
	@Autowired
	private PersonServices personService;
	
	//SEM INJECAO DE DEPENDENCIA
	//private PersonServices personService = new PersonServices();
	
	@GetMapping(value = "/{id}", 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public Person findById(
			@PathVariable(value = "id") String id) 
					throws Exception {
		
		return personService.findById(id);
	}
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Person> findAll() {
		
		return personService.findAll();
	}	
	
	@PostMapping( 
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public Person create(@RequestBody Person p){
		
		return personService.create(p);
	}
	
	@PutMapping( 
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public Person update(@RequestBody Person p){
		
		return personService.update(p);
	}
	
	@DeleteMapping(value = "/{id}", 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public void delete(
			@PathVariable(value = "id") String id) 
					throws Exception {
		
		personService.delete(id);
	}

}

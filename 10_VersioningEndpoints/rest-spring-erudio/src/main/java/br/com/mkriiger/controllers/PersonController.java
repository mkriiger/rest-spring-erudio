package br.com.mkriiger.controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.mkriiger.data.vo.v1.PersonVO;
import br.com.mkriiger.data.vo.v2.PersonVOv2;
import br.com.mkriiger.mapper.custom.PersonMapper;
import br.com.mkriiger.services.PersonServices;

@RestController
@RequestMapping("/person")
public class PersonController {
		
	@Autowired
	private PersonServices personService;
	
	@GetMapping(value = "/{id}", 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public PersonVO findById(
			@PathVariable(value = "id") Long id) 
					throws Exception {
		
		return personService.findById(id);
	}
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<PersonVO> findAll() {
		
		return personService.findAll();
	}	
	
	@PostMapping( 
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public PersonVO create(@RequestBody PersonVO p){
		
		return personService.create(p);
	}
	
	// usando versionamento de api
	@PostMapping(value = "/v2",
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public PersonVOv2 createV2(@RequestBody PersonVOv2 p){
		
		return personService.createV2(p);
	}
	
	@PutMapping( 
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public PersonVO update(@RequestBody PersonVO p){
		
		return personService.update(p);
	}
	
	@DeleteMapping(value = "/{id}", 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> delete(
			@PathVariable(value = "id") Long id) 
					throws Exception {
		
		personService.delete(id);
		return ResponseEntity.noContent().build();
	}

}

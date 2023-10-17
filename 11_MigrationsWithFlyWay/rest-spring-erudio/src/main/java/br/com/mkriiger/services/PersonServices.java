package br.com.mkriiger.services;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mkriiger.data.vo.v1.PersonVO;
import br.com.mkriiger.exceptions.ResourceNotFoundException;
import br.com.mkriiger.mapper.DozerMapper;
import br.com.mkriiger.models.Person;
import br.com.mkriiger.repositories.PersonRepository;

@Service
public class PersonServices {
	
	private Logger logger = Logger.getLogger(PersonServices.class.getName());
	
	@Autowired
	PersonRepository personRepository;
	
	public List<PersonVO> findAll() {
		logger.info("Finding all people...");
		
		return DozerMapper.parseListObject(
				personRepository.findAll(), PersonVO.class);
	}

	public PersonVO findById(Long id) {
		logger.info("Finding one person..."); 		
		
		var entity = personRepository.findById(id).orElseThrow(
					() -> new ResourceNotFoundException(
							"No records found for this ID!"));
		
		return DozerMapper.parseObject(entity, PersonVO.class);
	}
	
	public PersonVO create(PersonVO p) {
		logger.info("Creating one person...");
		
		var entity = DozerMapper.parseObject(p, Person.class);		
		var vo = DozerMapper.parseObject(
				personRepository.save(entity), PersonVO.class);
		
		return vo;
	}
	
	public PersonVO update(PersonVO p) {
		logger.info("Updating one person...");
		
		var entity = personRepository.
						findById(p.getId()).orElseThrow(
								() -> new ResourceNotFoundException(
										"No records found for this ID!"));
		
		entity.setFirstName(p.getFirstName());
		entity.setLastName(p.getLastName());
		entity.setAddress(p.getAddress());
		entity.setGender(p.getGender());
		
		var vo = DozerMapper.parseObject(
				personRepository.save(entity), PersonVO.class);
		return vo;
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

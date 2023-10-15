package br.com.mkriiger.mapper.custom;

import java.util.Date;

import org.springframework.stereotype.Service;

import br.com.mkriiger.data.vo.v2.PersonVOv2;
import br.com.mkriiger.models.Person;

@Service
public class PersonMapper {

	public PersonVOv2 convertEntityToVO(Person p) {
		PersonVOv2 vo = new PersonVOv2();
		vo.setId(p.getId());
		vo.setAddress(p.getAddress());
		vo.setBirthDay(new Date());
		vo.setFirstName(p.getFirstName());
		vo.setLastName(p.getLastName());
		vo.setGender(p.getGender());
		
		return vo;
	}
	
	public Person convertVOToEntity(PersonVOv2 vo) {
		Person entity = new Person();
		entity.setId(vo.getId());
		entity.setAddress(vo.getAddress());
		//entity.setBirthDay(new Date());
		entity.setFirstName(vo.getFirstName());
		entity.setLastName(vo.getLastName());
		entity.setGender(vo.getGender());
		
		return entity;
	}
	
	
}

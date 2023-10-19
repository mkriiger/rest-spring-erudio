package br.com.mkriiger.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.mkriiger.models.Person;

public interface PersonRepository extends JpaRepository<Person, Long>{}

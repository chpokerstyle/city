package com.volokitin.city.service.inter;

import com.volokitin.city.data.entity.Person;
import com.volokitin.city.rest.models.CreatePersonRequest;

import java.util.List;

public interface PersonService {

    Person createPerson(CreatePersonRequest createPersonRequest);
    Person updatePerson(Person person);
    boolean deletePersonById(Long id);
    Person getPersonById(Long id);
    List<Person> getAllPerson();
}

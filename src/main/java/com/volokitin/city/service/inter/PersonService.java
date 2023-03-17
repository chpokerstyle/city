package com.volokitin.city.service.inter;

import com.volokitin.city.data.entity.Person;
import com.volokitin.city.rest.models.CreatePersonRequest;
import com.volokitin.city.rest.models.UpdatePersonRequest;

import java.util.List;
import java.util.Optional;

public interface PersonService {

    Person createPerson(CreatePersonRequest createPersonRequest);
    Person updatePerson(Long personId, UpdatePersonRequest createPersonRequest);

    void deletePersonById(Long id);
    Optional<Person> getPersonById(Long id);
    List<Person> getAllPerson();
}

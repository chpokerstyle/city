package com.volokitin.city.service.inter;

import com.volokitin.city.data.entity.Car;
import com.volokitin.city.data.entity.Person;
import com.volokitin.city.rest.models.CreatePersonRequest;
import com.volokitin.city.rest.models.UpdatePersonRequest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface PersonService {

    Person createPerson(CreatePersonRequest createPersonRequest);

    Person updatePerson(Long personId, UpdatePersonRequest createPersonRequest);

    void deletePersonById(Long id);

    Set<Car> getCarsOfPerson(Long personId);

    Optional<Person> getPersonById(Long id);

    List<Person> getAllPerson();

    @Transactional
    boolean addPersonToHome(Long personId, Long homeId);

    List<Person> getOwnersFromStreet(String street);
}

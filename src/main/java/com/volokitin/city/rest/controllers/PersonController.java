package com.volokitin.city.rest.controllers;

import com.volokitin.city.data.entity.Person;
import com.volokitin.city.rest.models.CarDto;
import com.volokitin.city.rest.models.CreatePersonRequest;
import com.volokitin.city.rest.models.PersonDto;
import com.volokitin.city.service.inter.PersonService;
import com.volokitin.city.utils.MapperTransform;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/person")
public class PersonController {

    private final PersonService personService;
    private final MapperTransform mapper;

    @Autowired
    public PersonController(PersonService personService, MapperTransform mapper) {
        this.personService = personService;
        this.mapper = mapper;
    }

    @PostMapping("/create")
    public ResponseEntity<Person> createPerson(@Valid @RequestBody CreatePersonRequest createPersonRequest) {
        Person request = personService.createPerson(createPersonRequest);
        if (request == null) return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
        return new ResponseEntity<>(request, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deletePerson(@PathVariable Long id) {
        personService.deletePersonById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @GetMapping("/{personId}/cars")
    ResponseEntity<Set<CarDto>> getCarOfPersonById(@PathVariable Long personId) {
        Set<CarDto> carsSerOfPerson = new HashSet<>();
        try {
            carsSerOfPerson = personService.getCarsOfPerson(personId)
                    .stream()
                    .map(mapper::carToDto)
                    .collect(Collectors.toSet());
        } catch (Exception e) {
            e.getMessage();
            new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(carsSerOfPerson, HttpStatus.OK);
    }

    @GetMapping("/all")
    ResponseEntity<List<PersonDto>> getAllPerson() {
        List<PersonDto> personDtoList = new ArrayList<>();
        try {
            personDtoList = personService.getAllPerson()
                    .stream()
                    .map(mapper::personToDto)
                    .toList();
        } catch (Exception e) {
            e.getMessage();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(personDtoList, HttpStatus.OK);
    }

}

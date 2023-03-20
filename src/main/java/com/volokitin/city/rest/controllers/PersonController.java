package com.volokitin.city.rest.controllers;

import com.volokitin.city.data.entity.Car;
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

import java.time.LocalDate;
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
    public Person createPerson(@Valid @RequestBody CreatePersonRequest createPersonRequest) {
        Person request = personService.createPerson(createPersonRequest);
        return request;
    }

    @DeleteMapping("/delete/{id}")
    public void deletePerson(@PathVariable Long id) {
        personService.deletePersonById(id);
    }


    @GetMapping("/{personId}/cars")
    ResponseEntity<Set<CarDto>> getCarOfPersonById(@PathVariable Long personId) {
        Set<CarDto> carsSerOfPerson = personService.getCarsOfPerson(personId)
                .stream()
                .map(mapper::carToDto)
                .collect(Collectors.toSet());
        return new ResponseEntity<>(carsSerOfPerson, HttpStatus.OK);
    }

    @GetMapping("/all")
    ResponseEntity <List<PersonDto>> getAllPerson(){
        List<PersonDto> personDtoList = personService.getAllPerson()
                .stream()
                .map(mapper::personToDto)
                .toList();
        return new ResponseEntity<>(personDtoList, HttpStatus.OK);
    }

    @GetMapping("/format")
    public CreatePersonRequest getFormat() {
        return new CreatePersonRequest("", "", 1, 1, LocalDate.now(), LocalDate.now(), "");
    }
}

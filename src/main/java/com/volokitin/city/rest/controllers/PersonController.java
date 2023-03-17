package com.volokitin.city.rest.controllers;

import com.volokitin.city.data.entity.Person;
import com.volokitin.city.rest.models.CreatePersonRequest;
import com.volokitin.city.service.inter.PersonService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/person")
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping("/create")
    public Person createPerson(@Valid @RequestBody CreatePersonRequest createPersonRequest){
        Person request = personService.createPerson(createPersonRequest);
        return request;
    }

    @DeleteMapping("/delete/{id}")
    public void deletePerson(@PathVariable Long id){
        personService.deletePersonById(id);
    }




    @GetMapping("/format")
    public CreatePersonRequest getFormat(){
        return new CreatePersonRequest("","",1,1, LocalDate.now(), LocalDate.now(), "");
    }
}

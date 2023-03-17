package com.volokitin.city.rest.controllers;

import com.volokitin.city.data.entity.Person;
import com.volokitin.city.rest.models.CreatePersonRequest;
import com.volokitin.city.service.inter.PersonService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/person")
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping("/create")
    public Person createPerson(@Valid @RequestBody CreatePersonRequest createPersonRequest){
        Person request = personService.createPerson(createPersonRequest);
        return request;
    }



    @GetMapping("/format")
    public CreatePersonRequest getFormat(){
        return new CreatePersonRequest("","",1,1, LocalDate.now(), LocalDate.now(), "");
    }
}

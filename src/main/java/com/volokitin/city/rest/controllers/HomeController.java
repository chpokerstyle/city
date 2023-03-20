package com.volokitin.city.rest.controllers;

import com.volokitin.city.data.entity.Person;
import com.volokitin.city.rest.models.HomeDto;
import com.volokitin.city.rest.models.PersonDto;
import com.volokitin.city.service.inter.HomeService;
import com.volokitin.city.service.inter.PersonService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/home")
public class HomeController {

    private final HomeService homeService;
    private final PersonService personService;

    public HomeController(HomeService homeService, PersonService personService) {
        this.homeService = homeService;
        this.personService = personService;
    }

    @PostMapping("/create")
    public void createHome(@Valid HomeDto home) {
        homeService.createHome(home);
    }

    @DeleteMapping("/delete/id")
    public void deleteHomeById(@PathVariable Long id) {
        homeService.deleteHomeById(id);
    }

    @PostMapping("add-to-home/{personId}/{homeId}")
    public ResponseEntity<Boolean> addPersonToHome(@PathVariable Long personId, @PathVariable Long homeId) {
        boolean response = personService.addPersonToHome(personId, homeId);
        if (!response) return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/owners/")
    public ResponseEntity<List<Person>> getAllOwnersFromStreet(@RequestBody String street) {
        List<Person> owners = personService.getOwnersFromStreet(street);
        return new ResponseEntity<>(owners, HttpStatus.OK);
    }
}

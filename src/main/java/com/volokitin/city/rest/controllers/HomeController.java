package com.volokitin.city.rest.controllers;

import com.volokitin.city.rest.models.HomeDto;
import com.volokitin.city.service.inter.HomeService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/home")
public class HomeController {

    private final HomeService homeService;

    public HomeController(HomeService homeService) {
        this.homeService = homeService;
    }

    @PostMapping("/create")
    public void createHome(@Valid HomeDto home){
        homeService.createHome(home);
    }

    @DeleteMapping("/delete/id")
    public void deleteHomeById(@PathVariable Long id){
        homeService.deleteHomeById(id);
    }
}

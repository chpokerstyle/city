package com.volokitin.city.rest.models;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;

public class CarDto {

    @NotBlank(message = "brand name is empty")
    private String brand;
}

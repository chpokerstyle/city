package com.volokitin.city.rest.models;

import jakarta.validation.constraints.NotBlank;

public class HomeDto {
    @NotBlank(message = "address is empty! ")
    private String address;
}

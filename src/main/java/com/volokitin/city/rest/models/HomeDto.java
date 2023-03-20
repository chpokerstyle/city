package com.volokitin.city.rest.models;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import lombok.Data;

@Data
public class HomeDto {
    @NotBlank(message = "address is empty! ")
    private String street;
    @Past(message = "house number is empty")
    private int house;
}

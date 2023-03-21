package com.volokitin.city.rest.models;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CarDto {

    @NotBlank(message = "brand name is empty")
    private String brand;
}

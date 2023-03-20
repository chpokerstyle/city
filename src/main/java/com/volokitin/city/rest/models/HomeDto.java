package com.volokitin.city.rest.models;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class HomeDto {
    @NotBlank(message = "address is empty! ")
    private String address;
}

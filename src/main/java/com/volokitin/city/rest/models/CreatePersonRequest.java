package com.volokitin.city.rest.models;

import jakarta.validation.constraints.NotBlank;
import org.springframework.lang.Nullable;

import java.time.LocalDate;

public record CreatePersonRequest(

        @NotBlank(message = "Name is mandatory")
        String firstName,
        @NotBlank(message = "Name is mandatory")
        String lastName,
        @NotBlank(message = "Name is mandatory")
        short age,
        int series,
        int number,
        @NotBlank(message = "Name is mandatory")
        LocalDate birthday,
        LocalDate dateCreatePassport,
        @Nullable
        String registrationAddress
) {
}

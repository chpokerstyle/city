package com.volokitin.city.rest.models;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.PastOrPresent;

import java.time.LocalDate;

public record CreatePersonRequest(

        @NotBlank(message = "First name is mandatory")
        String firstName,
        @NotBlank(message = "Last name is mandatory")
        String lastName,
        int series,
        int number,
        @Past(message = "birthday is mandatory")
        LocalDate birthday,
        @PastOrPresent
        LocalDate dateCreatePassport,
        String registrationAddress
) {
}

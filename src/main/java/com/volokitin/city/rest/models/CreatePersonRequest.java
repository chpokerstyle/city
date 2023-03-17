package com.volokitin.city.rest.models;

import org.springframework.lang.Nullable;

import java.time.LocalDate;

public record CreatePersonRequest(

        String firstName,
        String lastName,
        short age,
        int series,
        int number,
        LocalDate birthday,
        LocalDate dateCreatePassport,
        @Nullable
        String registrationAddress
) {
}

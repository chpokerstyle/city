package com.volokitin.city.data.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
@Entity
@Table
@AllArgsConstructor
public class Passport {

    @Id
    @GeneratedValue()
    private Long id;

    private int series;

    private int number;

    private LocalDate birthday;

    private LocalDate dateCreatePassport;

    private String registrationAddress;

    @OneToOne(mappedBy = "passport")
    public Person person;

}

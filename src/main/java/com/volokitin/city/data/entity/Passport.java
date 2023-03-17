package com.volokitin.city.data.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table
public class Passport {

    @Id
    @GeneratedValue()
    private Long id;

    private int series;

    private int number;

    private LocalDate birthday;

    private LocalDate dateCreatePassport;

    private String registrationAddress;

    @OneToOne(mappedBy = "person")
    public Person person;

}

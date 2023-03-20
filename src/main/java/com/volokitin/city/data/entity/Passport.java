package com.volokitin.city.data.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "passports")
public class Passport {

    @Id
    @GeneratedValue()
    private Long id;

    private int series;

    private int number;

    private LocalDate birthday;

    private LocalDate dateCreatePassport;

    private String registrationAddress;

    @OneToOne(mappedBy = "passport", fetch = FetchType.LAZY)
    public Person person;

}

package com.volokitin.city.data.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Data
@Entity
@Table
public class Person {

    @Id @GeneratedValue()
    private Long id;

    private String firstName;

    private String lastName;

    private char age;

    @OneToOne
    public Passport passport;

    @ManyToMany
    public Set<Home> homeSet;

    @OneToMany()
    public Set<Car> carSet;
}

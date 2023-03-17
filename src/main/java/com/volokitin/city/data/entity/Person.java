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

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    public Passport passport;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    public Set<Home> homeSet;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    public Set<Car> carSet;
}

package com.volokitin.city.data.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Builder(access = AccessLevel.PUBLIC)
@AllArgsConstructor
@Entity
@Table
public class Person {

    @Id @GeneratedValue()
    private Long id;

    private String firstName;

    private String lastName;

    private short age;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    public Passport passport;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    public Set<Home> homeSet;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    public Set<Car> carSet;

}

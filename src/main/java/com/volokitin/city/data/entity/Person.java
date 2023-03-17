package com.volokitin.city.data.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Builder(access = AccessLevel.PUBLIC)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table
public class Person {

    @Id @GeneratedValue()
    private Long id;

    private String firstName;

    private String lastName;

    private short age;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    public Passport passport;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    public Set<Home> homeSet;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, orphanRemoval = true)
    public Set<Car> carSet;

}

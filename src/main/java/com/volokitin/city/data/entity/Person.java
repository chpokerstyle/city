package com.volokitin.city.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Builder(access = AccessLevel.PUBLIC)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "persons")
public class Person {

    @Id
    @GeneratedValue()
    private Long id;

    private String firstName;

    private String lastName;

    private short age;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    public Passport passport;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinTable(
            schema = "public",
            name = "persons_homes",
            joinColumns = @JoinColumn(name = "persons_id"),
            inverseJoinColumns = {@JoinColumn(name = "homes_id")})
    public Set<Home> homes = new HashSet<>();

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, orphanRemoval = true, mappedBy = "person")
    @JsonIgnore
    public Set<Car> carSet;

}

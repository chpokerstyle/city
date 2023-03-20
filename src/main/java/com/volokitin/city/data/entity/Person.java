package com.volokitin.city.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Builder(access = AccessLevel.PUBLIC)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Entity
@Table
public class Person {

    @Id @GeneratedValue()
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
            name = "person_home_list",
            joinColumns = @JoinColumn(name = "person_list_id"),
            inverseJoinColumns = {@JoinColumn(name = "home_list_id")})
    public Set<Home> homeList = new HashSet<>();

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, orphanRemoval = true)
    @JsonIgnore
    public Set<Car> carSet;

}

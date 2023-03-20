package com.volokitin.city.data.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table
public class Home {

    @Id
    @GeneratedValue()
    private Long id;

    private String street;
    private int house;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE, mappedBy = "homeList")
    public Set<Person> personList = new HashSet<>();
}

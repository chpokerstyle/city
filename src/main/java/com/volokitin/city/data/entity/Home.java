package com.volokitin.city.data.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "homes")
public class Home {

    @Id
    @GeneratedValue()
    private Long id;

    private String street;
    private int house;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE, mappedBy = "homes")
    public Set<Person> persons = new HashSet<>();
}

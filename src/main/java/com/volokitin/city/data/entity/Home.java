package com.volokitin.city.data.entity;

import jakarta.persistence.*;
import lombok.Data;

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

    @ManyToMany(mappedBy = "homeSet")
    public Set<Person> personSet;
}

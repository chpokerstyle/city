package com.volokitin.city.data.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "cars")
public class Car {

    @Id
    @GeneratedValue()
    private Long id;
    private String brand;

    @ManyToOne(cascade = CascadeType.ALL)
    public Person person;
}

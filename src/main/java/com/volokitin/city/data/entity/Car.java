package com.volokitin.city.data.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table
public class Car {

    @Id
    @GeneratedValue()
    private Long id;
    private String brand;

    public Person person;
}

package com.volokitin.city.rest.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.volokitin.city.data.entity.Car;
import com.volokitin.city.data.entity.Home;
import com.volokitin.city.data.entity.Passport;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Set;

@Data
public class PersonDto {

    private Long id;

    private String firstName;

    private String lastName;

    private short age;

    public Passport passport;

    public Set<Home> homeSet;

    public Set<Car> carSet;
}

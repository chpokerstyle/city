package com.volokitin.city.rest.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.volokitin.city.data.entity.Car;
import com.volokitin.city.data.entity.Home;
import com.volokitin.city.data.entity.Passport;
import lombok.Data;

import java.util.Set;

@Data
public class PersonDto {

    private Long id;

    private String firstName;

    private String lastName;

    private short age;

    @JsonIgnore
    public Passport passport;

    //    @JsonIgnore
    public Set<Home> homeSet;

    @JsonIgnore
    public Set<Car> carSet;
}

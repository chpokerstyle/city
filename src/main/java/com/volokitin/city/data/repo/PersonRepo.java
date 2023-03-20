package com.volokitin.city.data.repo;

import com.volokitin.city.data.entity.Car;
import com.volokitin.city.data.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Set;

public interface PersonRepo  extends JpaRepository<Person, Long> {
}

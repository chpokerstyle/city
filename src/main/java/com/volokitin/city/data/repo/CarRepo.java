package com.volokitin.city.data.repo;

import com.volokitin.city.data.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface CarRepo extends JpaRepository<Car, Long> {
    Set<Car> findByPersonId(Long id);
}

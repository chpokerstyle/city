package com.volokitin.city.data.repo;

import com.volokitin.city.data.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarRepo extends JpaRepository<Car, Long> {
    List<Car> findByPersonId(Long id);
}

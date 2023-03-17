package com.volokitin.city.data.repo;

import com.volokitin.city.data.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepo extends JpaRepository<Car, Long> {
}

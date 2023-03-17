package com.volokitin.city.service.inter;

import com.volokitin.city.data.entity.Car;

public interface CarService {

    Car createCar(Car car);
    void deleteCarById(Long id);
}

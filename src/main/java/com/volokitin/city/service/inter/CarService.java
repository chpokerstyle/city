package com.volokitin.city.service.inter;

import com.volokitin.city.data.entity.Car;
import com.volokitin.city.rest.models.CarDto;

public interface CarService {

    Car createCar(CarDto carDto);

    void addPersonToCar(Long carId, Long personId);
    void deleteCarById(Long id);
}

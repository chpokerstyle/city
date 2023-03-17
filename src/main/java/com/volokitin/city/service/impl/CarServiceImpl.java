package com.volokitin.city.service.impl;

import com.volokitin.city.data.entity.Car;
import com.volokitin.city.data.repo.CarRepo;
import com.volokitin.city.data.repo.PersonRepo;
import com.volokitin.city.rest.models.CarDto;
import com.volokitin.city.service.inter.CarService;
import com.volokitin.city.utils.MapperTransform;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarServiceImpl implements CarService {
    private final MapperTransform mapperTransform;
    private final CarRepo carRepo;
    private final PersonRepo personRepo;

    public CarServiceImpl(MapperTransform mapperTransform, CarRepo carRepo, PersonRepo personRepo) {
        this.mapperTransform = mapperTransform;
        this.carRepo = carRepo;
        this.personRepo = personRepo;
    }

    @Override
    public Car createCar(@Valid CarDto carDto) {
        Car car = mapperTransform.carToEntity(carDto);
        return carRepo.save(car);
    }

    @Override
    public void addPersonToCar(Long carId, Long personId) {
        personRepo
                .findById(personId)
                .orElseThrow()
                .getCarSet().add(carRepo.findById(carId).orElseThrow());
    }

    @Override
    public void deleteCarById(Long id) {
        carRepo.deleteById(id);
    }
}

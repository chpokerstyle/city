package com.volokitin.city.utils;

import com.volokitin.city.data.entity.Car;
import com.volokitin.city.data.entity.Home;
import com.volokitin.city.rest.models.CarDto;
import com.volokitin.city.rest.models.HomeDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MapperTransform {

    CarDto carToDto(Car car);
    Car carToEntity(CarDto carDto);

    Home homeToEntity(HomeDto homeDto);

}

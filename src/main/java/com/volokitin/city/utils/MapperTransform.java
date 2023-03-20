package com.volokitin.city.utils;

import com.volokitin.city.data.entity.Car;
import com.volokitin.city.data.entity.Home;
import com.volokitin.city.data.entity.Person;
import com.volokitin.city.rest.models.CarDto;
import com.volokitin.city.rest.models.HomeDto;
import com.volokitin.city.rest.models.PersonDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface MapperTransform {
    MapperTransform INSTANCE = Mappers.getMapper(MapperTransform.class);

    CarDto carToDto(Car car);
    Car carToEntity(CarDto carDto);

    Home homeToEntity(HomeDto homeDto);

    PersonDto personToDto(Person personEntity);

}

package com.volokitin.city.service.impl;

import com.volokitin.city.data.entity.Car;
import com.volokitin.city.data.entity.Passport;
import com.volokitin.city.data.entity.Person;
import com.volokitin.city.data.repo.CarRepo;
import com.volokitin.city.data.repo.PassportRepo;
import com.volokitin.city.data.repo.PersonRepo;
import com.volokitin.city.rest.models.CreatePersonRequest;
import com.volokitin.city.rest.models.UpdatePersonRequest;
import com.volokitin.city.service.inter.PersonService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class PersonServiceImpl implements PersonService {

    private final PersonRepo personRepo;
    private final PassportRepo passportRepo;
    private final CarRepo carRepo;

    public PersonServiceImpl(PersonRepo personRepo, PassportRepo passportRepo, CarRepo carRepo) {
        this.personRepo = personRepo;
        this.passportRepo = passportRepo;
        this.carRepo = carRepo;
    }

    @Override
    public Person createPerson(CreatePersonRequest createPersonRequest) {
        Passport passportEntity = Passport.builder()
                .series(createPersonRequest.series())
                .number(createPersonRequest.number())
                .registrationAddress(createPersonRequest.registrationAddress())
                .birthday(createPersonRequest.birthday())
                .dateCreatePassport(LocalDate.now())
                .build();

        Person personEntity = Person.builder()
                .firstName(createPersonRequest.firstName())
                .lastName(createPersonRequest.lastName())
                .age((short) (LocalDate.now().getYear() - createPersonRequest.birthday().getYear()))
                .passport(passportEntity)
                .build();
        personRepo.save(personEntity);
        return personEntity;
    }

    @Override
    public Person updatePerson(Long personId, UpdatePersonRequest updatePersonRequest) {
        //TODO реализовать логику
        return null;
    }

    @Transactional
    @Override
    public void deletePersonById(Long id) {
        List<Car> carList = carRepo.findByPersonId(id);
        carRepo.deleteAll(carList);
        personRepo.deleteById(id);
    }

    @Override
    public Optional<Person> getPersonById(Long id) {
        return personRepo.findById(id);
    }

    @Override
    public List<Person> getAllPerson() {
        return personRepo.findAll();
    }
}

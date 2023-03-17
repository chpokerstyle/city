package com.volokitin.city.service.impl;

import com.volokitin.city.data.entity.Passport;
import com.volokitin.city.data.entity.Person;
import com.volokitin.city.data.repo.PassportRepo;
import com.volokitin.city.data.repo.PersonRepo;
import com.volokitin.city.service.inter.PersonService;
import org.springframework.stereotype.Service;
import com.volokitin.city.rest.models.CreatePersonRequest;

import java.time.LocalDate;
import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    private final PersonRepo personRepo;
    private final PassportRepo passportRepo;

    public PersonServiceImpl(PersonRepo personRepo, PassportRepo passportRepo) {
        this.personRepo = personRepo;
        this.passportRepo = passportRepo;
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
                .age( createPersonRequest.age())
                .passport(passportEntity)
                .build();
        personRepo.save(personEntity);
        return personEntity;
    }

    @Override
    public Person updatePerson(Person person) {
        return null;
    }

    @Override
    public boolean deletePersonById(Long id) {
        return false;
    }

    @Override
    public Person getPersonById(Long id) {
        return null;
    }

    @Override
    public List<Person> getAllPerson() {
        return null;
    }
}

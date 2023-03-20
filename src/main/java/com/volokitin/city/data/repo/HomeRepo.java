package com.volokitin.city.data.repo;

import com.volokitin.city.data.entity.Home;
import com.volokitin.city.data.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface HomeRepo  extends JpaRepository<Home, Long> {

    @Query("SELECT h.personList FROM Home h WHERE h.street = :street")
    List<Person> getOwnersFromStreet(@Param("street") String street);
}

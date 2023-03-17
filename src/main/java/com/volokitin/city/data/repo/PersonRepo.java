package com.volokitin.city.data.repo;

import com.volokitin.city.data.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepo  extends JpaRepository<Person, Long> {
}

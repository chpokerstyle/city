package com.volokitin.city.data.repo;

import com.volokitin.city.data.entity.Passport;
import com.volokitin.city.data.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PassportRepo extends JpaRepository<Passport, Long> {
}

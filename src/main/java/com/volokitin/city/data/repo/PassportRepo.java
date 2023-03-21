package com.volokitin.city.data.repo;

import com.volokitin.city.data.entity.Passport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassportRepo extends JpaRepository<Passport, Long> {
}

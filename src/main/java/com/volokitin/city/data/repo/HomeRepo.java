package com.volokitin.city.data.repo;

import com.volokitin.city.data.entity.Home;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HomeRepo  extends JpaRepository<Home, Long> {
}

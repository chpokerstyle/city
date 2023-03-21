package com.volokitin.city.service.inter;

import com.volokitin.city.data.entity.Home;
import com.volokitin.city.rest.models.HomeDto;

public interface HomeService {

    Home createHome(HomeDto home);

    Home updateHome(Home home);

    void deleteHomeById(Long id);
}

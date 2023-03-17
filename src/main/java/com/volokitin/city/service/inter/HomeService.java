package com.volokitin.city.service.inter;

import com.volokitin.city.data.entity.Home;

public interface HomeService {

    Home createHome(Home home);
    Home updateHome(Home home);
    void deleteHomeById(Long id);
}

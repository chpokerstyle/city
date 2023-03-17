package com.volokitin.city.service.impl;

import com.volokitin.city.data.entity.Home;
import com.volokitin.city.data.repo.HomeRepo;
import com.volokitin.city.rest.models.HomeDto;
import com.volokitin.city.service.inter.HomeService;
import com.volokitin.city.utils.MapperTransform;
import org.springframework.stereotype.Service;

@Service
public class HomeServiceImpl implements HomeService {
    private final HomeRepo homeRepo;
    private final MapperTransform mapper;

    public HomeServiceImpl(HomeRepo homeRepo, MapperTransform mapper) {
        this.homeRepo = homeRepo;
        this.mapper = mapper;
    }

    @Override
    public Home createHome(HomeDto homeDto) {
        Home home = mapper.homeToEntity(homeDto);
        return homeRepo.save(home);
    }

    @Override
    public Home updateHome(Home home) {
        return null;
    }

    @Override
    public void deleteHomeById(Long id) {
        homeRepo.deleteById(id);
    }
}

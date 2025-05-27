package com.example.JustiSys.service;

import com.example.JustiSys.repository.CityRepository;
import com.example.JustiSys.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class CityService {

    private final CityRepository cityRepository;

    @Autowired
    public CityService(CityRepository cityRepository){
        this.cityRepository = cityRepository;
    }

}

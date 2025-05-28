package com.example.JustiSys.service;

import com.example.JustiSys.dto.CityRequestDTO;
import com.example.JustiSys.dto.CityResponseDTO;
import com.example.JustiSys.exception.InvalidId;
import com.example.JustiSys.model.City;
import com.example.JustiSys.model.Client;
import com.example.JustiSys.repository.CityRepository;
import com.example.JustiSys.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CityService {

    private final CityRepository cityRepository;

    @Autowired
    public CityService(CityRepository cityRepository){
        this.cityRepository = cityRepository;
    }

    public CityResponseDTO createCity(CityRequestDTO dto) {

        City city = new City();

        city.setName(dto.getName());


        City saved = cityRepository.save(city);
        return new CityResponseDTO(saved);
    }

    public List<CityResponseDTO > getAllCities(){
        return cityRepository.findAll()
                .stream()
                .map(CityResponseDTO::new)
                .collect(Collectors.toList());
    }

    public CityResponseDTO getCityById(Long id) {
        City city = cityRepository.findById(id)
                .orElseThrow(InvalidId::new);

        return new CityResponseDTO(city);
    }

    public City findCityEntityById(Long id) {
        return cityRepository.findById(id)
                .orElseThrow(InvalidId::new);
    }

    public CityResponseDTO updateCity(Long id, CityRequestDTO dto) {
        City city = findCityEntityById(id);

        city.setName(dto.getName());

        City updated = cityRepository.save(city);
        return new CityResponseDTO(updated);
    }

    public void deleteCity(Long id) {
        if (!cityRepository.existsById(id)) {
            throw new InvalidId();
        }
        cityRepository.deleteById(id);
    }


}

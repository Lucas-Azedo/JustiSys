package com.example.JustiSys.controller;

import com.example.JustiSys.dto.CityRequestDTO;
import com.example.JustiSys.dto.CityResponseDTO;
import com.example.JustiSys.service.CityService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cities")
public class CityController {

    private final CityService cityService;

    @Autowired
    CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @PostMapping
    ResponseEntity<CityResponseDTO> create(@RequestBody @Valid CityRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(cityService.createCity(dto));
    }

    @GetMapping
    List<CityResponseDTO> getAll() {
        return cityService.getAllCities();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CityResponseDTO> getById(@PathVariable long id) {
        return ResponseEntity.ok(cityService.getCityById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CityResponseDTO> update(@PathVariable long id, @RequestBody @Valid CityRequestDTO dto) {
        return ResponseEntity.ok(cityService.updateCity(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CityResponseDTO>Delete(@PathVariable long id) {
        cityService.deleteCity(id);
        return ResponseEntity.noContent().build();
    }
}

package com.vinicius.holanda.citiesapi.cities.resources;

import com.vinicius.holanda.citiesapi.cities.entities.City;
import com.vinicius.holanda.citiesapi.cities.repository.CityRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.Optional;

@RestController
@RequestMapping("cities")
public class CityResource {

    private final CityRepository repository;

    public CityResource(final CityRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public Page<City> cities(final Pageable page) {
        return repository.findAll(page);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity getCityById(@PathVariable long id) {
        Optional<City> optional = repository.findById(id);
        if (optional.isPresent()) {
            return ResponseEntity.ok().body(optional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Método de busca pelo nome da cidade
    @GetMapping("/name/{name}")
    public City getCityByName(@PathVariable String name) {
        return repository.findByName(name);
    }
}

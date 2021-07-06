package com.vinicius.holanda.citiesapi.cities;

import com.vinicius.holanda.citiesapi.cities.entities.City;
import com.vinicius.holanda.citiesapi.cities.repository.CityRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("cities")
public class CityResource {

    private final CityRepository repository;

    public CityResource(final CityRepository repository) {
        this.repository = repository;
    }

  /* 1st
  @GetMapping
  public List<City> cities() {
      return repository.findAll();
  }*/

    // 2nd - Pageable
    @GetMapping
    public Page<City> cities(final Pageable page) {
        return repository.findAll(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity getStateById(@PathVariable long id){
        Optional<City> optional = repository.findById(id);
        if(optional.isPresent()){
            return ResponseEntity.ok().body(optional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

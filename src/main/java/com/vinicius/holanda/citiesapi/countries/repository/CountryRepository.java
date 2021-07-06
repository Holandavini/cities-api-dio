package com.vinicius.holanda.citiesapi.countries.repository;

import com.vinicius.holanda.citiesapi.countries.entities.Country;
import org.springframework.data.jpa.repository.JpaRepository;

// Deve externder de JpaRepository e ele deve receber dois tipos, o tipo da entidade e o tipo do identificador da entidade
public interface CountryRepository extends JpaRepository<Country, Long> {
}

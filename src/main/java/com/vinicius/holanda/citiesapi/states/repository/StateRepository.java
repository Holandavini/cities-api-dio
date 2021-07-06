package com.vinicius.holanda.citiesapi.states.repository;

import com.vinicius.holanda.citiesapi.states.entities.State;
import org.springframework.data.jpa.repository.JpaRepository;

// Deve externder de JpaRepository e ele deve receber dois tipos, o tipo da entidade e o tipo do identificador da entidade
public interface StateRepository extends JpaRepository<State, Long> {

}

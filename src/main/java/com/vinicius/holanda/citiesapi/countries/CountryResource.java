package com.vinicius.holanda.citiesapi.countries;

import com.vinicius.holanda.citiesapi.countries.Country;
import com.vinicius.holanda.citiesapi.countries.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Optional;

@RestController
@RequestMapping("/countries") // Para indicar o endpoint que irá retornar a página de países
public class CountryResource {

    // A API enxerga o banco como um repositório, devemos criar essa funcionalidade
    // Devemos indicar para o Spring injetar o repositório para que a aplicação enxergue, podemos usar o @Autowired ou um construtor
    @Autowired
    private CountryRepository repository;

    // Método para devolver a lista de países
    @GetMapping

    // Para ele devolver paginado devemos utilizar o Pageable passando uma page
    public Page<Country> countries(Pageable page){
       return repository.findAll(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity getCountryById(@PathVariable long id){

        // É preciso do optional para os casos em que o ID for inválido
        Optional<Country> optional = repository.findById(id);

        // If para não retornar o 500 - Internal server error quando não encontrar o ID
        if(optional.isPresent()){
            return ResponseEntity.ok().body(optional.get());
        } else {
            return ResponseEntity.notFound().build();
        }

    }
}
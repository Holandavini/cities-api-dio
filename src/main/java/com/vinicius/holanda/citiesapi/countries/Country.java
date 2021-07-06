package com.vinicius.holanda.citiesapi.countries;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pais") // Indica a tabela do banco que eu estou mapeando
public class Country {

    // Mapeamento da tabela do banco
    @Id
    private long id;

    // Usar o @Column para mapear as colunas quando o nome for diferente do que o código utiliza
    @Column(name = "nome")
    private String name;

    @Column(name = "nome_pt")
    private String portugueseName;

    private Integer bacen;

    // Construtor
    public Country() {

    }

    // Getters
    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPortugueseName() {
        return portugueseName;
    }

    public Integer getBacen() {
        return bacen;
    }
}

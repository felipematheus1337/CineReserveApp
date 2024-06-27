package com.cinema_reserve.cineapp.domain.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SalaResponse {

    private String filme;

    private int capacidade;

    private String tipoDeSala;


}

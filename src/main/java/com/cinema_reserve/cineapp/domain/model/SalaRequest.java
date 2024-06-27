package com.cinema_reserve.cineapp.domain.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SalaRequest {

    private String nomeFilme;

    private int capacidade;

}

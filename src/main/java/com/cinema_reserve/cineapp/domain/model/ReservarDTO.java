package com.cinema_reserve.cineapp.domain.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
public class ReservarDTO {

    private Long espectadorId;

    private Long salaId;

    private int numeroCadeira;
}

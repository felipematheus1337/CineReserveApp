package com.cinema_reserve.cineapp.application.event.dto;

import lombok.Builder;
import lombok.ToString;

@Builder
@ToString
public record CineReserveEventDTO(String email, String nome, String nomeFilme, Long reservaId, int numeroCadeira) {
}

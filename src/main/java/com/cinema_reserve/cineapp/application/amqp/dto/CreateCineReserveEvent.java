package com.cinema_reserve.cineapp.application.amqp.dto;

import com.cinema_reserve.cineapp.domain.model.ReservarDTO;
import com.cinema_reserve.cineapp.domain.model.Sala;
import lombok.Builder;

@Builder
public record CreateCineReserveEvent(Sala sala, ReservarDTO reservarDTO) {
}

package com.cinema_reserve.cineapp.impl.domain.service;

import com.cinema_reserve.cineapp.domain.model.Sala;
import com.cinema_reserve.cineapp.domain.model.SalaRequest;
import com.cinema_reserve.cineapp.domain.model.SalaResponse;
import com.cinema_reserve.cineapp.domain.model.SalaType;
import com.cinema_reserve.cineapp.domain.repository.SalaRepository;
import com.cinema_reserve.cineapp.domain.service.SalaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class SalaServiceImpl implements SalaService {

    private final SalaRepository salaRepository;

    @Override
    public SalaResponse criar(SalaRequest dto) {

        var sala = Sala.builder()
                .tipoDeSala(SalaType.valueOf(dto.getTipoDeSala()))
                .nome(dto.getNomeFilme())
                .capacidadeTotal(dto.getCapacidade())
                .capacidadeAtual(dto.getCapacidade())
                .build();

       salaRepository.save(sala);

        return new SalaResponse(sala.getNome(), sala.getCapacidadeTotal(), sala.getTipoDeSala().toString());
    }
}

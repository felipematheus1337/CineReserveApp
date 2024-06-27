package com.cinema_reserve.cineapp.impl.domain.service;

import com.cinema_reserve.cineapp.domain.model.ReservarDTO;
import com.cinema_reserve.cineapp.domain.repository.EspectadorRepository;
import com.cinema_reserve.cineapp.domain.repository.ReservaRepository;
import com.cinema_reserve.cineapp.domain.repository.SalaRepository;
import com.cinema_reserve.cineapp.domain.service.ReservaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class ReservaServiceImpl implements ReservaService {

    private final ReservaRepository reservaRepository;
    private final EspectadorRepository espectadorRepository;
    private final SalaRepository salaRepository;

    @Override
    public void reservar(ReservarDTO dto) {

        var sala = salaRepository.findById(dto.getSalaId());

        if (sala.isEmpty()) {
            throw new RuntimeException("");
        }

        var capacidadeTotal = sala.get().getCapacidadeTotal();

        var temLugarDisponivel = capacidadeTotal >= 1;

        sala.get().setCapacidadeAtual(capacidadeTotal - 1);




    }
}

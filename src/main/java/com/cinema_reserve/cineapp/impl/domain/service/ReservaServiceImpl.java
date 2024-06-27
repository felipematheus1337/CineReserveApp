package com.cinema_reserve.cineapp.impl.domain.service;

import com.cinema_reserve.cineapp.application.amqp.publisher.ReservarPublisher;
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

    private final SalaRepository salaRepository;
    private final ReservarPublisher reservarPublisher;

    @Override
    public void reservar(ReservarDTO dto) {

        var sala = salaRepository.findById(dto.getSalaId()).get();

        if (sala.equals(null)) {
            throw new RuntimeException("Sala não existe.");
        }

        var capacidadeTotal = sala.getCapacidadeTotal();

        var temLugarDisponivel = capacidadeTotal >= 1;

        if(!temLugarDisponivel) {
            throw new RuntimeException("Sala já está cheia.");
        }

        var cadeiraJaReservada = sala.getReservas()
                        .stream()
                                .filter(r -> r.getNumeroCadeira() == dto.getNumeroCadeira())
                                        .findAny();

        if (cadeiraJaReservada.isPresent()) {
            throw new RuntimeException("Cadeira já reservada");
        }

        sala.setCapacidadeAtual(capacidadeTotal - 1);

        reservarPublisher.createSessionAMQP(sala, dto);


    }
}

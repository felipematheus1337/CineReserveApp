package com.cinema_reserve.cineapp.application.amqp.listener;


import com.cinema_reserve.cineapp.application.amqp.dto.CreateCineReserveEvent;
import com.cinema_reserve.cineapp.application.event.dto.CineReserveEventDTO;
import com.cinema_reserve.cineapp.domain.model.Reserva;
import com.cinema_reserve.cineapp.domain.repository.EspectadorRepository;
import com.cinema_reserve.cineapp.domain.repository.ReservaRepository;
import com.cinema_reserve.cineapp.domain.repository.SalaRepository;
import com.cinema_reserve.cineapp.infra.amqp.AMQPConfig;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class ReservaListener {

    private final SalaRepository salaRepository;
    private final EspectadorRepository espectadorRepository;
    private final ReservaRepository reservaRepository;
    private final ApplicationEventPublisher applicationEventPublisher;

    @RabbitListener(queues = AMQPConfig.RESERVAR_SESSÃO_FILA)
    public void listenerSessao(@Payload Message<CreateCineReserveEvent> message) {

        log.info("Mensagem recebida...");
        log.info("Processando...");

        var data = message.getPayload();

        var sala = salaRepository.save(data.sala());

        var espectador = espectadorRepository.findById(data.reservarDTO().getEspectadorId()).get();

        var reservaToSave = Reserva.builder()
                .sala(sala)
                .espectador(espectador)
                .numeroCadeira(data.reservarDTO().getNumeroCadeira())
                .build();

        var reserva = reservaRepository.save(reservaToSave);

        log.info("Reserva cadastrada com sucesso.");

        var cineEvent = CineReserveEventDTO.builder()
                        .reservaId(reserva.getId())
                        .nome(espectador.getNome())
                        .email(espectador.getEmail())
                        .numeroCadeira(reserva.getNumeroCadeira())
                        .nomeFilme(sala.getNome())
                                .build();

        log.info("Iniciando notificação via e-mail.");
        applicationEventPublisher.publishEvent(cineEvent);
    }

}

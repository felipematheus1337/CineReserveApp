package com.cinema_reserve.cineapp.application.amqp.publisher;


import com.cinema_reserve.cineapp.application.amqp.dto.CreateCineReserveEvent;
import com.cinema_reserve.cineapp.domain.model.ReservarDTO;
import com.cinema_reserve.cineapp.domain.model.Sala;
import com.cinema_reserve.cineapp.infra.amqp.AMQPConfig;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class ReservarPublisher {

    private final RabbitTemplate rabbitTemplate;

    public void createSessionAMQP(Sala sala, ReservarDTO dto) {

        log.info("Enviando para a fila...");

        var reserveEvent = CreateCineReserveEvent.builder()
                .sala(sala)
                .reservarDTO(dto)
                .build();

        this.rabbitTemplate.convertAndSend(AMQPConfig.RESERVAR_SESSÃO_FILA, reserveEvent);
    }
}

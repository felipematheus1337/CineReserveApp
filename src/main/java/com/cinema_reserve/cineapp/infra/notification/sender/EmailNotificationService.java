package com.cinema_reserve.cineapp.infra.notification.sender;

import com.cinema_reserve.cineapp.application.event.dto.CineReserveEventDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailNotificationService {

    private final JavaMailSender javaMailSender;

    public void sendConfirmationMail(CineReserveEventDTO eventDTO) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(eventDTO.email());
        message.setSubject("Sessão do filme" + eventDTO.nomeFilme());
        message.setText("Reserva confirmada com sucesso! Se atentar ao horário da sessão.");

        javaMailSender.send(message);
    }
}

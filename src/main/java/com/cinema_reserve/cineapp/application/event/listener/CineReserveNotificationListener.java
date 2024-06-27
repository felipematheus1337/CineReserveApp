package com.cinema_reserve.cineapp.application.event.listener;

import com.cinema_reserve.cineapp.application.event.CineReserveNotificationEvent;
import com.cinema_reserve.cineapp.infra.notification.sender.EmailNotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CineReserveNotificationListener {

    private final EmailNotificationService emailNotificationService;

    @EventListener
    public void notificationCineReserve(CineReserveNotificationEvent event) {
        var info = event.getCineReserveEventDTO();
        this.emailNotificationService.sendConfirmationMail(info);

    }
}

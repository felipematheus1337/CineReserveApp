package com.cinema_reserve.cineapp.application.event;

import com.cinema_reserve.cineapp.application.event.dto.CineReserveEventDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEvent;


public class CineReserveNotificationEvent extends ApplicationEvent {

    private final CineReserveEventDTO cineReserveEventDTO;

    public CineReserveNotificationEvent(Object source, CineReserveEventDTO cineReserveEventDTO) {
        super(source);
        this.cineReserveEventDTO = cineReserveEventDTO;
    }

    public CineReserveEventDTO getCineReserveEventDTO() {
        return cineReserveEventDTO;
    }
}

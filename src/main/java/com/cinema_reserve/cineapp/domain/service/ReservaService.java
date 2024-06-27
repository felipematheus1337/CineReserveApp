package com.cinema_reserve.cineapp.domain.service;


import com.cinema_reserve.cineapp.domain.model.ReservarDTO;
import org.springframework.stereotype.Service;

@Service
public interface ReservaService {

    void reservar(ReservarDTO dto);
}

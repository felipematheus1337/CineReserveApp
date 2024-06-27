package com.cinema_reserve.cineapp.impl.domain.service;

import com.cinema_reserve.cineapp.domain.model.ReservarDTO;
import com.cinema_reserve.cineapp.domain.repository.ReservaRepository;
import com.cinema_reserve.cineapp.domain.service.ReservaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class ReservaServiceImpl implements ReservaService {

    private final ReservaRepository reservaRepository;

    @Override
    public void reservar(ReservarDTO dto) {



    }
}

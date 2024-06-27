package com.cinema_reserve.cineapp.domain.service;


import com.cinema_reserve.cineapp.domain.model.CreateSpec;
import org.springframework.stereotype.Service;

@Service
public interface EspectadorService {

    void criar(CreateSpec dto);
}

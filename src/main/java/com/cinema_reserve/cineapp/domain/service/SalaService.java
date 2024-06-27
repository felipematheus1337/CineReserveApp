package com.cinema_reserve.cineapp.domain.service;

import com.cinema_reserve.cineapp.domain.model.SalaRequest;
import com.cinema_reserve.cineapp.domain.model.SalaResponse;
import org.springframework.stereotype.Service;

@Service
public interface SalaService {

    SalaResponse criar(SalaRequest dto);
}

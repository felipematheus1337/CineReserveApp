package com.cinema_reserve.cineapp.application.rest;

import com.cinema_reserve.cineapp.domain.model.ReservarDTO;
import com.cinema_reserve.cineapp.domain.service.ReservaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/business")
@RequiredArgsConstructor
@CrossOrigin("*")
public class BusinessController {

    private final ReservaService reservaService;

    public ResponseEntity<Void> reservar(@RequestBody ReservarDTO dto) {

        this.reservaService.reservar(dto);

        return ResponseEntity.ok().build();
    }
}

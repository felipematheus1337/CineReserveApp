package com.cinema_reserve.cineapp.application.rest;

import com.cinema_reserve.cineapp.domain.model.CreateSpec;
import com.cinema_reserve.cineapp.domain.service.EspectadorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/spec")
@RequiredArgsConstructor
public class EspectadorController {

    private final EspectadorService espectadorService;

    @PostMapping
    public ResponseEntity<Void> cadastrar(CreateSpec espectador) {

        this.espectadorService.criar(espectador);

        return ResponseEntity.ok().build();
    }
}

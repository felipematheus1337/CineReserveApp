package com.cinema_reserve.cineapp.application.rest;


import com.cinema_reserve.cineapp.domain.model.SalaRequest;
import com.cinema_reserve.cineapp.domain.model.SalaResponse;
import com.cinema_reserve.cineapp.domain.service.SalaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/sala")
@CrossOrigin("*")
@RequiredArgsConstructor
public class SalaController {

    private final SalaService salaService;

    @PostMapping
    ResponseEntity<SalaResponse> criarSala(@RequestBody SalaRequest dto) {

        var sala = this.salaService.criar(dto);

        return ResponseEntity.ok(sala);
    }
}

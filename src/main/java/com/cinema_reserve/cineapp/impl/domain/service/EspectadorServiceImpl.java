package com.cinema_reserve.cineapp.impl.domain.service;

import com.cinema_reserve.cineapp.domain.model.CreateSpec;
import com.cinema_reserve.cineapp.domain.model.Espectador;
import com.cinema_reserve.cineapp.domain.repository.EspectadorRepository;
import com.cinema_reserve.cineapp.domain.service.EspectadorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class EspectadorServiceImpl implements EspectadorService {

    private final EspectadorRepository espectadorRepository;

    @Override
    public void criar(CreateSpec dto) {

        if (hasInvalidParameters(dto.getEmail(), dto.getCpf())) {
            throw new RuntimeException();
        }

        var spec = Espectador.builder()
                .email(dto.getEmail())
                .cpf(dto.getEmail())
                .nome(dto.getNome())
                .build();

        this.espectadorRepository.save(spec);

    }

    public boolean hasInvalidParameters(String email, String cpf) {
        return this.espectadorRepository.existsByEmailAndCpf(email, cpf);
    }
}

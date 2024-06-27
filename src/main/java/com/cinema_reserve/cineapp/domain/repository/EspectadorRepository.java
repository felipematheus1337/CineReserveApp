package com.cinema_reserve.cineapp.domain.repository;

import com.cinema_reserve.cineapp.domain.model.Espectador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EspectadorRepository extends JpaRepository<Espectador, Long> {
}

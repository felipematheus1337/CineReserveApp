package com.cinema_reserve.cineapp.domain.repository;

import com.cinema_reserve.cineapp.domain.model.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Long> {
}

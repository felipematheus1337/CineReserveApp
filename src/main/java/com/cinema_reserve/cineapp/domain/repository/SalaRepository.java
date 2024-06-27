package com.cinema_reserve.cineapp.domain.repository;

import com.cinema_reserve.cineapp.domain.model.Sala;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalaRepository extends JpaRepository<Sala, Long> {
}

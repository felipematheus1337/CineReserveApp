package com.cinema_reserve.cineapp.domain.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Entity
@Table(name = "tb_reserva")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Reserva {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Espectador espectador;

    @ManyToOne
    private Sala sala;

    @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm")
    @CreationTimestamp
    private LocalDateTime dataHora;

    private int numeroCadeira;

}

package com.cinema_reserve.cineapp.domain.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Entity
@Table(name = "tb_sala")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Sala {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private int capacidade;

    @OneToMany(mappedBy = "sala")
    private List<Reserva> reservas;

    private SalaType tipoDeSala;


}

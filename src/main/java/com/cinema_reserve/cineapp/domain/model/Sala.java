package com.cinema_reserve.cineapp.domain.model;


import jakarta.persistence.*;

import java.util.List;


@Entity
@Table(name = "tb_sala")
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

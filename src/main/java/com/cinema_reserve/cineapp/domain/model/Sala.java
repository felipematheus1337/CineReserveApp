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

    private int capacidadeTotal = 80;

    private int capacidadeAtual;

    @OneToMany(mappedBy = "sala", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Reserva> reservas;

    private SalaType tipoDeSala;


}

package com.cinema_reserve.cineapp.domain.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import java.util.List;

@Entity
@Table(name = "tb_espectador")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Espectador {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CPF
    private String cpf;

    private String nome;

    private String email;


    @OneToMany(mappedBy = "espectador")
    private List<Reserva> reservas;
}

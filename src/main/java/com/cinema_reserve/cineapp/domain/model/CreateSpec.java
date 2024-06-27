package com.cinema_reserve.cineapp.domain.model;


import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateSpec {

    private String nome;

    @CPF
    private String cpf;

    @Email
    private String email;
}

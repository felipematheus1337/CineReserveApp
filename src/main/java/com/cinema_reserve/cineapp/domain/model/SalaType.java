package com.cinema_reserve.cineapp.domain.model;

public enum SalaType {

    PLATINUM("PLATINUM"),
    PREMIUM("PREMIUM");

    public String tipoSala;

    SalaType(String tipoSala) {
        this.tipoSala = tipoSala;
    }
}

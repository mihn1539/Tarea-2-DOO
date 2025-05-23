package org.example;

import java.time.Duration;
import java.time.Instant;

public class ReunionPresencial extends Reunion {
    private String sala;

    public ReunionPresencial(Instant hora, Duration duracion, Empleado emp, String sala, tipoReunion tipo) {
        super(hora, duracion, emp, tipo);
        this.sala = sala;
    }

    @Override
    public String getUbicacion() {
        return "Sala: " + sala;
    }

    public void setSala(String sala) {
        this.sala = sala;
    }
}
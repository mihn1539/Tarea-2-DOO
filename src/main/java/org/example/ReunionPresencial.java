package org.example;

import java.time.Duration;
import java.time.Instant;
import java.util.Date;

public class ReunionPresencial extends Reunion {
    private String sala;

    public ReunionPresencial(Date dia, Instant hora, Duration duracion, Empleado emp, String sala, tipoReunion tipo) {
        super(dia, hora, duracion, emp, tipo);
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
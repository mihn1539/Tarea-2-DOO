package org.example;

import java.time.Duration;
import java.time.Instant;
import java.util.Date;

public class ReunionPresencial extends Reunion {
    private String sala;

    public ReunionPresencial(Date fecha, Instant hora, Duration duracion, Empleado emp, String sala) {
        super(fecha, hora, duracion, emp);
        this.sala = sala;
    }

    public String getUbicacion() {
        return "Sala: " + sala;
    }

    public String getSala() {
        return "Sala: " + sala;
    }
}
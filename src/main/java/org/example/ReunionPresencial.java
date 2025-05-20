package org.example;

import java.time.Duration;
import java.time.Instant;

public class ReunionPresencial extends Reunion {
    private String sala;

    public ReunionPresencial(Instant hora, Duration duracion, Empleado emp, String sala) {
        super(hora, duracion, emp);
        this.sala = sala;
    }

    public String getSala() {
        return sala;
    }

    public void setSala(String sala) {
        this.sala = sala;
    }
}
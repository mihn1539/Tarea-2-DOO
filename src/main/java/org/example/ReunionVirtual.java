package org.example;

import java.time.Duration;
import java.time.Instant;

public class ReunionVirtual extends Reunion {
    private String enlace;

    public ReunionVirtual(Instant hora, Duration duracion, Empleado emp, String enlace) {
        super(hora, duracion, emp);
        this.enlace = enlace;
    }

    public String getEnlace() {
        return enlace;
    }

    public void setEnlace(String enlace) {
        this.enlace = enlace;
    }
}
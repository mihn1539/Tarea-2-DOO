package org.example;

import java.time.Duration;
import java.time.Instant;
import java.util.Date;

public class ReunionVirtual extends Reunion {
    private String enlace;

    public ReunionVirtual(Date fecha, Instant hora, Duration duracion, Empleado emp, String enlace) {
        super(fecha, hora, duracion, emp);
        this.enlace = enlace;
    }

    public String getEnlace() {
        return "Enlace: " + enlace;
    }
}
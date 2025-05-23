package org.example;

import java.time.Duration;
import java.time.Instant;

public class ReunionVirtual extends Reunion {
    private String enlace;

    public ReunionVirtual(Instant hora, Duration duracion, Empleado emp, String enlace, tipoReunion tipo) {
        super(hora, duracion, emp, tipo);
        this.enlace = enlace;
    }

    @Override
    public String getUbicacion() {
        return "Enlace: " + enlace;
    }

    public void setEnlace(String enlace) {
        this.enlace = enlace;
    }
}
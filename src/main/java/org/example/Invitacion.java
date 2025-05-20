package org.example;
import java.time.Instant;
import java.util.ArrayList;

public class Invitacion {
    private Instant hora;
    private Empleado empleado;
    private Reunion reunion;

    public Invitacion(Instant h, Empleado emp, Reunion reunion) {
        this.hora = h;
        this.empleado = emp;
        this.reunion = reunion;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public Reunion getReunion() {
        return reunion;
    }

    public Instant getHora() {
        return hora;
    }

    public void setEmpleado(Empleado emp){
        empleado = emp;
    }
}

package org.example;
import java.time.Instant;
import java.util.ArrayList;

public class Invitacion {
    private Instant hora;
    private Invitable invitado;
    private Reunion reunion;

    public Invitacion(Invitable invitado, Reunion reunion) {
        this.hora = Instant.now();
        this.invitado = invitado;
        this.reunion = reunion;
    }

    public Invitable getInvitado() {
        return invitado;
    }

    public Reunion getReunion() {
        return reunion;
    }

    public Instant getHora() {
        return hora;
    }

    public void setEmpleado(Invitable invi){
        invitado = invi;
    }
}

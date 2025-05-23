package org.example;
import java.time.Instant;

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

    @Override
    public String toString() {
        return "Invitación a reunión organizada por:" + reunion.getOrganizador() + " prevista para las: " + getHora() + " en " + reunion.getUbicacion();
    }
    public void setEmpleado(Invitable invi) {
        invitado = invi;
    }
}
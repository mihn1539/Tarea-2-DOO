package org.example;
import java.time.Instant;

public class Invitacion {
    private Instant hora;
    private Invitable invitado;
    private Reunion reunion;

    public Invitacion(Invitable invitado, Reunion reunion) {
        this.invitado = invitado;
        this.reunion = reunion;
        this.hora = reunion.getHoraPrevista();
    }

    public String getInvitado() {
        return invitado.toString();
    }

    public Reunion getReunion() {
        return reunion;
    }

    public Instant getHora() {
        return hora;
    }

    @Override
    public String toString(){
        return "Invitación a reunión organizada por:\n" + reunion.getOrganizador() + "\nPrevista para las: " + getHora() + "\n" + reunion.getUbicacion();
    }
}

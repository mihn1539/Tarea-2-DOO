package org.example;
import java.time.Instant;
import java.util.ArrayList;

public class Invitacion {
    private int hora;
    private ArrayList<Invitable> invitados = new ArrayList<>();

    public Invitacion(int h){
        this.hora = h;
    }

    public int cantidadInvitados(){
        return invitados.size();
    }

    public void agregarInvitado(Invitable e){
        invitados.add(e);
    }
}

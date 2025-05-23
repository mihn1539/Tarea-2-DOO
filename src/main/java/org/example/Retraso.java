package org.example;
import java.time.Instant;
import java.util.ArrayList;


public class Retraso extends Asistencia {
    public ArrayList<Instant> horaAtraso = new ArrayList<>();

    public Retraso(Reunion reunion) {
        super(reunion);
    }

    public void agregarAsistente(Invitado inv, Instant hora) {
        super.agregarAsistente(inv);
        horaAtraso.add(hora);
    }

    @Override
    public String toString(){
        String result = "Lista de retrasos: \n";
        for(int i = 0; i < super.asista.size(); i++) {
            Invitado inv = asista.get(i);
            Instant hora = horaAtraso.get(i);
            result += "- " + inv.getNombreCompleto() + " (correo: " + inv.getCorreo() + "). Hora de llegada: " + hora.toString() + "\n";

        }
        return result;
    }
}
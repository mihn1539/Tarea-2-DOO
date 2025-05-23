package org.example;
import java.time.Instant;
import java.util.ArrayList;


public class Retraso extends Asistencia {
    public ArrayList<Instant> horaAtraso = new ArrayList<>();

    public Retraso(Reunion reunion) {
        super(reunion);
    }

    public void agregarAsistente(Invitado invitado, Instant hora) {
        super.agregarAsistente(invitado);
        horaAtraso.add(hora);
    }

    @Override
    public String toString(){
        String f = "Lista de retrasos: \n";
        for(int i = 0; i<super.asista.size(); i++){
            f += super.asista.get(i).toString() + "\nHora de llegada: " + horaAtraso.get(i).toString() + "\n";

        }
        return f;
    }
}

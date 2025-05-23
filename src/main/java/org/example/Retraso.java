package org.example;
import java.time.Instant;
import java.util.ArrayList;


public class Retraso extends Asistencia {
    public ArrayList<Instant> horaAtraso = new ArrayList<>();

    public Retraso(Reunion reunion) {
        super(reunion);
    }

    public void añadirAsistente(Empleado emp, Instant hora) {
        super.añadirAsistente(emp);
        horaAtraso.add(hora);
    }

    @Override
    public String toString(){
        String f = "Lista de retrasos: \n\n";
        for(int i=0; i<super.asist.size();i++){
            f += super.asist.get(i).toString() + "\nHora de llegada: " + horaAtraso.get(i).toString() + "\n\n";

        }
        return f;
    }
}

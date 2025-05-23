package org.example;
import java.time.Instant;
import java.util.ArrayList;


public class Retraso extends Asistencia {
    private ArrayList<Instant> horaAtraso = new ArrayList<>();

    public Retraso(Reunion reunion) {
        super(reunion);
    }

    public void añadirAsistente(Empleado emp, Instant hora) {
        super.añadirAsistente(emp);
        horaAtraso.add(hora);
    }

    @Override
    public String toString(){
        String f = "";
        for(int i=0; i<super.asist.size();i++){
            f += super.asist.get(i).toString() + " Hora de llegada: " + horaAtraso.get(i).toString();
        }

        return f;
    }
}

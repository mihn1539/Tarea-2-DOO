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
}

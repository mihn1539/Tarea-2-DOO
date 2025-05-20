package org.example;
import java.time.Instant;
import java.util.ArrayList;

public class Retraso extends Asistencia {
    private ArrayList<Instant> horaAtrasos = new ArrayList<>();

    public Retraso(Reunion reunion) {
        super(reunion);
    }

    public void añadirAsistente(Empleado emp, Instant hora) {
        super.añadirAsistente(emp);
        horaAtrasos.add(hora);
    }
}

package org.example;
import java.util.ArrayList;

public class Asistencia  {
    public ArrayList<Empleado> asist;
    public Reunion reunion;


    public Asistencia(Reunion reunion) {
        this.reunion = reunion;
        asist = new ArrayList<>();
    }

    public void añadirAsistente(Empleado emp) {
        asist.add(emp);
    }
}

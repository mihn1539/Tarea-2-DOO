package org.example;
import java.util.ArrayList;

public class Asistencia  {
    private ArrayList<Empleado> asist;
    public Reunion reunion;


    public Asistencia(Reunion reunion) {
        this.reunion = reunion;
        asist = new ArrayList<>();
    }

    public void agregarAsistente(Empleado emp) {
        asist.add(emp);
    }

    public ArrayList obtenerAsistencia(){
        return asist;
    }
}

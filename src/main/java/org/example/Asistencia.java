package org.example;
import java.util.ArrayList;

public class Asistencia  {
    public ArrayList<Empleado> asista;
    public Reunion reunion;


    public Asistencia(Reunion reunion) {
        this.reunion = reunion;
        asista = new ArrayList<>();
    }

    public void agregarAsistente(Empleado emp) {
        asista.add(emp);
    }

    public ArrayList obtenerAsistencia(){
        return asista;
    }

    @Override
    public String toString() {
        String f = "Lista de asistencia: \n\n";
        for (int i = 0; i < asista.size(); i++) {
            f += asista.get(i).toString() + "\n\n";
        }
        return f;
    }
}

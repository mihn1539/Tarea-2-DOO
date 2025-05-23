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

    @Override
    public String toString(){
        String f = "Lista de asistencia: \n\n";
        for(int i=0; i<asist.size();i++){
            f += asist.get(i).toString() + "\n\n";
        }
        return f;
    }
}

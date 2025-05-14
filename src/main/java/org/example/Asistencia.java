package org.example;
import java.util.ArrayList;

public class Asistencia  {
    private ArrayList<Empleado> asist = new ArrayList<>();
    private Reunion reunion;


    public Asistencia(){

    }

    public void verificarAsistente(Empleado emp) {
        if(emp.invitacion.toString().equals(reunion.invitados.toString())) {
            asist.add(emp);
        }else{
            System.out.println("No tiene invitación valida para esta reunion.");
        }
    }
}

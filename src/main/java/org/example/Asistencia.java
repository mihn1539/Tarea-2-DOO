package org.example;
import java.util.ArrayList;

public class Asistencia {
    private ArrayList<Empleado> asist = new ArrayList<>();
    private int reunionCodigo;

    public Asistencia(){

    }

    public void nuevoAsistente(Empleado emp){
        if(emp.invitacion != null) {
            asist.add(emp);
        }else{
            System.out.println("El empleado no tiene invitacion valida para esta reunion.");
        }
    }


}

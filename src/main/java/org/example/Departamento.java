package org.example;
import java.util.ArrayList;

public class Departamento implements Invitable{
    private String nombre;
    private ArrayList<Empleado> empleados = new ArrayList<>();

    public Departamento(String n){
        this.nombre = n;
    }

    public int obtenerCantidadEmpleados(){
        return empleados.size();
    }

    public void agregarEmpleado(Empleado emp){
        empleados.add(emp);
    }

    @Override
    public void invitar(Reunion reunion) {
        for (int i = 0; i < obtenerCantidadEmpleados();i++){
            Empleado emp = empleados.get(i);
            Invitacion inv = new Invitacion(emp, reunion);
            emp.invitacion = inv;
            inv.getReunion().invitaciones.add(inv);
            System.out.println("Invitacion enviada a " + emp.getNombre() + " " + emp.getApellidos() + " (" + emp.getCorreo() + ").");
        }
    }
}

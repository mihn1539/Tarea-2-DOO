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
        emp.setDepartamento(this);
    }

    public String getNombre(){
        return nombre;
    }

    public ArrayList getEmpleados(){
        return  empleados;
    }

    @Override
    public void invitar(Reunion reunion) {
        for (Empleado emp : empleados){
            Invitacion inv = new Invitacion(emp, reunion);
            emp.invitacion = inv;
            reunion.invitaciones.add(inv);
        }
    }
}
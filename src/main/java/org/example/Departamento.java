package org.example;
import java.util.ArrayList;

public class Departamento implements Invitable{
    private String nombre;
    private ArrayList<Empleado> empleados = new ArrayList<>();

    public Departamento(String n){
        this.nombre = n;
    }

    public void agregarEmpleado(Empleado emp){
        empleados.add(emp);
        emp.setDepartamento(this);
    }

    public int obtenerCantidadEmpleados(){
        return empleados.size();
    }

    public String getNombre(){
        return nombre;
    }

    @Override
    public void invitar(Reunion reunion) {
        for (int i = 0; i < obtenerCantidadEmpleados();i++){
            Empleado emp = empleados.get(i);
            Invitacion inv = new Invitacion(emp, reunion);
            emp.invitacion = inv;
            reunion.invitaciones.add(inv);
        }
    }
}

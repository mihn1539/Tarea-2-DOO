package org.example;

import java.time.Instant;

public class Empleado extends Invitado {
    private String id;
    private String apellidos;
    private String nombre;
    private String correo;
    private Departamento dept;

    public Empleado(String id,String ap,String nomb, String correo, Departamento dept){
        super();
        this.id = id;
        this.apellidos = ap;
        this.nombre = nomb;
        this.correo = correo;
        if(dept!=null) {
            dept.agregarEmpleado(this);
        }
    }

    public String getId(){
        return id;
    }

    @Override
    public void invitar(Reunion reunion) {
        Invitacion inv = new Invitacion(this, reunion);
        this.invitacion = inv;
        reunion.invitaciones.add(inv);
    }

    public String getApellidos(){
        return apellidos;
    }

    public String getNombre(){
        return nombre;
    }

    public String getCorreo(){
        return correo;
    }

    public String getDepartamento(){
        return dept.getNombre();
    }

    public void setDepartamento(Departamento dep){
        this.dept = dep;
    }

    @Override
    public String toString(){
        return "Empleado: " + getNombre() +" "+ getApellidos() + "\nID: " + getId() + "\nCorreo: " + getCorreo() + "\nDepartamento: " + getDepartamento();
    }

}

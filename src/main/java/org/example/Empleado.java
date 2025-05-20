package org.example;

import java.time.Instant;

public class Empleado implements Invitable {
    private String id;
    private String apellidos;
    private String nombre;
    private String correo;
    private Departamento dept;
    public Invitacion invitacion;

    public Empleado(String id,String ap,String nomb, String correo, Departamento dept){
        this.id = id;
        this.apellidos = ap;
        this.nombre = nomb;
        this.correo = correo;
        this.dept = dept;
        dept.agregarEmpleado(this);
        this.invitacion = null;
    }

    public String getId(){
        return id;
    }

    @Override
    public void invitar(Reunion reunion) {
        Invitacion inv = new Invitacion(this, reunion);
        inv.getReunion().invitaciones.add(inv);
        System.out.println("Invitacion enviada a " + nombre + " " + apellidos + " (" + correo + ").");
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

}

package org.example;

public abstract class Invitado implements Invitable {
    public Invitacion invitacion = null;
    protected String nombre;
    protected String apellidos;
    protected String correo;


    public Invitado(String nombre, String apellidos, String correo) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.correo = correo;
    }

    public String getNombreCompleto() {
        return nombre + " " + apellidos;
    }

    public String getCorreo() {
        return correo;
    }

    public abstract void invitar(Reunion reunion);
}
package org.example;

public class Externos implements Invitable {
    private static String id = "EXT";
    private String apellidos;
    private String nombre;
    private String correo;
    public Invitacion invitacion;

    public Externos(String ap, String nomb, String correo){
        this.apellidos = ap;
        this.nombre = nomb;
        this.correo = correo;
        this.invitacion = null;
    }

    public String getApellidos(){
        return apellidos;
    }

    public String getCorreo(){
        return correo;
    }

    public String getNombre(){
        return nombre;
    }

    @Override
    public String toString(){
        return "Externo: " + getNombre() + " " + getApellidos() + "\nID: EXT" + "\nCorreo: " + getCorreo();
    }

    @Override
    public void invitar(Reunion reunion) {
        Invitacion inv = new Invitacion(this, reunion);
        this.invitacion = inv;
        reunion.invitaciones.add(inv);
    }
}
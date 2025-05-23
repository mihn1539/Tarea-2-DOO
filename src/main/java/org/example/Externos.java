package org.example;

public class Externos extends Invitado {
    private static String id = "EXT";
    private String apellidos;
    private String nombre;
    private String correo;


    public Externos(String ap, String nomb, String correo){
        super();
        this.apellidos = ap;
        this.nombre = nomb;
        this.correo = correo;
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
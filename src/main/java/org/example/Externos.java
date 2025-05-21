package org.example;
import java.time.Instant;
public class Externos implements Invitable {
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

    @Override
    public void invitar(Reunion reunion) {
        Invitacion inv = new Invitacion(this, reunion);
        this.invitacion = inv;
        reunion.invitaciones.add(inv);
    }
}
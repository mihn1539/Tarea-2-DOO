package org.example;

public class Externos extends Invitado {

    public Externos(String ap, String nomb, String correo){
        super(nomb, ap, correo);
    }

    @Override
    public String toString(){
        return "Externo: " + getNombreCompleto() + "\nID: EXT" + "\nCorreo: " + getCorreo();
    }

    @Override
    public void invitar(Reunion reunion) {
        Invitacion inv = new Invitacion(this, reunion);
        this.invitacion = inv;
        reunion.invitaciones.add(inv);
    }
}
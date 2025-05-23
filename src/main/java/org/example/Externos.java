package org.example;

/**
 * Representa a una persona con la capacidad de ser invitada a una reunión.
 * Es ajena a una empresa.
 * Es heredada de la clase {@link Invitado} .
 */
public class Externos extends Invitado {

    /**
     * Crea una instancia de Externos.
     *
     * @param ap Apellidos del externo.
     * @param nomb Nombre del externo.
     * @param correo Correo del externo.
     */
    public Externos(String ap, String nomb, String correo){
        super(nomb, ap, correo);
    }

    /**
     * Entrega una representación en texto de los datos del externo.
     *
     * @return Cadena de caracteres con los datos del externo.
     */
    @Override
    public String toString(){
        return "Externo: " + getNombreCompleto() + "\nID: EXT" + "\nCorreo: " + getCorreo();
    }

    /**
     * Invita al externo a una reunión.
     *
     * @param reunion Reunión a la que se invita al invitado.
     */
    @Override
    public void invitar(Reunion reunion) {
        Invitacion inv = new Invitacion(this, reunion);
        this.invitacion = inv;
        reunion.invitaciones.add(inv);
    }
}
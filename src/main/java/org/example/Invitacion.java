package org.example;
import java.time.Instant;

/**
 * Invitacion a la {@link Reunion} hecha para el respectivo {@link Invitado}.
 * */
public class Invitacion {

    /**
     * Hora de creacion de la invitacion
     * */
    private Instant hora;
    /**
     * {@link Invitado} a quien va dirigida.
     * */
    private Invitable invitado;
    /**
     * {@link Reunion} a la cual es invitado.
     * */
    private Reunion reunion;

    /**
     * Constructor
     * @param reunion Reunion a la cual es invitado.
     * @param invitado A quien se le dirige la invitacion.
     * */
    public Invitacion(Invitable invitado, Reunion reunion) {
        this.hora = Instant.now();
        this.invitado = invitado;
        this.reunion = reunion;
    }

    /**
     * Getter de la propiedad invitado.
     * @return {@link Invitado} a quien se <b>refiere</b> la invitacion.
     * */
    public Invitable getInvitado() {
        return invitado;
    }

    /**
     * Getter de la propiedad reunion.
     * @return {@link Reunion} a la que se <b>refiere</b> la invitacion.
     * */
    public Reunion getReunion() {
        return reunion;
    }

    /**
     * Getter de la propiedad hora
     * @return <b>Instante</b> en el cual fue realizada la invitacion.
     * */
    public Instant getHora() {
        return hora;
    }

    /**
     * Metodo heredado de la clase {@link Object}, con <i>@Override</i>. Este transforma en formato {@link String} toda la informacion recopilada en esta clase.
     * @return Organizador, hora y ubicacion de la reunion a la cual se referencia.
     * */
    @Override
    public String toString() {
        return "Invitación a reunión organizada por:" + reunion.getOrganizador() + " prevista para las: " + getHora() + " en " + reunion.getUbicacion();
    }

    /**
     * Setter de la propiedad invitado.
     * @param invi Nueva persona {@link Invitable} a la cual se dirige la invitacion.
     * */
    public void setEmpleado(Invitable invi) {
        invitado = invi;
    }
}
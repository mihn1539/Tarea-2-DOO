package org.example;

/**
 * Clase abstracta que representa a un invitado de una reunión.
 * Implementa la interfaz {@Link Invitable}.
 */
public abstract class Invitado implements Invitable {
    /** Invitación asociada al invitado, si existe.*/
    protected Invitacion invitacion = null;

    /** Nombre del invitado. */
    protected String nombre;

    /** Apellidos del empleado. */
    protected String apellidos;

    /** Correo del invitado. */
    protected String correo;

    /**
     * Crea un nuevo invitado con los datos correspondientes.
     *
     * @param nombre Nombre del invitado.
     * @param apellidos Apellidos del invitado.
     * @param correo Correo del invitado.
     */
    public Invitado(String nombre, String apellidos, String correo) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.correo = correo;
    }

    /**
     * Entrega el nombre completo del invitado.
     *
     * @return Nombre y apellidos del invitado..
     */
    public String getNombreCompleto() {
        return nombre + " " + apellidos;
    }

    /**
     * Entrega el correo del invitado.
     *
     * @return Correo del invitado.
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * Metodo abstracto el cual define cómo se invita al invitado a una reunión.
     *
     * @param reunion Reunión a la que se invita al invitado.
     */
    public abstract void invitar(Reunion reunion);
}
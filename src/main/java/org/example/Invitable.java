package org.example;

/**
 * Interfaz, que indica que cada clase a la cual se le implementa puede ser invitada a una {@link Reunion}.
 * */
public interface Invitable {

    /**
     * Metodo que se encarga de invitar, dependiendo su forma en a <i>quien</i> invita.
     * @param reunion Reunion a la cual se les invita.
     * */
    void invitar(Reunion reunion);
}

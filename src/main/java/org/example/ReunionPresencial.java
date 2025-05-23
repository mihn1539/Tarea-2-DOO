package org.example;

import java.time.Duration;
import java.time.Instant;

/**
 * Subclase de {@link Reunion}, la cual se realizara de manera <i>presencial</i>
 * */
public class ReunionPresencial extends Reunion {
    /**
     * Sala donde se realizara la {@link Reunion}
     * */
    private String sala;

    /**
     * Constructor que ocupa el constructor de su super clase.
     * @param hora Fecha y hora prevista de la reunión.
     * @param duracion Duración prevista de la reunión.
     * @param emp Empleado organizador.
     * @param sala Donde se realizara la reunion.
     * @param tipo Tipo de reunión.
     * */
    public ReunionPresencial(Instant hora, Duration duracion, Empleado emp, String sala, tipoReunion tipo) {
        super(hora, duracion, emp, tipo);
        this.sala = sala;
    }

    /**
     * Getter de la propiedad sala.
     * @return Sala donde se realizara la reunion.
     * */
    @Override
    public String getUbicacion() {
        return "Sala: " + sala;
    }

    /**
     * Setter de la propiedad sala.
     * @param sala Nueva sala donde se realizara la reunion.
     * */
    public void setSala(String sala) {
        this.sala = sala;
    }
}
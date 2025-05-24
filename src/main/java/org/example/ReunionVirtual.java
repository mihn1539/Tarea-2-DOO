package org.example;

import java.time.Duration;
import java.time.Instant;

/**
 * Subclase de {@link Reunion}, la cual se realizara de manera <i>virtual</i>
 * */
public class ReunionVirtual extends Reunion {
    /**
     * enlace URL donde se realizara la {@link Reunion}
     * */
    private String enlace;

    /**
     * Constructor que ocupa el constructor de su super clase.
     * @param hora Fecha y hora prevista de la reunión.
     * @param duracion Duración prevista de la reunión.
     * @param emp Empleado organizador.
     * @param enlace Donde se realizara la reunion.
     * @param tipo Tipo de reunión.
     * */
    public ReunionVirtual(Instant hora, Duration duracion, Empleado emp, String enlace, tipoReunion tipo) {
        super(hora, duracion, emp, tipo);
        this.enlace = enlace;
    }

    /**
     * Getter de la propiedad enlace.
     * @return URL donde se realizara la reunion.
     * */
    @Override
    public String getUbicacion() {
        return "Enlace: " + enlace;
    }

    /**
     * Setter de la propiedad sala.
     * @param enlace Nuevo enlace donde se realizara la reunion.
     * */
    public void setEnlace(String enlace) {
        this.enlace = enlace;
    }
}
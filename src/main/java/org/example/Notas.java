package org.example;
import java.time.Instant;

/**
 * Anotaciones que se pueden realizar en la reunion.
 * */

public class Notas {
    /**
     * Contenido de la nota en cuestion.
     * */
    private String nota;
    /**
     * Hora en la que se realiza la nota.
     * */
    private Instant horaNota;

    /**
     * Constructor.
     * @param contenido lo que se escribe en la nota.
     * */
    public Notas(String contenido){
        this.nota = contenido;
        this.horaNota = Instant.now();
    }

    /**
     * Getter de la propiedad nota.
     * @return Escritura de la nota.
     * */
    public String getNota() {
        return nota;
    }

    /**
     * Getter de la propiedad nota.
     * @return Hora en la que se realiza la nota
     * */
    public Instant getHoraNota(){
        return horaNota;
    }

    /**
     * Metodo heredado de la clase {@link Object}, con <i>override</i>. Este transforma en formato {@link String} toda la informacion recopilada en esta clase.
     * @return hora y contenido de la nota.
     * */
    @Override
    public String toString() {
        return "(" + horaNota + ") " + nota;
    }
}
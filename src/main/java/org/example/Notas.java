package org.example;
import java.time.Instant;

public class Notas {
    private String nota;
    private Instant horaNota;

    public Notas(String contenido){
        this.nota = contenido;
        this.horaNota = Instant.now();
    }

    public String getNota() {
        return nota;
    }

    public Instant getHoraNota(){
        return horaNota;
    }

    @Override
    public String toString() {
        return "(" + horaNota + ") " + nota;
    }
}
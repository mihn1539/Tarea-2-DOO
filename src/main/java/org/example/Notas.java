package org.example;

import java.time.Instant;

public class Notas {
    private String nota;
    private Instant horaNota;

    public Notas(String contenido, Instant hora){
        this.nota = contenido;
        this.horaNota = hora;
    }

    public String getNota() {
        return nota;
    }

    public Instant getHoraNota(){
        return horaNota;
    }
}

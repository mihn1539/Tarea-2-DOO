package org.example;
import java.util.ArrayList;
import java.util.Date;
import java.time.Instant;
import java.time.Duration;

public class Reunion {
    private Date fecha;
    private Instant horaPrevista;
    private Duration duracionPrevista;
    private Instant horaInicio;
    private Instant horaFin;
    private Asistencia asistencia;
    private Invitacion invitados;
    private ArrayList<Notas> notas;

    public Reunion(Date fecha, Instant hora, Duration duracion){
        this.fecha = fecha;
        this.horaPrevista = hora;
        this.duracionPrevista = duracion;
        iniciar();
    }

    public ArrayList obtenerAsistencia(){
        return null;
    }

    public ArrayList obtenerAusencias(){
        return null;
    }

    public ArrayList obtenerRetrasos(){
        return null;
    }

    public int obtenerTotalAsistencia(){
        return 0;
    }

    public float obtenerPorcentajeAsistencia(){
        return 0;
    }

    public float calcularTiempoReal(){
        return 0;
    }

    public void crearNota(String nota){
        Notas n = new Notas(nota, Instant.now());
        notas.add(n);
    }

    public void iniciar(){
        horaInicio = Instant.now();
    }

    public void finalizar(){
        horaFin = Instant.now();
    }
}

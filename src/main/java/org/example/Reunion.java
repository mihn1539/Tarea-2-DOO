package org.example;
import java.util.ArrayList;
import java.util.Date;
import java.time.Instant;
import java.time.Duration;

public abstract class Reunion {
    private Date fecha;
    private Instant horaPrevista;
    private Duration duracionPrevista;
    private Instant horaInicio;
    private Instant horaFin;
    private Asistencia asistencia;
    public Invitacion invitados;
    private ArrayList<Notas> notas;
    private String organizador;

    public Reunion(Date fecha, Instant hora, Duration duracion, Empleado emp){
        this.fecha = fecha;
        this.horaPrevista = hora;
        this.duracionPrevista = duracion;
        this.organizador = emp.getId();
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

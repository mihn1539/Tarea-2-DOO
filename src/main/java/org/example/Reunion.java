package org.example;
import java.util.ArrayList;
import java.time.Instant;
import java.time.Duration;

public abstract class Reunion {
    protected Instant horaPrevista;
    protected Duration duracionPrevista;
    protected Asistencia asistencia;
    protected Retraso retraso;

    protected Instant horaInicio;
    protected Instant horaFin;

    protected ArrayList<Notas> notas;
    protected Empleado organizador;
    public ArrayList<Invitacion> invitaciones = new ArrayList<>();

    public Reunion(Instant hora, Duration duracion, Empleado emp){
        this.horaPrevista = hora;
        this.duracionPrevista = duracion;
        this.organizador = emp;
        this.asistencia = new Asistencia(this);
        this.retraso = new Retraso(this);
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
        Duration duration = Duration.between(horaInicio, horaFin);
        long tiempoReal = duration.getSeconds();
        return (float)tiempoReal;
    }

    public void crearNota(String nota){
        Notas n = new Notas(nota);
        notas.add(n);
    }

    public void iniciar(){
        horaInicio = Instant.now();
    }

    public void finalizar(){
        horaFin = Instant.now();
    }

    public void unirseReunion(Empleado emp){
        if (emp.invitacion.getReunion().equals(this)){
            if (Instant.now().isAfter(horaPrevista)){
                retraso.agregarAsistente(emp);
            } else {
                asistencia.agregarAsistente(emp);
            }
        } else {
            System.out.println("No tiene la invitacion pertinente a esta reunion.");
        }
    }
}
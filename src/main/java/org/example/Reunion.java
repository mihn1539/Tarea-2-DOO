package org.example;
import java.time.LocalDate;
import java.util.ArrayList;
import java.time.Instant;
import java.time.Duration;

public abstract class Reunion {
    private LocalDate fecha;
    private Instant horaPrevista;
    private Duration duracionPrevista;
    private Instant horaInicio;
    private Instant horaFin;
    private Asistencia asistencia;
    private Retraso retraso;
    public ArrayList<Invitacion> invitaciones;
    private ArrayList<Notas> notas;
    private String organizador;

    public Reunion(Instant hora, Duration duracion, Empleado emp){
        this.fecha = LocalDate.now();
        this.horaPrevista = hora;
        this.duracionPrevista = duracion;
        this.organizador = emp.getId();
        invitaciones = new ArrayList<>();
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
        long tiempoReal = duration.getNano();
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
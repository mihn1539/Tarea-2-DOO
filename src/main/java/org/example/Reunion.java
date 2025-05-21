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
    private Retraso retraso;
    public ArrayList<Invitacion> invitaciones;
    private ArrayList<Notas> notas;
    private Empleado organizador;

    public Reunion(Date fecha, Instant hora, Duration duracion, Empleado emp){
        this.fecha = fecha;
        this.horaPrevista = hora;
        this.duracionPrevista = duracion;
        this.organizador = emp;
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
        return 0;
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

    public Instant getHoraPrevista(){
        return horaPrevista;
    }

    public abstract String getUbicacion();

    public String getOrganizador(){
        return organizador.toString();
    }

    public void unirseReunion(Empleado emp){
        if(emp.invitacion.getReunion().equals(this)){
            if(this.horaPrevista.compareTo(Instant.now()) > 0){
                retraso.añadirAsistente(emp,Instant.now());
            }else{
                asistencia.añadirAsistente(emp);
            }
        }else {
            System.out.println("No tiene la invitacion pertinente a esta reunion.");
        }
    }
}
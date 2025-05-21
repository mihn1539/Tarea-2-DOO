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
    private String organizador;

    public Reunion(Date fecha, Instant hora, Duration duracion, Empleado emp){
        this.fecha = fecha;
        this.horaPrevista = hora;
        this.duracionPrevista = duracion;
        this.organizador = emp.getId();
        invitaciones = new ArrayList<>();
        this.asistencia = new Asistencia(this);
        this.retraso = new Retraso(this);
    }

    public ArrayList obtenerAsistencia(){
        ArrayList<Object> asist = new ArrayList<>();
        for(Object e : asistencia.obtenerAsistencia()){
            asist.add(e);
        }
        for(Object e : retraso.obtenerAsistencia()){
            asist.add(e);
        }
        return asist;
    }

    public ArrayList obtenerAusencias(){
        ArrayList<Invitable> ausencias = new ArrayList<>();
        for(Invitacion i : invitaciones){
            Boolean asistio = false;
            for(Object e : asistencia.obtenerAsistencia()){
                if(i.getInvitado().equals(e)){
                    asistio = true;
                    break;
                }
            }
            if(!asistio) {
                for (Object e : retraso.obtenerAsistencia()) {
                    if (i.getInvitado().equals(e)) {
                        asistio = true;
                        break;
                    }
                }
            }
            if(!asistio){
                ausencias.add(i.getInvitado());
            }
        }
        return ausencias;
    }

    public ArrayList obtenerRetrasos(){
        return retraso.obtenerAsistencia();
    }

    public int obtenerTotalAsistencia(){
        return obtenerAsistencia().size();
    }

    public float obtenerPorcentajeAsistencia(){
        return (float) (100 * obtenerTotalAsistencia()) / invitaciones.size();
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

    public void unirseReunion(Empleado emp){
        if(emp.invitacion.getReunion().equals(this)){
            if(this.horaInicio.compareTo(Instant.now()) > 0){
                retraso.añadirAsistente(emp,Instant.now());
            }else{
                asistencia.añadirAsistente(emp);
            }
        }else {
            System.out.println("No tiene la invitacion pertinente a esta reunion.");
        }
    }
}
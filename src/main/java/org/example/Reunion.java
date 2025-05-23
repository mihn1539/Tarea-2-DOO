package org.example;
import java.util.ArrayList;
import java.time.Instant;
import java.time.Duration;

public abstract class Reunion {
    protected Instant horaPrevista;
    protected Duration duracionPrevista;
    protected Asistencia asistencia;
    protected Retraso retraso;
    protected tipoReunion tipo;

    protected Instant horaInicio;
    protected Instant horaFin;

    protected ArrayList<Notas> notas = new ArrayList<>();
    protected Empleado organizador;
    public ArrayList<Invitacion> invitaciones = new ArrayList<>();

    public Reunion(Instant hora, Duration duracion, Empleado emp, tipoReunion tipo) {
        this.horaPrevista = hora;
        this.duracionPrevista = duracion;
        this.organizador = emp;
        this.asistencia = new Asistencia(this);
        this.retraso = new Retraso(this);
        this.tipo = tipo;
    }

    public void unirseReunion(Invitado invitado) {
        if (invitado.invitacion.getReunion().equals(this)) {
            if (Instant.now().isAfter(horaPrevista)) {
                retraso.agregarAsistente(invitado);
            } else {
                asistencia.agregarAsistente(invitado);
            }
        } else {
            System.out.println("No tiene la invitacion pertinente a esta reunion.");
        }
    }

    public float calcularTiempoReal() {
        float duration = Duration.between(horaInicio, horaFin).toSeconds();
        return duration/60;
    }

    public void crearNota(String nota) {
        Notas n = new Notas(nota);
        notas.add(n);
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

    public void iniciar() {
        horaInicio = Instant.now();
    }

    public void finalizar() {
        horaFin = Instant.now();
    }

    public abstract String getUbicacion();

    public Instant getHoraPrevista() {
        return horaPrevista;
    }

    public Instant getHoraInicio() {
        return horaInicio;
    }

    public Instant getHoraFin() {
        return horaFin;
    }

    public tipoReunion getTipo() {
        return tipo;
    }

    public String getOrganizador(){
        return organizador.toString();
    }
}
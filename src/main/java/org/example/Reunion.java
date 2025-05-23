package org.example;
import java.io.*;
import java.util.ArrayList;
import java.time.Instant;
import java.time.Duration;


/**
 * Clase abstracta que representa una reunión, con control de asistencia, retrasos, notas y estadísticas
 * relacionadas a la programación y duración de la misma.
 */
public abstract class Reunion {
    /** Fecha y hora prevista de la reunión*/
    protected Instant horaPrevista;

    /** Duración prevista de la reunión.*/
    protected Duration duracionPrevista;

    /** Registro de asistencia de invitados puntuales.*/
    protected Asistencia asistencia;

    /** Registro de asistencia de invitados atrasados.*/
    protected Retraso retraso;

    /** Tipo de reunión (Técnica, Marketing u otros). */
    protected tipoReunion tipo;

    /** Hora real del inicio de la reunión.*/
    protected Instant horaInicio;

    /** Hora real del fin de la reunión.*/
    protected Instant horaFin;

    /** Lista de notas tomadas durante la reunión.*/
    protected ArrayList<Notas> notas = new ArrayList<>();

    /** Empleado organizador de la reunión.*/
    protected Empleado organizador;

    /** Lista de invitaciones enviadas para la reunión.*/
    public ArrayList<Invitacion> invitaciones = new ArrayList<>();

    /**
     * Crea una instancia de {@code Reunion}.
     *
     * @param hora Fecha y hora prevista de la reunión.
     * @param duracion Duración prevista de la reunión.
     * @param emp Empleado organizador.
     * @param tipo Tipo de reunión.
     */
    public Reunion(Instant hora, Duration duracion, Empleado emp, tipoReunion tipo) {
        this.horaPrevista = hora;
        this.duracionPrevista = duracion;
        this.organizador = emp;
        this.asistencia = new Asistencia(this);
        this.retraso = new Retraso(this);
        this.tipo = tipo;
    }

    /**
     * Marca a un invitado como asistente, verificando si tiene atraso según la hora actual.
     *
     * @param inv Invitado que se une a la reunión.
     */
    public void unirseReunion(Invitado inv) {
        if (inv.invitacion.getReunion().equals(this)) {
            if (Instant.now().isAfter(horaPrevista)) {
                retraso.agregarAsistente(inv);
            } else {
                asistencia.agregarAsistente(inv);
            }
        } else {
            System.out.println("No tiene la invitacion pertinente a esta reunion.");
        }
    }

    /**
     * Calcula la duración real de una reunión en minutos.
     *
     * @return Duración real en minutos.
     */
    public float calcularTiempoReal() {
        float duration = Duration.between(horaInicio, horaFin).toSeconds();
        return duration/60;
    }

    /**
     * Crea una nota y la guarda en la reunión junto.
     *
     * @param nota Contenido de la nota.
     */
    public void crearNota(String nota) {
        Notas n = new Notas(nota);
        notas.add(n);
    }

    /**
     * Entrega la lista combinada de asistentes puntuales y con atraso.
     *
     * @return Lista de asistentes.
     */
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

    /**
     * Entrega la lista de invitados que no asistieron a la reunión.
     *
     * @return Lista de invitados ausentes.
     */
    public ArrayList obtenerAusencias(){
        ArrayList<Invitable> ausencias = new ArrayList<>();
        for(Invitacion i : invitaciones){
            boolean asistio = false;
            for (Object e : asistencia.obtenerAsistencia()){
                if (i.getInvitado().equals(e)){
                    asistio = true;
                    break;
                }
            }
            if (!asistio) {
                for (Object e : retraso.obtenerAsistencia()) {
                    if (i.getInvitado().equals(e)) {
                        asistio = true;
                        break;
                    }
                }
            }
            if (!asistio){
                ausencias.add(i.getInvitado());
            }
        }
        return ausencias;
    }

    /**
     * Entrega la lista de invitados que llegaron tarde.
     *
     * @return Lista de asistentes con atraso.
     */
    public ArrayList obtenerRetrasos(){
        return retraso.obtenerAsistencia();
    }

    /**
     * Entrega la cantidad de invitados que asistieron a la reunión.
     *
     * @return Número de asistentes.
     */
    public int obtenerTotalAsistencia(){
        return obtenerAsistencia().size();
    }

    /**
     * Entrega el porcentaje de asistencia a la reunión respecto al total de invitados.
     *
     * @return Porcentaje de asistencia.
     */
    public float obtenerPorcentajeAsistencia(){
        return (float) (100 * obtenerTotalAsistencia()) / invitaciones.size();
    }

    /**
     * Marca la hora de inicio real de la reunión.
     */
    public void iniciar() {
        horaInicio = Instant.now();
    }

    /**
     * Marca la hora de fin real de la reunión.
     */
    public void finalizar() {
        horaFin = Instant.now();
    }

    /**
     * Metodo abstracto que retorna el enlace o sala de la reunión.
     *
     * @return Cadena de caracteres con la ubicación.
     */
    public abstract String getUbicacion();

    /**
     * Entrega la hora prevista del inicio de la reunión.
     *
     * @return Hora prevista de inicio.
     */
    public Instant getHoraPrevista() {
        return horaPrevista;
    }

    /**
     * Entrega la hora real de inicio de la reunión.
     *
     * @return Hora de inicio real.
     */
    public Instant getHoraInicio() {
        return horaInicio;
    }

    /**
     * Entrega la hora real de término de la reunión.
     *
     * @return Hora de fin real.
     */
    public Instant getHoraFin() {
        return horaFin;
    }

    /**
     * Entrega el tipo de reunión.
     *
     * @return Tipo de reunión.
     */
    public tipoReunion getTipo() {
        return tipo;
    }

    /**
     * Entrega la representación en texto del organizador.
     *
     * @return Información del organizador.
     */
    public String getOrganizador() {
        return organizador.toString();
    }

    /**
     * Devuelve un informe completo de la reunión en una cadena de texto.
     *
     * @return Informe de la reunión.
     */
    @Override
    public String toString() {
        String result = "======= INFORME DE REUNION =======\n";

        result += "\nTipo de reunion: " + getTipo() + ".\n";
        result += "Organizador: " + organizador.getNombreCompleto() + " (correo: " + organizador.getCorreo() + ").\n";
        result += getUbicacion() + ".\n\n";
        result += "Fecha y hora programada: " + getHoraPrevista() + ".\n";
        result += "Hora de inicio: " + getHoraInicio() + ".\n";
        result += "Hora de termino: " + getHoraFin() + ".\n";
        result += "Duracion total: " + calcularTiempoReal() + "minutos.\n\n";

        result += asistencia.toString();
        result += retraso.toString();

        result += "\nNotas:\n";
        if (notas.isEmpty()) {
            result += "- No se agregaron notas a la reunion.\n";
        } else {
            for (Notas n : notas) {
                result += "- " + n.toString() + ".\n";
            }
        }

        return result;
    }

    /**
     * Genera un archivo de texto con el informe de la reunión.
     * El archivo se guarda en la carpeta predeterminada "informes".
     *
     * @param archivo Nombre del archivo de salida.
     */
    public void generarInforme(String archivo) {
        String carpeta = "informes";
        File direccion = new File(carpeta);

        // Crea la carpeta si no existe
        if (!direccion.exists()) {
            boolean creada = direccion.mkdirs();
            if (!creada) {
                System.err.println("No se pudo crear la carpeta de informes.");
                return;
            }
        }

        // Ruta completa al archivo
        File archivoSalida = new File(direccion, archivo);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivoSalida))) {
            writer.write(this.toString());
            System.out.println("Informe generado en: " + archivoSalida.getAbsolutePath());
        } catch (IOException e) {
            System.err.println("Error al escribir el informe: " + e.getMessage());
        }
    }
}
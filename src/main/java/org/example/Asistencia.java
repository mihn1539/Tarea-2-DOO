package org.example;
import java.util.ArrayList;

/**
 * <b>Registro de la asistencia</b> de la {@link Reunion}.
 * */
public class Asistencia  {

    /**
     * <b>Lista</b> que registra cada {@link Invitado} que asiste.
     * */
    public ArrayList<Invitado> asista;
    /**
     * {@link Reunion} a la cual pertenece esta lista.
     * */
    public Reunion reunion;

    /**
     * Metodo constructor.
     * @param reunion Reunion a la cual registrara la asistencia.
     * */
    public Asistencia(Reunion reunion) {
        this.reunion = reunion;
        asista = new ArrayList<>();
    }

    /**
     * Metodo encargado de <b>agregar</b> a cualquier {@link Invitable} en la lista, registrando su asistencia.
     * @param inv Invitado que es añadido a la lista.
     * */
    public void agregarAsistente(Invitado inv) {
        asista.add(inv);
    }

    /**
     * Metodo que entrega la lista de asistencia
     * @return lista con todo {@link Invitado} que asiste.
     * */
    public ArrayList obtenerAsistencia(){
        return asista;
    }

    /**
     * Metodo heredado de la clase {@link Object}, con <i>@Override</i>. Este transforma en formato {@link String} toda la informacion recopilada en esta clase.
     * @return La informacion recopilada de cada empleado asistente.
     * */
    @Override
    public String toString() {
        String result = "Lista de asistencia: \n";
        if (asista.isEmpty()) {
            result += "- No se registró ninguna asistencia.\n";
        } else {
            for (Invitado inv : asista) {
                result += "- " + inv.getNombreCompleto() + " (Correo: " + inv.getCorreo() + ").\n";
            }
        }
        return result;
    }
}
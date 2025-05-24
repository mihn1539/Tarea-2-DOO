package org.example;
import java.time.Instant;
import java.util.ArrayList;

/**
 * Representa el registro de asistentes que llegaron tarde a una reunión.
 * Es heredada de la clase {@link Asistencia}.
 */
public class Retraso extends Asistencia {
    /** Lista de horas en las que cada invitado se unió a la reunión, ordenadas cronológicamente.*/
    protected ArrayList<Instant> horaAtraso = new ArrayList<>();

    /**
     * Crea una instancia de {@code Retraso} para una reunión específica.
     *
     * @param reunion Reunión asociada al registro de atrasos.
     */
    public Retraso(Reunion reunion) {
        super(reunion);
    }

    /**
     * Agrega a un invitado a la lista de asistentes con retraso, junto a la hora a la que se unió a la reunión.
     *
     * @param inv El invitado atrasado.
     * @param hora Hora en la que se unió a la reunión.
     */
    public void agregarAsistente(Invitado inv, Instant hora) {
        super.agregarAsistente(inv);
        horaAtraso.add(hora);
    }

    /**
     * Metodo heredado de la clase {@link Object}, con <i>@Override</i>. Este transforma en formato {@link String} toda la informacion recopilada en esta clase..
     *
     * @return Cadena de caracteres con la lista de retrasos.
     */
    @Override
    public String toString(){
        String result = "Lista de retrasos: \n";
        if (asista.isEmpty()) {
            result += "- Ningun invitado llego tarde.";
        } else {
            for(int i = 0; i < super.asista.size(); i++) {
                Invitado inv = asista.get(i);
                Instant hora = horaAtraso.get(i);
                result += "- " + inv.getNombreCompleto() + " (Correo: " + inv.getCorreo() + "). Hora de llegada: " + hora.toString() + "\n";

            }
        }
        return result;
    }
}
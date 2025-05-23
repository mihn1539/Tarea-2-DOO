package org.example;
import java.util.ArrayList;

public class Asistencia  {
    public ArrayList<Invitado> asista;
    public Reunion reunion;

    public Asistencia(Reunion reunion) {
        this.reunion = reunion;
        asista = new ArrayList<>();
    }

    public void agregarAsistente(Invitado inv) {
        asista.add(inv);
    }

    public ArrayList obtenerAsistencia(){
        return asista;
    }

    @Override
    public String toString() {
        String result = "Lista de asistencia: \n";
        if (asista.isEmpty()) {
            result += "- No se registró ninguna asistencia.\n";
        } else {
            for (Invitado inv : asista) {
                result += "- " + inv.getNombreCompleto() + ". Correo: " + inv.getCorreo() + ".\n";
            }
        }
        return result;
    }
}
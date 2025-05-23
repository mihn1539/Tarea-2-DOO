package org.example;
import java.util.ArrayList;

/**
 * <b>Grupo</b> de {@link Empleado}s perteneciente a un respectivo departamento de la empresa.
 * */
public class Departamento implements Invitable{

    /**
     * Nombre del departamento.
     * */
    private String nombre;
    /**
     * Lista con los empleados del departamento.
     * */
    private ArrayList<Empleado> empleados = new ArrayList<>();

    /**
     * Constructor
     * @param n {@link String} con el nombre del departamento.
     * */
    public Departamento(String n){
        this.nombre = n;
    }

    /**
     * Getter de la cantidad de empleados pertenecientes al departamento.
     * @return Cantidad de empleados del departamento.
     * */
    public int obtenerCantidadEmpleados(){
        return empleados.size();
    }

    /**
     * Setter de empleados en el departamento.
     * @param emp Empleado que se <b>enlista</b> al departamento.
     * */
    public void agregarEmpleado(Empleado emp){
        empleados.add(emp);
        emp.setDepartamento(this);
    }

    /**
     * Getter de la propiedad nombre.
     * @return Nombre del departamento.
     * */
    public String getNombre(){
        return nombre;
    }

    /**
     * Getter de la lista de empleados.
     * @return Lista de empleados del departamento.
     * */
    public ArrayList getEmpleados(){
        return  empleados;
    }

    /**
     * Metodo <b>implementado</b> de la interfaz {@link Invitable}, con <i>override</i>, adaptandose a invitar a todos los empleados pertenecientes al departamento.
     * @param reunion Reunion a la cual se les invita.
     * */
    @Override
    public void invitar(Reunion reunion) {
        for (Empleado emp : empleados){
            Invitacion inv = new Invitacion(emp, reunion);
            emp.invitacion = inv;
            reunion.invitaciones.add(inv);
        }
    }

    /**
     * Metodo heredado de la clase {@link Object}, con <i>override</i>. Este transforma en formato {@link String} toda la informacion recopilada en esta clase.
     * @return Todos los empleados del departamento con sus respectivos datos.
     * */
    @Override
    public String toString() {
        String d = nombre + "\n\n" + "Empleados: \n\n";
        for(Empleado e : empleados){
            d += e.toString() + "\n\n";
        }
        return d;
    }
}
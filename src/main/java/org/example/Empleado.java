package org.example;

/**
 * Representa a un empleado de una empresa, el cual tiene sus datos personales e identificación única de la empresa.
 * Tiene la capacidad de ser invitado a reuniones.
 * Es heredada de la clase {@Link Invitado}.
 */

public class Empleado extends Invitado {

    /** Identificador único del empleado.*/
    private String id;

    /** Departamento al que pertenece el empleado.*/
    private Departamento dept;

    /**
     * Crea una instancia de Empleado.
     *
     * @param id Identificador del empleado.
     * @param ap Apellidos del empleado.
     * @param nomb Nombre del empleado.
     * @param correo Correo del empleado.
     * @param dept Departamento al que pertenece el empleado. Si pertenece a un departamento, se agrega a la lista de empleados de éste.
     */
    public Empleado(String id,String ap,String nomb, String correo, Departamento dept){
        super(nomb, ap, correo);
        this.id = id;
        if(dept!=null) {
            dept.agregarEmpleado(this);
        }
    }

    /**
     * Entrega el identificador del empleado.
     *
     * @return El ID del empleado.
     */
    public String getId(){
        return id;
    }

    /**
     * Invita al empleado a una reunión.
     *
     * @param reunion Reunión a la que se invita al empleado.
     */
    @Override
    public void invitar(Reunion reunion) {
        Invitacion inv = new Invitacion(this, reunion);
        this.invitacion = inv;
        reunion.invitaciones.add(inv);
    }

    /**
     * Entrega el nombre del departamento del empleado.
     *
     * @return Nombre del departamento.
     */
    public String getDepartamento(){
        return dept.getNombre();
    }

    /**
     * Asigna un departamento al empleado.
     *
     * @param dep Nuevo departamento.
     */
    public void setDepartamento(Departamento dep){
        this.dept = dep;
    }

    /**
     * Entrega una representación en texto de los datos del empleado.
     *
     * @return Cadena de caracteres con los datos del empleado.
     */
    @Override
    public String toString(){
        return "Empleado: " + getNombreCompleto() + "\nID: " + getId() + "\nCorreo: " + getCorreo() + "\nDepartamento: " + getDepartamento();
    }
}
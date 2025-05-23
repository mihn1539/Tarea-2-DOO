package org.example;

public class Empleado extends Invitado {
    private String id;
    private Departamento dept;

    public Empleado(String id,String ap,String nomb, String correo, Departamento dept){
        super(nomb, ap, correo);
        this.id = id;
        if(dept!=null) {
            dept.agregarEmpleado(this);
        }
    }

    public String getId(){
        return id;
    }

    @Override
    public void invitar(Reunion reunion) {
        Invitacion inv = new Invitacion(this, reunion);
        this.invitacion = inv;
        reunion.invitaciones.add(inv);
    }

    public String getDepartamento(){
        return dept.getNombre();
    }

    public void setDepartamento(Departamento dep){
        this.dept = dep;
    }

    @Override
    public String toString(){
        return "Empleado: " + getNombreCompleto() + "\nID: " + getId() + "\nCorreo: " + getCorreo() + "\nDepartamento: " + getDepartamento();
    }

}

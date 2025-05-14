public class Empleado implements Invitable {
    private String id;
    private String apellidos;
    private String nombre;
    private String correo;
    private Departamento dept;
    public Invitacion invitacion;

    public Empleado(String id,String ap,String nomb, String correo, Departamento dept){
        this.id = id;
        this.apellidos = ap;
        this.nombre = nomb;
        this.correo = correo;
        this.dept = dept;
        dept.agregarEmpleado(this);
        this.invitacion = null;
    }

    void invitar(Invitacion inv){
        this.invitacion = inv;
        inv.agregarInvitado(this);
    }
}

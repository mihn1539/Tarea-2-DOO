import java.util.ArrayList;

public class Departamento {
    private String nombre;
    private ArrayList<Empleado> empleados = new ArrayList<>();

    public Departamento(String n){
        this.nombre = n;
    }

    public int obtenerCantidadEmpleados(){
        return empleados.size();
    }

    public void agregarEmpleado(Empleado emp){
        empleados.add(emp);
    }

}

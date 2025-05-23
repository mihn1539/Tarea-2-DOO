package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.Instant;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class DepartamentoTest {
    private Departamento dep;
    private Empleado emp1;
    private Empleado emp2;
    private Empleado emp3;
    private Reunion reunion;
    private Duration duration;
    private Instant instant;

    @BeforeEach
    void setUp() {
        duration = Duration.ofHours(1);
        instant = Instant.ofEpochMilli(100);
        dep = new Departamento("Departamento de Ingeniería Civil Informática");
        emp1 = new Empleado("94X12","Fuentealba Meridio","Leonardo","leonfuentealbam@empresa.icinf.com",dep);
        emp2 = new Empleado("13X15","Henriquez Rubio","Jorge","jorghenriquezr@empresa.icinf.com",dep);
        emp3 = new Empleado("16X21","Castillo Gonzalez","Bryan","bryacastillog@empresa.icinf.com",dep);
        reunion = new ReunionPresencial(instant, duration,emp1,"A-9",tipoReunion.TECNICA);
    }
    @Test
    void testAgregarEmpleado(){
        Empleado emp = new Empleado("11X14","Perez Guzman","Esmerigildo","esmeperezg@empresa.icinf.com",null);
        dep.agregarEmpleado(emp);
        assertNotNull(emp.getDepartamento());
    }

    @Test
    void testObtenerCantidadEmpleados(){
        assertEquals(3,dep.obtenerCantidadEmpleados());
    }

    @Test
    void testGetNombre(){
        assertEquals("Departamento de Ingeniería Civil Informática", dep.getNombre());
    }

    @Test
    void testInvitar(){
        dep.invitar(reunion);
        int cantDeEmpleadosConInvitacion = 0;
        for(int i=0;i<dep.obtenerCantidadEmpleados();i++){
            Empleado e = (Empleado) dep.getEmpleados().get(i);
            if(e.invitacion.getReunion().equals(reunion)){
                cantDeEmpleadosConInvitacion ++;
            }
        }
        assertEquals(dep.obtenerCantidadEmpleados(),cantDeEmpleadosConInvitacion);
    }

    @AfterEach
    void tearDown() {
    }
}
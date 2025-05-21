package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.Instant;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class DepartamentoTest {
    Departamento dep;
    Empleado emp1;
    Empleado emp2;
    Empleado emp3;
    Reunion reunion;

    @BeforeEach
    void setUp() {
        Duration duration = Duration.ofHours(1);
        Instant instant = Instant.ofEpochMilli(100);
        dep = new Departamento("Departamento de Ingeniería Civil Informática");
        emp1 = new Empleado("94X12","Fuentealba Meridio","Leonardo","leonfuentealbam@empresa.icinf.com",dep);
        emp2 = new Empleado("13X15","Henriquez Rubio","Jorge","jorghenriquezr@empresa.icinf.com",dep);
        emp3 = new Empleado("16X21","Castillo Gonzalez","Bryan","bryacastillog@empresa.icinf.com",dep);
        reunion = new ReunionPresencial(new Date(),instant,duration,emp1,"A-9");
    }
    @Test
    void testAgregarEmpleado(){
        Empleado emp = new Empleado("11X14","Perez Guzman","Esmerigildo","esmeperezg@empresa.icinf.com",null);
        dep.agregarEmpleado(emp);
        assertEquals("Departamento de Ingeniería Civil Informática",emp.getDepartamento());
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
        assertEquals("Invitación a reunión organizada por:\nEmpleado: Leonardo Fuentealba Meridio\nID: 94X12\nCorreo: leonfuentealbam@empresa.icinf.com\nDepartamento: Departamento de Ingeniería Civil Informática\nPrevista para las: 1970-01-01T00:00:00.100Z\nSala: A-9",emp2.invitacion.toString());
    }

    @AfterEach
    void tearDown() {
    }
}
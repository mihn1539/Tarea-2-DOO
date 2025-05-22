package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.Instant;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class EmpleadoTest {
    Duration duration = Duration.ofHours(1);
    Instant instant = Instant.ofEpochMilli(100);
    Empleado emp;
    Departamento dep = new Departamento("Departamento de Ingeniería Civil Informática");
    Empleado org = new Empleado("94X12","Fuentealba Meridio","Leonardo","leonfuentealbam@empresa.icinf.com",dep);
    Reunion reunion = new ReunionPresencial(new Date(),instant,duration,org,"A-9");

    @BeforeEach
    void setUp() {
        emp = new Empleado("14X14", "Perez Rosales", "Vicente", "viceperezr@empresa.com",dep);
    }

    @Test
    void testInvitar(){
        emp.invitar(reunion);
        assertEquals("Invitación a reunión organizada por:\nEmpleado: Leonardo Fuentealba Meridio\nID: 94X12\nCorreo: leonfuentealbam@empresa.icinf.com\nDepartamento: Departamento de Ingeniería Civil Informática\nPrevista para las: 1970-01-01T00:00:00.100Z\nSala: A-9",emp.invitacion.toString());
    }

    @Test
    void testToString(){
        assertEquals("Empleado: Vicente Perez Rosales\nID: 14X14\nCorreo: viceperezr@empresa.com\nDepartamento: Departamento de Ingeniería Civil Informática",emp.toString());
    }

    @AfterEach
    void tearDown() {
    }
}
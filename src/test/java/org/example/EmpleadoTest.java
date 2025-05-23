package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.Instant;

import static org.junit.jupiter.api.Assertions.*;

class EmpleadoTest {
    private Duration duration;
    private Instant instant;
    private Empleado emp;
    private Departamento dep;
    private Empleado org;
    private Reunion reunion;

    @BeforeEach
    void setUp() {
        duration = Duration.ofHours(1);
        instant = Instant.ofEpochMilli(100);
        dep = new Departamento("Departamento de Ingeniería Civil Informática");
        emp = new Empleado("14X14", "Perez Rosales", "Vicente", "viceperezr@empresa.com",dep);
        org = new Empleado("94X12","Fuentealba Meridio","Leonardo","leonfuentealbam@empresa.icinf.com",dep);
        reunion = new ReunionPresencial(instant,duration,org,"A-9",tipoReunion.TECNICA);
    }

    @Test
    void testInvitar(){
        emp.invitar(reunion);
        assertNotNull(emp.invitacion);
    }

    @Test
    void testToString(){
        assertEquals("Empleado: Vicente Perez Rosales\nID: 14X14\nCorreo: viceperezr@empresa.com\nDepartamento: Departamento de Ingeniería Civil Informática",emp.toString());
    }

    @AfterEach
    void tearDown() {
    }
}
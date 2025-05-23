package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.Instant;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class InvitacionTest {
    Duration duration;
    Instant instant;
    Empleado emp;
    Departamento dep;
    Empleado org;
    Reunion reunion;
    Invitacion invitacion;

    @BeforeEach
    void setUp() {
        duration = Duration.ofHours(1);
        instant = Instant.ofEpochMilli(100);
        dep = new Departamento("Departamento de Ingeniería Civil Informática");
        emp = new Empleado("14X14", "Perez Rosales", "Vicente", "viceperezr@empresa.com",dep);
        org = new Empleado("94X12","Fuentealba Meridio","Leonardo","leonfuentealbam@empresa.icinf.com",dep);
        reunion = new ReunionPresencial(new Date(),instant,duration,org,"A-9");
        invitacion = new Invitacion(emp,reunion);
    }

    @Test
    void testToString(){
        assertEquals("Invitación a reunión organizada por:\nEmpleado: Leonardo Fuentealba Meridio\nID: 94X12\nCorreo: leonfuentealbam@empresa.icinf.com\nDepartamento: Departamento de Ingeniería Civil Informática\nPrevista para las: 1970-01-01T00:00:00.100Z\nSala: A-9",invitacion.toString());
    }

    @AfterEach
    void tearDown() {
    }
}
package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.Instant;

import static org.junit.jupiter.api.Assertions.*;

class InvitacionTest {
    private Duration duration;
    private Instant instant;
    private Empleado emp;
    private Departamento dep;
    private Empleado org;
    private Reunion reunion;
    private Invitacion invitacion;

    @BeforeEach
    void setUp() {
        duration = Duration.ofHours(1);
        instant = Instant.ofEpochMilli(100);
        dep = new Departamento("Departamento de Ingeniería Civil Informática");
        emp = new Empleado("14X14", "Perez Rosales", "Vicente", "viceperezr@empresa.com",dep);
        org = new Empleado("94X12","Fuentealba Meridio","Leonardo","leonfuentealbam@empresa.icinf.com",dep);
        reunion = new ReunionPresencial(instant,duration,org,"A-9",tipoReunion.TECNICA);
        invitacion = new Invitacion(emp,reunion);
    }

    @Test
    void testToString(){
        assertEquals("Invitación a reunión organizada por Leonardo Fuentealba Meridio  prevista para las " + instant.toString() + " en Sala: A-9\n",invitacion.toString());
    }

    @AfterEach
    void tearDown() {
    }
}
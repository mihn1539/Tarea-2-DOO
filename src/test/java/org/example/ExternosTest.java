package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.Instant;

import static org.junit.jupiter.api.Assertions.*;

class ExternosTest {
    private Duration duration;
    private Instant instant;
    private Externos ext;
    private Departamento dep;
    private Empleado org;
    private Reunion reunion;

    @BeforeEach
    void setUp() {
        ext = new Externos("Mujica Toledo", "Alberto", "alb.mujit@gmail.com");
        duration = Duration.ofHours(1);
        instant = Instant.ofEpochMilli(100);
        dep = new Departamento("Departamento de Ingeniería Civil Informática");
        org = new Empleado("94X12","Fuentealba Meridio","Leonardo","leonfuentealbam@empresa.icinf.com",dep);
        reunion = new ReunionPresencial(instant,duration,org,"A-9",tipoReunion.TECNICA);
    }

    @Test
    void testInvitar(){
        ext.invitar(reunion);
        assertNotNull(ext.invitacion);
    }

    @Test
    void testToString(){
        assertEquals("Externo: Alberto Mujica Toledo \nID: EXT\nCorreo: alb.mujit@gmail.com",ext.toString());
    }

    @AfterEach
    void tearDown() {
    }
}
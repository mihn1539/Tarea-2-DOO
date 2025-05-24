package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.Instant;

import static org.junit.jupiter.api.Assertions.*;

class NotasTest {
    private Reunion reu;
    private Departamento dep;
    private Empleado org;
    
    @BeforeEach
    void setUp() {
        dep = new Departamento("Departamento de Ingeniería Civil Informática");
        org = new Empleado("94X12","Fuentealba Meridio","Leonardo","leonfuentealbam@empresa.icinf.com",dep);
        reu = new ReunionPresencial(Instant.ofEpochMilli(100), Duration.ofHours(1),org,"A-9",tipoReunion.TECNICA);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testToString() {
        reu.crearNota("Nueva Nota");
        assertEquals("("+reu.notas.getFirst().getHoraNota()+") "+"Nueva Nota",reu.notas.getFirst().toString());
    }
}
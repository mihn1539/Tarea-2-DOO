package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.Date;
import java.time.Instant;


import static org.junit.jupiter.api.Assertions.*;

class RetrasoTest {
    private Retraso retraso;
    private Reunion reu;
    private Empleado emp;
    private Departamento dep;
    private Empleado org;
    private Invitacion invitacion;

    @BeforeEach
    void setUp() {
        dep = new Departamento("Departamento de Ingeniería Civil Informática");
        emp = new Empleado("14X14", "Perez Rosales", "Vicente", "viceperezr@empresa.com",dep);
        org = new Empleado("94X12","Fuentealba Meridio","Leonardo","leonfuentealbam@empresa.icinf.com",dep);
        reu = new ReunionPresencial(new Date(),Instant.ofEpochMilli(100),Duration.ofHours(1),org,"A-9");
        retraso = new Retraso(reu);
    }

    @Test
    void testAñadirAsistente() {
        retraso.añadirAsistente(emp,Instant.now());
    }

    @Test
    void testToString(){
        retraso.toString();
    }

    @AfterEach
    void tearDown() {
    }
}
package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.Instant;


import static org.junit.jupiter.api.Assertions.*;

class RetrasoTest {
    private Retraso retraso;
    private Reunion reu;
    private Empleado emp;
    private Departamento dep;
    private Empleado org;

    @BeforeEach
    void setUp() {
        dep = new Departamento("Departamento de Ingeniería Civil Informática");
        emp = new Empleado("14X14", "Perez Rosales", "Vicente", "viceperezr@empresa.com",dep);
        org = new Empleado("94X12","Fuentealba Meridio","Leonardo","leonfuentealbam@empresa.icinf.com",dep);
        reu = new ReunionPresencial(Instant.ofEpochMilli(100),Duration.ofHours(1),org,"A-9",tipoReunion.TECNICA);
        retraso = reu.retraso;
    }

    @Test
    void testAñadirAsistente() {
        int i = retraso.asista.size();
        retraso.agregarAsistente(emp,Instant.ofEpochMilli(100));
        assertEquals(emp.toString() + Instant.ofEpochMilli(100),retraso.asista.get(i).toString() + retraso.horaAtraso.get(i).toString());
    }

    @Test
    void testToString(){
        retraso.agregarAsistente(emp,Instant.ofEpochMilli(100));
        String i = Instant.ofEpochMilli(100).toString();
        assertEquals("Lista de retrasos: \n- Vicente Perez Rosales (Correo: viceperezr@empresa.com). Hora de llegada: " + i +"\n",retraso.toString());
    }

    @Test
    void testToStringNoHayRetrasos(){
        Exception exc = assertThrows(NoHayRetrasos.class,
                ()->{
            retraso.toString();
                });
    }

    @AfterEach
    void tearDown() {
    }
}
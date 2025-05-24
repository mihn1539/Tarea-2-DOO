package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.Instant;

import static org.junit.jupiter.api.Assertions.*;
class AsistenciaTest {
    private Asistencia asistencia;
    private Reunion reu;
    private Empleado emp;
    private Departamento dep;
    private Empleado org;

    @BeforeEach
    void setUp() {
        dep = new Departamento("Departamento de Ingeniería Civil Informática");
        emp = new Empleado("14X14", "Perez Rosales", "Vicente", "viceperezr@empresa.com",dep);
        org = new Empleado("94X12","Fuentealba Meridio","Leonardo","leonfuentealbam@empresa.icinf.com",dep);
        reu = new ReunionPresencial(Instant.ofEpochMilli(100), Duration.ofHours(1),emp,"A-9",tipoReunion.TECNICA);
        asistencia = reu.asistencia;
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void añadirAsistente() {
        int i = asistencia.asista.size();
        asistencia.agregarAsistente(org);
        assertEquals(org.toString(),asistencia.asista.get(i).toString());
    }

    @Test
    void testToString(){
        asistencia.agregarAsistente(emp);
        assertEquals("Lista de asistencia: \n- Vicente Perez Rosales (Correo: viceperezr@empresa.com).\n",asistencia.toString());
    }

    @Test
    void testToStringNoHayRetrasos(){
        Exception exc = assertThrows(NoHayAsistencia.class,
                ()->{
                    asistencia.toString();
                });
    }
}
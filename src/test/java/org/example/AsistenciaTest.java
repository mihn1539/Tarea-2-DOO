package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.Instant;
import java.util.Date;

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
        reu = new ReunionPresencial(new Date(), Instant.ofEpochMilli(100), Duration.ofHours(1),emp,"A-9",tipoReunion.TECNICA);
        asistencia = reu.asistencia;
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void añadirAsistente() {
        int i = asistencia.asist.size();
        asistencia.agregarAsistente(org);
        assertEquals(org.toString(),asistencia.asist.get(i).toString());
    }

    @Test
    void testToString(){
        assertEquals("Lista de asistencia: \n\nEmpleado: Vicente Perez Rosales\nID: 14X14\nCorreo: viceperezr@empresa.com\nDepartamento: Departamento de Ingeniería Civil Informática\n\n",asistencia.toString());
    }
}
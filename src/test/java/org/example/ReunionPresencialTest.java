package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.Instant;


import static org.junit.jupiter.api.Assertions.*;

class ReunionPresencialTest {
    private Retraso retraso;
    private Reunion reunion;
    private Empleado emp;
    private Departamento dep;
    private Empleado org;
    private Duration duration;
    private Instant instant;

    @BeforeEach
    void setUp() {
        duration = Duration.ofHours(1);
        instant = Instant.now().plusMillis(100);
        dep = new Departamento("Departamento de Ingeniería Civil Informática");
        emp = new Empleado("14X14", "Perez Rosales", "Vicente", "viceperezr@empresa.com", dep);
        org = new Empleado("94X12", "Fuentealba Meridio", "Leonardo", "leonfuentealbam@empresa.icinf.com", dep);
        reunion = new ReunionPresencial(instant, duration, org, "A-9", tipoReunion.TECNICA);
        emp.invitar(reunion);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void unirseReunion() {
        reunion.unirseReunion(emp);
        assertFalse(reunion.obtenerAsistencia().isEmpty());
    }

    @Test
    void calcularTiempoReal() {
        reunion.iniciar();
        try {
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            System.out.println("Sleep interrumpido");
            Thread.currentThread().interrupt();
        }
        reunion.finalizar();
        assertEquals(0.25, reunion.calcularTiempoReal());
    }

    @Test
    void crearNota() {
        reunion.crearNota("Nueva nota");
        assertFalse(reunion.notas.isEmpty());
    }

    @Test
    void obtenerAsistencia() {
        reunion.unirseReunion(emp);
        assertEquals("Empleado: Vicente Perez Rosales\nID: 14X14\nCorreo: viceperezr@empresa.com\nDepartamento: Departamento de Ingeniería Civil Informática", reunion.obtenerAsistencia().getFirst().toString());
    }

    @Test
    void obtenerAusencias() {
        assertEquals("Empleado: Vicente Perez Rosales\nID: 14X14\nCorreo: viceperezr@empresa.com\nDepartamento: Departamento de Ingeniería Civil Informática", reunion.obtenerAusencias().getFirst().toString());
    }

    @Test
    void obtenerRetrasos() {reunion.iniciar();
        reunion.iniciar();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println("Sleep interrumpido");
            Thread.currentThread().interrupt();
        }
        reunion.unirseReunion(emp);
        assertEquals("Empleado: Vicente Perez Rosales\nID: 14X14\nCorreo: viceperezr@empresa.com\nDepartamento: Departamento de Ingeniería Civil Informática", reunion.obtenerRetrasos().getFirst().toString());
    }

    @Test
    void obtenerTotalAsistencia() {
        reunion.unirseReunion(emp);
        assertEquals(1,reunion.obtenerTotalAsistencia());
    }

    @Test
    void obtenerPorcentajeAsistencia() {
        reunion.unirseReunion(emp);
        assertEquals(100,reunion.obtenerPorcentajeAsistencia());
    }

    @Test
    void iniciar() {
        reunion.iniciar();
        assertNotNull(reunion.getHoraInicio());
    }

    @Test
    void finalizar() {
        reunion.finalizar();
        assertNotNull(reunion.getHoraFin());
    }
}











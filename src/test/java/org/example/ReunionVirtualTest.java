package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.Instant;

import static org.junit.jupiter.api.Assertions.*;
class ReunionVirtualTest {
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
        reunion = new ReunionVirtual(instant, duration, org, "www.teams.com/reunion", tipoReunion.TECNICA);
        emp.invitar(reunion);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void unirseReunion() throws NoTieneInvitacion {
        reunion.unirseReunion(emp);
        assertFalse(reunion.obtenerAsistencia().isEmpty());
    }

    @Test
    void unirseReunionSinInvitacion() {
        Empleado emp1 = new Empleado("16X21","Castillo Gonzalez","Bryan","bryacastillog@empresa.icinf.com",dep);
        Exception exc = assertThrows(NoTieneInvitacion.class,
                ()->{
                    reunion.unirseReunion(emp1);
                });
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
    void obtenerAsistencia() throws NoTieneInvitacion {
        reunion.unirseReunion(emp);
        assertEquals("Empleado: Vicente Perez Rosales \nID: 14X14\nCorreo: viceperezr@empresa.com\nDepartamento: Departamento de Ingeniería Civil Informática", reunion.obtenerAsistencia().getFirst().toString());
    }

    @Test
    void obtenerAusencias() {
        assertEquals("Empleado: Vicente Perez Rosales \nID: 14X14\nCorreo: viceperezr@empresa.com\nDepartamento: Departamento de Ingeniería Civil Informática", reunion.obtenerAusencias().getFirst().toString());
    }

    @Test
    void obtenerRetrasos() throws NoTieneInvitacion {reunion.iniciar();
        reunion.iniciar();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println("Sleep interrumpido");
            Thread.currentThread().interrupt();
        }
        reunion.unirseReunion(emp);
        assertEquals("Empleado: Vicente Perez Rosales \nID: 14X14\nCorreo: viceperezr@empresa.com\nDepartamento: Departamento de Ingeniería Civil Informática", reunion.obtenerRetrasos().getFirst().toString());
    }

    @Test
    void obtenerTotalAsistencia() throws NoTieneInvitacion {
        reunion.unirseReunion(emp);
        assertEquals(1,reunion.obtenerTotalAsistencia());
    }

    @Test
    void obtenerPorcentajeAsistencia() throws NoTieneInvitacion {
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
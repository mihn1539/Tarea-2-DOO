package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.time.Duration;
import java.time.Instant;

import static org.junit.jupiter.api.Assertions.*;

class ReunionCompletaTest {
    private Reunion reunion;
    private Empleado emp1;
    private Departamento dep1;
    private Departamento dep2;
    private Empleado emp2;
    private Empleado emp3;
    private Empleado emp4;
    private Empleado org;
    private Externos ext;
    private Duration duration;
    private Instant instant;

    @BeforeEach
    void setUp() {
        duration = Duration.ofHours(1);
        instant = Instant.now().plusSeconds(30); // hora prevista en el futuro
        dep1 = new Departamento("Departamento de Ingeniería Civil Informática");
        dep2 = new Departamento("Departamento de Mantenimiento de Servidores");
        emp1 = new Empleado("14X14", "Perez Rosales", "Vicente", "viceperezr@empresa.icinf.com", dep1);
        emp2 = new Empleado("13X15","Henriquez Rubio","Jorge","jorghenriquezr@empresa.manser.com",dep2);
        emp3 = new Empleado("16X21","Castillo Gonzalez","Bryan","bryacastillog@empresa.manser.com",dep2);
        emp4 = new Empleado("17X19","Romero Gomez","Javier","javiromerog@empresa.manser.com",dep2);
        ext = new Externos("Mujica Toledo", "Alberto", "alb.mujit@gmail.com");
        org = new Empleado("94X12", "Fuentealba Meridio", "Leonardo", "leonfuentealbam@empresa.icinf.com", dep1);

        reunion = new ReunionPresencial(instant, duration, org, "A-9", tipoReunion.TECNICA);

        emp1.invitar(reunion);
        emp2.invitar(reunion);
        emp3.invitar(reunion);
        emp4.invitar(reunion);
        ext.invitar(reunion);
    }

    @Test
    void testReunionCompleta() {
        reunion.unirseReunion(emp1);
        reunion.unirseReunion(ext);

        reunion.iniciar();
        try {
            Thread.sleep(5000); // 5 segundos de espera
        } catch (InterruptedException e) {
            System.out.println("Sleep interrumpido");
            Thread.currentThread().interrupt();
        }

        reunion.unirseReunion(emp2);
        reunion.unirseReunion(emp3);

        reunion.finalizar();

        assertNotNull(reunion.getHoraInicio(), "Hora de inicio no debe ser null.");
        assertNotNull(reunion.getHoraFin(), "Hora de fin no debe ser null.");

        float duracionReal = reunion.calcularTiempoReal();
        assertTrue(duracionReal > 0, "Duracion real debe ser positiva.");

        assertEquals(4, reunion.obtenerTotalAsistencia(), "Total de asistentes incorrecto.");
        assertEquals(80.0f, reunion.obtenerPorcentajeAsistencia(), "Porcentaje de asistencia incorrecto.");
        assertEquals(1, reunion.obtenerAusencias().size(), "Cantidad de ausentes incorrecto."); // emp4

        assertEquals(2, reunion.obtenerRetrasos().size(), "Debe haber dos invitados con atraso.");
        assertTrue(reunion.notas.isEmpty(), "No deberian haber notas aun.");

        reunion.generarInforme();

        File informes = new File("informes");
        boolean archivoGenerado = false;

        if (informes.exists() && informes.isDirectory()) {
            for (File f : informes.listFiles()) {
                if (f.getName().startsWith("informe_") && f.getName().endsWith(".txt")) {
                    archivoGenerado = true;
                    break;
                }
            }
        }

        assertTrue(archivoGenerado, "El archivo de informe debe haberse generado.");
    }

    @AfterEach
    void tearDown() {
        File informes = new File("informes");
        if (informes.exists()) {
            for (File f : informes.listFiles()) {
                if (f.getName().startsWith("informe_") && f.getName().endsWith(".txt")) {
                    f.delete();
                }
            }
        }
    }
}
package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.Instant;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;

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
        instant = Instant.now().plusMillis(5000);
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
    void testReunionCompleta(){
        reunion.unirseReunion(emp1);
        reunion.unirseReunion(ext);
        if(Instant.now()==reunion.getHoraPrevista())
            reunion.iniciar();
        reunion.unirseReunion(emp2);
        reunion.unirseReunion(emp3);
        try {
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            System.out.println("Sleep interrumpido");
            Thread.currentThread().interrupt();
        }
        reunion.finalizar();
    }
    @AfterEach
    void tearDown() {
    }


}

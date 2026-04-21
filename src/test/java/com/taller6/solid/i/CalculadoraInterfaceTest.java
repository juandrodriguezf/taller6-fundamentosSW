package com.taller6.solid.i;

import org.junit.jupiter.api.Test;
import java.util.Set;
import static org.junit.jupiter.api.Assertions.*;

public class CalculadoraInterfaceTest {

    @Test
    public void testSegregacionDeInterfaces() {
        Calculadora calculadora = new Calculadora();
        
        // Mocking the scenario: a client that only needs to see and execute (The Reader)
        CalculadoraLector lector = calculadora;
        
        // Mocking the scenario: a client that needs to manage/config (The Manager)
        CalculadoraConfigurador configurador = calculadora;

        configurador.registrar("suma", 2, args -> args[0] + args[1]);

        assertTrue(lector.getOperacionesDisponibles().contains("suma"));
        assertEquals(10.0, lector.ejecutar("suma", 7, 3));
        
        // Nota: en el código real (MainI), la UI solo recibirá CalculadoraLector,
        // impidiendo accidentalmente que la UI agregue operaciones.
    }
}

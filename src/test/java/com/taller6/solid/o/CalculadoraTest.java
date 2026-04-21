package com.taller6.solid.o;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculadoraTest {

    @Test
    public void testSuma() {
        Calculadora calculadora = new Calculadora();
        calculadora.registrarOperacion("suma", (args) -> args[0] + args[1]);
        assertEquals(10.0, calculadora.ejecutar("suma", 7.0, 3.0));
    }

    @Test
    public void testExtensionPotencia() {
        // Demostramos OCP: Agregamos una operación sin cambiar el código de la calculadora
        Calculadora calculadora = new Calculadora();
        calculadora.registrarOperacion("potencia", (args) -> Math.pow(args[0], args[1]));
        
        assertEquals(8.0, calculadora.ejecutar("potencia", 2.0, 3.0));
    }
    
    @Test
    public void testExceptionOperacionNoEncontrada() {
        Calculadora calculadora = new Calculadora();
        assertThrows(IllegalArgumentException.class, () -> calculadora.ejecutar("inexistente", 1.0));
    }
}

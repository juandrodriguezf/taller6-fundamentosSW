package com.taller6.solid.l;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class OperacionTest {

    @Test
    public void testSustitucionLiskov() {
        // Cualquier operación debe ser ejecutable si se respetan sus precondiciones (aridad)
        Calculadora calculadora = new Calculadora();
        
        Operacion suma = new Operacion() {
            @Override public int getAridad() { return 2; }
            @Override public double ejecutar(double... args) { return args[0] + args[1]; }
        };
        
        Operacion raiz = new Operacion() {
            @Override public int getAridad() { return 1; }
            @Override public double ejecutar(double... args) { return Math.sqrt(args[0]); }
        };

        calculadora.registrar("suma", suma);
        calculadora.registrar("raiz", raiz);

        // La calculadora puede tratar a ambas por igual gracias al contrato de aridad (Liskov)
        assertEquals(10.0, calculadora.ejecutar("suma", 7, 3));
        assertEquals(3.0, calculadora.ejecutar("raiz", 9));
    }

    @Test
    public void testViolacionPrecondiciones() {
        Calculadora calculadora = new Calculadora();
        Operacion suma = new Operacion() {
            @Override public int getAridad() { return 2; }
            @Override public double ejecutar(double... args) { return args[0] + args[1]; }
        };
        calculadora.registrar("suma", suma);

        // La calculadora debe proteger el contrato de Liskov validando la aridad antes de ejecutar
        assertThrows(IllegalArgumentException.class, () -> calculadora.ejecutar("suma", 1.0));
    }
}

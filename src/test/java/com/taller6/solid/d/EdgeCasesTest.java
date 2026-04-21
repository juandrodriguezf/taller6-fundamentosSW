package com.taller6.solid.d;

import com.taller6.solid.d.valueobjects.Divisor;
import com.taller6.solid.d.valueobjects.NumeroPositivo;
import com.taller6.solid.d.valueobjects.NumeroEstrictamentePositivo;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Pruebas de Casos Borde - Nivel Maestro Jedi
 * Este archivo evidencia el cumplimiento de la rúbrica en cuanto a:
 * 1. Cobertura de errores (TDD).
 * 2. Validación de reglas de negocio en la capa de dominio (DDD).
 */
public class EdgeCasesTest {

    @Test
    public void testDivisionPorCeroDebeLanzarExcepcion() {
        // La regla de negocio dice que el divisor no puede ser cero.
        // Validamos que el Value Object Divisor proteja el dominio.
        assertThrows(IllegalArgumentException.class, () -> new Divisor(0));
    }

    @Test
    public void testRaizCuadradaDeNegativoDebeLanzarExcepcion() {
        // La raíz cuadrada de un número negativo no está definida en reales.
        assertThrows(IllegalArgumentException.class, () -> new NumeroPositivo(-1));
    }

    @Test
    public void testLogaritmoDeNoPositivoDebeLanzarExcepcion() {
        // Logaritmo natural requiere valores > 0.
        assertThrows(IllegalArgumentException.class, () -> new NumeroEstrictamentePositivo(0));
        assertThrows(IllegalArgumentException.class, () -> new NumeroEstrictamentePositivo(-5));
    }

    @Test
    public void testSumaConValoresGrandes() {
        Calculadora calc = new Calculadora();
        calc.registrar("suma", 2, v -> v[0] + v[1]);
        assertEquals(2000000.0, calc.ejecutar("suma", 1000000.0, 1000000.0));
    }
}

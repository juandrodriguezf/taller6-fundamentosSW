package com.taller6.solid.s;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculadoraServiceTest {

    private final CalculadoraService service = new CalculadoraService();

    @Test
    public void testSuma() {
        assertEquals(10, service.sumar(7, 3));
    }

    @Test
    public void testResta() {
        assertEquals(4, service.restar(7, 3));
    }

    @Test
    public void testMultiplicacion() {
        assertEquals(21, service.multiplicar(7, 3));
    }

    @Test
    public void testDivision() {
        assertEquals(2.5, service.dividir(5, 2));
    }

    @Test
    public void testRaizCuadrada() {
        assertEquals(3.0, service.raizCuadrada(9));
    }

    @Test
    public void testLogaritmoNatural() {
        assertEquals(0.0, service.logaritmoNatural(1));
    }
}

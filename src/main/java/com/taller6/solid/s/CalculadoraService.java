package com.taller6.solid.s;

import com.taller6.solid.s.valueobjects.Divisor;
import com.taller6.solid.s.valueobjects.NumeroEstrictamentePositivo;
import com.taller6.solid.s.valueobjects.NumeroPositivo;

public class CalculadoraService {

    public int sumar(int a, int b) {
        return a + b;
    }

    public int restar(int a, int b) {
        return a - b;
    }

    public int multiplicar(int a, int b) {
        return a * b;
    }

    public double dividir(int dividendo, int divisorValue) {
        Divisor divisor = new Divisor(divisorValue);
        return (double) dividendo / divisor.getValue();
    }

    public double raizCuadrada(int valor) {
        NumeroPositivo numero = new NumeroPositivo(valor);
        return Math.sqrt(numero.getValue());
    }

    public double logaritmoNatural(int valor) {
        NumeroEstrictamentePositivo numero = new NumeroEstrictamentePositivo(valor);
        return Math.log(numero.getValue());
    }
}

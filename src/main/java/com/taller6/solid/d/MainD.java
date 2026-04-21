package com.taller6.solid.d;

import com.taller6.solid.d.valueobjects.Divisor;

public class MainD {
    public static void main(String[] args) {
        // Wiring / Inversión de Control: El Main actúa como el contenedor dependencias
        Calculadora calculadora = new Calculadora();
        calculadora.registrar("suma", 2, v -> v[0] + v[1]);
        calculadora.registrar("division", 2, v -> v[0] / new Divisor(v[1]).getValue());

        EntradaSalida io = new ConsolaIO();
        
        CalculadoraUI ui = new CalculadoraUI(calculadora, io);
        ui.iniciar();
    }
}

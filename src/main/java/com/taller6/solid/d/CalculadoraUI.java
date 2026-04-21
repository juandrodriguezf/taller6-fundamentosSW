package com.taller6.solid.d;

import java.util.Set;

public class CalculadoraUI {
    private final CalculadoraLector calculadora;
    private final EntradaSalida io;

    // Inyección de Dependencias: No creamos el IO ni la calculadora, los recibimos.
    public CalculadoraUI(CalculadoraLector calculadora, EntradaSalida io) {
        this.calculadora = calculadora;
        this.io = io;
    }

    public void iniciar() {
        io.escribir("=== Calculadora DIP (D) ===");
        
        while (true) {
            io.escribir("\nDisponibles: " + calculadora.getOperacionesDisponibles());
            io.escribir("Operación (o 'salir'): ");
            String opName = io.leerString();
            if (opName.equalsIgnoreCase("salir")) break;

            try {
                int aridad = calculadora.getAridadDe(opName);
                double[] args = new double[aridad];
                for (int i = 0; i < aridad; i++) {
                    io.escribir("Arg " + (i + 1) + ": ");
                    args[i] = io.leerDouble();
                }
                io.escribir("Resultado: " + calculadora.ejecutar(opName, args));
            } catch (Exception e) {
                io.escribir("Error: " + e.getMessage());
            }
        }
    }
}

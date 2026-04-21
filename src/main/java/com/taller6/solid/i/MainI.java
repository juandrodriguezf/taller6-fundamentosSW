package com.taller6.solid.i;

import java.util.Scanner;

public class MainI {
    public static void main(String[] args) {
        Calculadora calculadora = new Calculadora();
        
        // El configurador solo se usa aquí para el setup
        setup(calculadora);

        // La UI solo conoce el 'Lector', respetando el principio de segregación de interfaces
        ejecutarUI(calculadora);
    }

    private static void setup(CalculadoraConfigurador config) {
        config.registrar("suma", 2, v -> v[0] + v[1]);
        config.registrar("resta", 2, v -> v[0] - v[1]);
        // etc...
    }

    private static void ejecutarUI(CalculadoraLector lector) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== Calculadora ISP (I) ===");
        
        while (true) {
            System.out.println("\nDisponibles: " + lector.getOperacionesDisponibles());
            System.out.print("Operación: ");
            String opName = scanner.next();
            if (opName.equalsIgnoreCase("salir")) break;

            try {
                int aridad = lector.getAridadDe(opName);
                double[] input = new double[aridad];
                for (int i = 0; i < aridad; i++) {
                    System.out.print("Arg " + (i+1) + ": ");
                    input[i] = scanner.nextDouble();
                }
                // Aquí usamos la interfaz segregada
                System.out.println("Resultado: " + lector.ejecutar(opName, input));
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}

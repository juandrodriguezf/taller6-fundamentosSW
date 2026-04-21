package com.taller6.solid.l;

import com.taller6.solid.l.valueobjects.Divisor;
import com.taller6.solid.l.valueobjects.NumeroEstrictamentePositivo;
import com.taller6.solid.l.valueobjects.NumeroPositivo;

import java.util.Scanner;

public class MainL {
    public static void main(String[] args) {
        Calculadora calc = new Calculadora();

        // Registro de operaciones (Liskov compliant)
        calc.registrar("suma", new Operacion() {
            @Override public int getAridad() { return 2; }
            @Override public double ejecutar(double... v) { return v[0] + v[1]; }
        });

        calc.registrar("division", new Operacion() {
            @Override public int getAridad() { return 2; }
            @Override public double ejecutar(double... v) {
                Divisor d = new Divisor(v[1]);
                return v[0] / d.getValue();
            }
        });

        calc.registrar("raiz", new Operacion() {
            @Override public int getAridad() { return 1; }
            @Override public double ejecutar(double... v) {
                NumeroPositivo n = new NumeroPositivo(v[0]);
                return Math.sqrt(n.getValue());
            }
        });

        ejecutarUI(calc);
    }

    private static void ejecutarUI(Calculadora calc) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== Calculadora LSP (L) ===");
        
        while (true) {
            System.out.println("\nDisponibles: " + calc.getOperaciones());
            System.out.print("Operación: ");
            String opName = scanner.next();
            if (opName.equalsIgnoreCase("salir")) break;

            try {
                int aridad = calc.getAridadDe(opName);
                if (aridad == 0 && !calc.getOperaciones().contains(opName.toLowerCase())) {
                    System.out.println("Operación inexistente.");
                    continue;
                }

                double[] inputs = new double[aridad];
                for (int i = 0; i < aridad; i++) {
                    System.out.print("Arg " + (i+1) + ": ");
                    inputs[i] = scanner.nextDouble();
                }

                // La UI confía en que cualquier operación registrada es "ejecutable" 
                // con el número de argumentos que ella misma reporta.
                System.out.println("Resultado: " + calc.ejecutar(opName, inputs));
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}

package com.taller6.solid.o;

import com.taller6.solid.o.valueobjects.Divisor;
import com.taller6.solid.o.valueobjects.NumeroEstrictamentePositivo;
import com.taller6.solid.o.valueobjects.NumeroPositivo;

import java.util.Scanner;

public class MainO {
    public static void main(String[] args) {
        Calculadora calculadora = new Calculadora();

        // Registro de operaciones (Open to Extension)
        calculadora.registrarOperacion("suma", vals -> vals[0] + vals[1]);
        calculadora.registrarOperacion("resta", vals -> vals[0] - vals[1]);
        calculadora.registrarOperacion("multiplicacion", vals -> vals[0] * vals[1]);
        calculadora.registrarOperacion("division", vals -> {
            Divisor divisor = new Divisor(vals[1]);
            return vals[0] / divisor.getValue();
        });
        calculadora.registrarOperacion("raiz", vals -> {
            NumeroPositivo num = new NumeroPositivo(vals[0]);
            return Math.sqrt(num.getValue());
        });
        calculadora.registrarOperacion("log", vals -> {
            NumeroEstrictamentePositivo num = new NumeroEstrictamentePositivo(vals[0]);
            return Math.log(num.getValue());
        });

        // Demo de extensión fácil: Potencia
        calculadora.registrarOperacion("potencia", vals -> Math.pow(vals[0], vals[1]));

        ejecutarUI(calculadora);
    }

    private static void ejecutarUI(Calculadora calc) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== Calculadora OCP (O) ===");
        
        while (true) {
            System.out.println("\nOperaciones disponibles: " + calc.getOperacionesRegistradas());
            System.out.println("Escriba el nombre de la operación (o 'salir'):");
            String op = scanner.next();
            if (op.equalsIgnoreCase("salir")) break;

            try {
                // Para simplificar esta demo, asumimos que sabemos cuántos args necesita cada una
                // En un sistema real, la interfaz Operacion podría definir el número de operandos necesarios.
                if (op.equals("raiz") || op.equals("log")) {
                    System.out.print("Valor: "); double v = scanner.nextDouble();
                    System.out.println("Resultado: " + calc.ejecutar(op, v));
                } else {
                    System.out.print("a: "); double a = scanner.nextDouble();
                    System.out.print("b: "); double b = scanner.nextDouble();
                    System.out.println("Resultado: " + calc.ejecutar(op, a, b));
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}

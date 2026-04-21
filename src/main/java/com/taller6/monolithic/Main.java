package com.taller6.monolithic;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        System.out.println("=== Calculadora SoLiD (Consola) ===");

        while (running) {
            System.out.println("\nSeleccione una operación:");
            System.out.println("1. Suma (+)");
            System.out.println("2. Resta (-)");
            System.out.println("3. Multiplicación (*)");
            System.out.println("4. División (/)");
            System.out.println("5. Raíz Cuadrada (unaria)");
            System.out.println("6. Logaritmo Natural (unaria)");
            System.out.println("0. Salir");
            System.out.print("> ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Ingrese primer número: ");
                    int a1 = scanner.nextInt();
                    System.out.print("Ingrese segundo número: ");
                    int b1 = scanner.nextInt();
                    System.out.println("Resultado: " + (a1 + b1));
                    break;
                case 2:
                    System.out.print("Ingrese primer número: ");
                    int a2 = scanner.nextInt();
                    System.out.print("Ingrese segundo número: ");
                    int b2 = scanner.nextInt();
                    System.out.println("Resultado: " + (a2 - b2));
                    break;
                case 3:
                    System.out.print("Ingrese primer número: ");
                    int a3 = scanner.nextInt();
                    System.out.print("Ingrese segundo número: ");
                    int b3 = scanner.nextInt();
                    System.out.println("Resultado: " + (a3 * b3));
                    break;
                case 4:
                    System.out.print("Ingrese dividendo: ");
                    int a4 = scanner.nextInt();
                    System.out.print("Ingrese divisor: ");
                    int b4 = scanner.nextInt();
                    if (b4 != 0) {
                        System.out.println("Resultado: " + ((double) a4 / b4));
                    } else {
                        System.out.println("Error: División por cero.");
                    }
                    break;
                case 5:
                    System.out.print("Ingrese número: ");
                    int u5 = scanner.nextInt();
                    if (u5 >= 0) {
                        System.out.println("Resultado: " + Math.sqrt(u5));
                    } else {
                        System.out.println("Error: Raíz de número negativo.");
                    }
                    break;
                case 6:
                    System.out.print("Ingrese número: ");
                    int u6 = scanner.nextInt();
                    if (u6 > 0) {
                        System.out.println("Resultado: " + Math.log(u6));
                    } else {
                        System.out.println("Error: Logaritmo de número no positivo.");
                    }
                    break;
                case 0:
                    running = false;
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }
        scanner.close();
    }
}

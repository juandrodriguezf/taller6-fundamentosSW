package com.taller6.solid.s;

import java.util.Scanner;

public class CalculadoraUI {
    private final CalculadoraService service;
    private final Scanner scanner;

    public CalculadoraUI(CalculadoraService service) {
        this.service = service;
        this.scanner = new Scanner(System.in);
    }

    public void iniciar() {
        boolean running = true;
        System.out.println("=== Calculadora SRP (S) ===");

        while (running) {
            System.out.println("\nSeleccione operación: 1.Suma, 2.Resta, 3.Mult, 4.Div, 5.Raiz, 6.Log, 0.Salir");
            System.out.print("> ");
            int option = scanner.nextInt();

            try {
                switch (option) {
                    case 1 -> ejecutarSuma();
                    case 2 -> ejecutarResta();
                    case 3 -> ejecutarMultiplicacion();
                    case 4 -> ejecutarDivision();
                    case 5 -> ejecutarRaiz();
                    case 6 -> ejecutarLog();
                    case 0 -> {
                        running = false;
                        System.out.println("Adiós.");
                    }
                    default -> System.out.println("Opción inválida.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    private void ejecutarSuma() {
        System.out.print("a: "); int a = scanner.nextInt();
        System.out.print("b: "); int b = scanner.nextInt();
        System.out.println("Resultado: " + service.sumar(a, b));
    }

    private void ejecutarResta() {
        System.out.print("a: "); int a = scanner.nextInt();
        System.out.print("b: "); int b = scanner.nextInt();
        System.out.println("Resultado: " + service.restar(a, b));
    }

    private void ejecutarMultiplicacion() {
        System.out.print("a: "); int a = scanner.nextInt();
        System.out.print("b: "); int b = scanner.nextInt();
        System.out.println("Resultado: " + service.multiplicar(a, b));
    }

    private void ejecutarDivision() {
        System.out.print("Dividend: "); int a = scanner.nextInt();
        System.out.print("Divisor: "); int b = scanner.nextInt();
        System.out.println("Resultado: " + service.dividir(a, b));
    }

    private void ejecutarRaiz() {
        System.out.print("Num: "); int a = scanner.nextInt();
        System.out.println("Resultado: " + service.raizCuadrada(a));
    }

    private void ejecutarLog() {
        System.out.print("Num: "); int a = scanner.nextInt();
        System.out.println("Resultado: " + service.logaritmoNatural(a));
    }
}

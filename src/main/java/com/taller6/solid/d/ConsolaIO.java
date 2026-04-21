package com.taller6.solid.d;

import java.util.Scanner;

public class ConsolaIO implements EntradaSalida {
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public String leerString() { return scanner.next(); }

    @Override
    public double leerDouble() { return scanner.nextDouble(); }

    @Override
    public void escribir(String mensaje) { System.out.println(mensaje); }
}

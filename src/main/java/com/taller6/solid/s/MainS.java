package com.taller6.solid.s;

public class MainS {
    public static void main(String[] args) {
        CalculadoraService service = new CalculadoraService();
        CalculadoraUI ui = new CalculadoraUI(service);
        ui.iniciar();
    }
}

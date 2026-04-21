package com.taller6.solid.d;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Calculadora implements CalculadoraLector {
    private final Map<String, Operacion> operaciones = new HashMap<>();

    public void registrar(String nombre, int aridad, Calculo calculo) {
        operaciones.put(nombre.toLowerCase(), new Operacion() {
            @Override public int getAridad() { return aridad; }
            @Override public double ejecutar(double... v) { return calculo.calcular(v); }
        });
    }

    @Override
    public double ejecutar(String nombre, double... args) {
        Operacion op = operaciones.get(nombre.toLowerCase());
        if (op == null) throw new IllegalArgumentException("No existe");
        return op.ejecutar(args);
    }

    @Override
    public Set<String> getOperacionesDisponibles() { return operaciones.keySet(); }

    @Override
    public int getAridadDe(String nombre) {
        Operacion op = operaciones.get(nombre.toLowerCase());
        return (op != null) ? op.getAridad() : 0;
    }

    // Interfaz interna para manejar el contrato de aridad
    private interface Operacion {
        int getAridad();
        double ejecutar(double... args);
    }
}

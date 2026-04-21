package com.taller6.solid.i;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Calculadora implements CalculadoraLector, CalculadoraConfigurador {
    private final Map<String, Operacion> operaciones = new HashMap<>();

    @Override
    public void registrar(String nombre, int aridad, Calculo calculo) {
        operaciones.put(nombre.toLowerCase(), new Operacion() {
            @Override public int getAridad() { return aridad; }
            @Override public double ejecutar(double... v) { return calculo.calcular(v); }
        });
    }

    @Override
    public double ejecutar(String nombre, double... args) {
        Operacion op = operaciones.get(nombre.toLowerCase());
        if (op == null) throw new IllegalArgumentException("No existe: " + nombre);
        if (args.length != op.getAridad()) {
            throw new IllegalArgumentException("Aridad incorrecta.");
        }
        return op.ejecutar(args);
    }

    @Override
    public Set<String> getOperacionesDisponibles() {
        return operaciones.keySet();
    }

    @Override
    public int getAridadDe(String nombre) {
        Operacion op = operaciones.get(nombre.toLowerCase());
        return (op != null) ? op.getAridad() : 0;
    }
}

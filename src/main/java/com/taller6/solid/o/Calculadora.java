package com.taller6.solid.o;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Calculadora {
    private final Map<String, Operacion> operaciones = new HashMap<>();

    public void registrarOperacion(String nombre, Operacion operacion) {
        operaciones.put(nombre.toLowerCase(), operacion);
    }

    public double ejecutar(String nombre, double... args) {
        Operacion op = operaciones.get(nombre.toLowerCase());
        if (op == null) {
            throw new IllegalArgumentException("Operación no suportada: " + nombre);
        }
        return op.ejecutar(args);
    }

    public Set<String> getOperacionesRegistradas() {
        return operaciones.keySet();
    }
}

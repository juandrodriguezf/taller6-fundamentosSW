package com.taller6.solid.l;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Calculadora {
    private final Map<String, Operacion> operaciones = new HashMap<>();

    public void registrar(String nombre, Operacion op) {
        operaciones.put(nombre.toLowerCase(), op);
    }

    public double ejecutar(String nombre, double... args) {
        Operacion op = operaciones.get(nombre.toLowerCase());
        if (op == null) throw new IllegalArgumentException("No existe: " + nombre);
        
        // Protección de Liskov: Aseguramos que se cumpla el contrato de la interfaz antes de llamar
        if (args.length != op.getAridad()) {
            throw new IllegalArgumentException(
                String.format("La operación '%s' requiere %d argumentos, pero se pasaron %d", 
                nombre, op.getAridad(), args.length));
        }
        
        return op.ejecutar(args);
    }

    public Set<String> getOperaciones() { return operaciones.keySet(); }
    
    public int getAridadDe(String nombre) {
        Operacion op = operaciones.get(nombre.toLowerCase());
        return (op != null) ? op.getAridad() : 0;
    }
}

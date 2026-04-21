package com.taller6.solid.d;

import java.util.Set;

public interface CalculadoraLector {
    double ejecutar(String nombre, double... args);
    Set<String> getOperacionesDisponibles();
    int getAridadDe(String nombre);
}

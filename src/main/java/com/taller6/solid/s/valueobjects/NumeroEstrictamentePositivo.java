package com.taller6.solid.s.valueobjects;

public class NumeroEstrictamentePositivo {
    private final int value;

    public NumeroEstrictamentePositivo(int value) {
        if (value <= 0) {
            throw new IllegalArgumentException("El número debe ser estrictamente mayor a cero.");
        }
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}

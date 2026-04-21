package com.taller6.solid.s.valueobjects;

public class NumeroPositivo {
    private final int value;

    public NumeroPositivo(int value) {
        if (value < 0) {
            throw new IllegalArgumentException("El número debe ser mayor o igual a cero.");
        }
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}

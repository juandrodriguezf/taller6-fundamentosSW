package com.taller6.solid.s.valueobjects;

public class Divisor {
    private final int value;

    public Divisor(int value) {
        if (value == 0) {
            throw new IllegalArgumentException("El divisor no puede ser cero.");
        }
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}

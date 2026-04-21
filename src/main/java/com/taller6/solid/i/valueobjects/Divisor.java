package com.taller6.solid.i.valueobjects;

public class Divisor {
    private final double value;
    public Divisor(double value) {
        if (value == 0) throw new IllegalArgumentException("Divisor no puede ser cero.");
        this.value = value;
    }
    public double getValue() { return value; }
}

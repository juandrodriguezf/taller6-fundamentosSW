package com.taller6.solid.l.valueobjects;

public class NumeroPositivo {
    private final double value;
    public NumeroPositivo(double value) {
        if (value < 0) throw new IllegalArgumentException("El número debe ser >= 0.");
        this.value = value;
    }
    public double getValue() { return value; }
}

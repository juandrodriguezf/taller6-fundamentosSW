package com.taller6.solid.i.valueobjects;

public class NumeroEstrictamentePositivo {
    private final double value;
    public NumeroEstrictamentePositivo(double value) {
        if (value <= 0) throw new IllegalArgumentException("El número debe ser > 0.");
        this.value = value;
    }
    public double getValue() { return value; }
}

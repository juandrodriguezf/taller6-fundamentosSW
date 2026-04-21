package com.taller6.solid.d;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import static org.junit.jupiter.api.Assertions.*;

public class CalculadoraDTest {

    @Test
    public void testDependencyInversionWithMockIO() {
        // Mock de I/O para no depender de la consola real (PRINCIPIO D)
        MockIO mockIO = new MockIO();
        mockIO.addInput("suma");
        mockIO.addInput("7");
        mockIO.addInput("3");
        mockIO.addInput("salir");

        // Mock de CalculadoraLector
        CalculadoraLector mockCalc = new CalculadoraLector() {
            @Override public double ejecutar(String n, double... a) { return 10.0; }
            @Override public Set<String> getOperacionesDisponibles() { return Set.of("suma"); }
            @Override public int getAridadDe(String n) { return 2; }
        };

        CalculadoraUI ui = new CalculadoraUI(mockCalc, mockIO);
        ui.iniciar();

        // Verificamos que la UI escribió el resultado esperado en el canal de salida abstracto
        assertTrue(mockIO.getOutputs().stream().anyMatch(s -> s.contains("10.0")));
    }

    private static class MockIO implements EntradaSalida {
        private final List<String> inputs = new ArrayList<>();
        private final List<String> outputs = new ArrayList<>();
        private int inputIndex = 0;

        public void addInput(String in) { inputs.add(in); }
        public List<String> getOutputs() { return outputs; }

        @Override public String leerString() { return inputs.get(inputIndex++); }
        @Override public double leerDouble() { return Double.parseDouble(inputs.get(inputIndex++)); }
        @Override public void escribir(String mensaje) { outputs.add(mensaje); }
    }
}

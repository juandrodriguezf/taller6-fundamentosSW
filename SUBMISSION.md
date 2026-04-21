# Bitácora de Refactorización: Calculadora S.O.L.I.D.

Este documento detalla la evolución del proyecto "Calculadora SoLiD" desde un monolito "espagueti" hasta una arquitectura desacoplada, siguiendo las instrucciones paso a paso dadas a la IA Antigravity. Antes de ingresar los prompts, se le dio contexto detallado al agente de lo que se quiere hacer en el taller teniendo en cuenta .

---

## 🟢 Etapa 0: El Monolito Inicial

**Prompt del Usuario:**

> "Calculadora SoLiD. Quiero crear un programa en java que tenga operaciones aritmeticas entre numeros enteros, de tipo binarias (suma, resta, etc) y unarias (raiz cuadrada, logaritmo natural). Es una aplicación de consola. Tip: quiero todo en la misma clase"

**Resultado:** Se generó `com.taller6.monolithic.Main`. Un código con un `switch` gigante, lógica de negocio mezclada con `System.out` y validaciones directas.

- **Responsabilidad:** Todo el programa dependía de una sola clase.
- **Acoplamiento:** Alto (Lógica + UI + Entrada de datos).

---

## 🔴 Etapa 1: Single Responsibility Principle (S)

**Prompt del Usuario:**

> "A medida que el profesor explique cada letra... empieza por la letra S."

**Refactorización:**

- **Acción:** Se separó la lógica en `CalculadoraService` y la interacción en `CalculadoraUI`.
- **DDD Involucrado:** Se introdujeron los primeros **Value Objects** (`Divisor`, `NumeroPositivo`) para que la validación ocurra en el dominio y no en el servicio.
- **TDD:** Se crearon las pruebas unitarias `CalculadoraServiceTest` antes de implementar el servicio.

---

## 🟠 Etapa 2: Open/Closed Principle (O)

**Prompt del Usuario:**

> "Ahora haz la O"

**Refactorización:**

- **Acción:** Se eliminó el `switch` del servicio. Se creó la interfaz `Operacion` y la calculadora pasó a usar un `Map<String, Operacion>`.
- **Extensibilidad:** Se demostró agregando la operación "Potencia" sin tocar el código de la calculadora.
- **Error Corregido por la IA:** Durante la implementación, hubo un conflicto de nombres entre los argumentos del `main(String[] args)` y el parámetro `args` de las lambdas. La IA detectó el fallo de compilación y renombró los parámetros a `vals`.

---

## 🟡 Etapa 3: Liskov Substitution Principle (L)

**Prompt del Usuario:**

> "sigue con la L"

**Refactorización:**

- **Acción:** Se detectó que la interfaz genérica podía fallar si se pasaban menos argumentos de los necesarios. Se agregó `int getAridad()` a la interfaz `Operacion`.
- **Contrato:** El motor de la calculadora ahora valida la aridad antes de ejecutar, garantizando que cualquier implementación de `Operacion` sea **sustituible** sin romper el flujo del programa.

---

## 🔵 Etapa 4: Interface Segregation Principle (I)

**Prompt del Usuario:**

> "Haz la I"

**Refactorización:**

- **Acción:** Se dividió la calculadora en `CalculadoraLector` (para la UI) y `CalculadoraConfigurador` (para el setup/registro).
- **Error Corregido por la IA:** La interfaz `Operacion` dejó de ser funcional al tener dos métodos (`getAridad` y `ejecutar`). Para mantener el uso de lambdas, se extrajo la interfaz `Calculo.java`, segregando la **capacidad de cálculo** de la **metadata de la operación**.

---

## 🟣 Etapa 5: Dependency Inversion Principle (D)

**Prompt del Usuario:**

> "Haz la D"

**Refactorización:**

- **Acción:** La clase `CalculadoraUI` dependía de la consola física (`Scanner`). Se creó la abstracción `EntradaSalida`.
- **Inversión de Control:** Ahora la UI recibe el canal de comunicación por constructor.
- **Evidencia TDD:** Se creó `CalculadoraDTest` usando un **MockIO**, demostrando que la UI puede ser testeada sin necesidad de escribir en teclado, ya que depende de una interfaz y no de un detalle de implementación.

---

## 🛠️ Tecnologías y Metodologías

- **Java 17 & Maven**: Gestión de dependencias y ciclo de vida.
- **JUnit 5**: Suite de 13 tests unitarios cubriendo todos los principios.
- **Git**: Control de versiones con commits semánticos (`feat:`, `refactor:`).

**Repositorio Final:** [https://github.com/juandrodriguezf/taller6-fundamentosSW.git](https://github.com/juandrodriguezf/taller6-fundamentosSW.git)

# Reflexión Inicial (Análisis del Monolito)

### 1. ¿Qué responsabilidades tiene exactamente esta clase?

En su estado inicial, la clase `Main` actúa como un **Objeto Dios (God Object)**. Acumula responsabilidades de:

- **Orquestación**: Controla el flujo del programa.
- **Entrada/Salida**: Manejo directo de `Scanner` y `System.out`.
- **Lógica de Negocio**: Realiza los cálculos aritméticos.
- **Validación de Dominio**: Gestiona errores como la división por cero y raíces negativas.
  Esto viola directamente el **SRP**, haciendo que cualquier cambio en una de estas áreas obligue a modificar la única clase existente.

# Reflexión Inicial (Análisis del Monolito)

### 1. ¿Qué responsabilidades tiene exactamente esta clase?

En su estado inicial, la clase `Main` actúa como un **Objeto Dios (God Object)**. Acumula responsabilidades de:

- **Orquestación**: Controla el flujo del programa.
- **Entrada/Salida**: Manejo directo de `Scanner` y `System.out`.
- **Lógica de Negocio**: Realiza los cálculos aritméticos.
- **Validación de Dominio**: Gestiona errores como la división por cero y raíces negativas.
  Esto viola directamente el **SRP**, haciendo que cualquier cambio en una de estas áreas obligue a modificar la única clase existente.

### 2. Si cambio la forma de imprimir en consola, ¿qué pasa con las operaciones?

En el monolito, la lógica está **fuertemente acoplada** a las instrucciones de impresión. Si quisiéramos migrar a una interfaz gráfica (GUI) o una API REST, tendríamos que reescribir toda la lógica, ya que los resultados no se retornan de forma pura, sino que se imprimen directamente. No hay reutilización de código.

### 3. Si quiero tener 2 menús distintos, ¿qué debería modificar?

Tendría que duplicar o modificar el método `main` íntegramente. Como el menú y el motor de cálculo están fundidos, no puedo inyectar un menú diferente al mismo motor. Esto evidencia la falta de **Segregación de Interfaces** y de **Inversión de Dependencias**.

### 4. ¿Cómo adiciono operaciones nuevas (ej. Potencia)? ¿Rompe algo más?

Para añadir "Potencia", tendría que entrar directamente al archivo `Main.java` y agregar manualmente un nuevo `case` en el bloque `switch` principal. Esto es peligroso porque estoy alterando una clase que ya tiene "demasiada" responsabilidad y cualquier error de sintaxis o lógica en el nuevo caso podría romper todas las operaciones existentes (regresión). Es el opuesto al principio de **Open/Closed**.

### 5. ¿Qué pasa si ingreso validaciones de dominio (ej. no dividir por cero, no logaritmos negativos)? ¿Dónde irían en este desastre?

En este diseño monolítico, las validaciones terminarían perdidas entre la lógica de entrada de datos y los cálculos. Tendría que llenar el `main` de sentencias `if-else` repetitivas. Por ejemplo, antes de llamar al cálculo de la raíz, tendría que validar allí mismo si el número es negativo. Esto hace que la "regla de negocio" esté dispersa y sea difícil de encontrar o reutilizar en otras partes del programa.

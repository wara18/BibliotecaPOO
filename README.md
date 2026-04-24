# Biblioteca de Prestamos POO
---------------------------------------------------------

## INTEGRANTES
-Martin Francisco - EISI1534 - ISI - 46.788.188
-Avila Wara - EISI1510 - ISI - 46.870.396
-Peralta Lautaro - EISI1589 - ISI - 46788963
-Nuñez Castelli Santiago - EISI1587 - ISI - 47242651

--------------------------------------------------------
## Descripción
Este sistema permite la organización y gestión de préstamos de libros 
utilizando Collections de Java, aplicando principios de POO como 
encapsulamiento, manejo de excepciones personalizadas y recursividad.

## Estructura del proyecto
src/
├── model/          → Libro, Estudiante, Prestamo
├── exception/      → LibroNoDisponibleException, EstudianteNoEncontradoException, LimitePrestamosExcedidoException
├── service/        → BibliotecaService
└── Principal.java  → Casos de prueba

## Decisiones de diseño
- **ArrayList** para el catálogo: permite recorrer todos los libros fácilmente
- **HashMap** para estudiantes: permite encontrar un estudiante por legajo de forma directa
- **HashSet** para préstamos activos: evita registrar el mismo préstamo dos veces

## Como ejecutar
Este programa no cuenta con un menu, si no que directamente se prueba/testea desde la propia Main asignando valores y llamando métodos.

## Análisis de la pila de llamadas — 30 iteraciones
Cuando se llama `calcularMulta(30, 30000)` se generan 31 frames en la pila:

calcularMulta(30, 30000)  ← iteracion 1
→ calcularMulta(29, 30000)  ← iteracion 2
→ calcularMulta(28, 30000)  ← iteracion 3
→ calcularMulta(27, 30000)  ← iteracion 4
→ ...
→ calcularMulta(1, 30000)  ← iteracion 30
→ calcularMulta(0, 30000)  ← iteracion 31 — CASO BASE, retorna 0

**¿Qué pasa en la pila?**
- Cada llamada recursiva **apila** una nueva iteracion con sus propias variables
- La pila crece hasta llegar al caso base (diasRetraso == 0)
- Desde ahí **desapila** de vuelta sumando los resultados parciales
- Con el límite de 30 días, la profundidad máxima es siempre 31 iteraciones

## Salida esperada
Prestamo exitoso: [RK, un mundo en el paraiso] prestado al estudiante: Kento Nanami
Error: El libro no esta disponible
Error: No se encontro el estudiante en cuestion
Error: El estudiante ya tiene 3 prestamos
Multa por 15 dias de retraso: $4500.0

## Tecnologías
- Java 21
- Collections Framework (ArrayList, HashMap, HashSet)
- java.time (LocalDate, ChronoUnit)


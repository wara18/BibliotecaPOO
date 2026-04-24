package model;

import java.time.LocalDate;

public class Prestamo {

    private LocalDate fechaDevolucion;
    private LocalDate fechaPrestamo;
    private Estudiante estudiante;
    private Libro libro;
    
    public Prestamo(LocalDate fechaDevolucion, LocalDate fechaPrestamo, Estudiante estudiante, Libro libro) {
        this.fechaDevolucion = fechaDevolucion;
        this.fechaPrestamo = fechaPrestamo;
        this.estudiante = estudiante;
        this.libro = libro;
    }

    
}

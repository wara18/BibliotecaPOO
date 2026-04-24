package model;

import java.time.LocalDate;

public class Prestamo {

    private LocalDate fechaDevolucion;
    private LocalDate fechaPrestamo;
    private Estudiante estudiante;
    private Libro libro;

    //Constructor
    public Prestamo(Libro libro, Estudiante estudiante, LocalDate fechaPrestamo) {
        this.libro = libro;
        this.estudiante = estudiante;
        this.fechaPrestamo = fechaPrestamo;
    }

    //Getters
    public Libro getLibro() { 
        return libro; 
    }
    
    public Estudiante getEstudiante() { 
        return estudiante; 
    }
    
    public LocalDate getFechaPrestamo() { 
        return fechaPrestamo; 
    }
    
    public LocalDate getFechaDevolucion() { 
        return fechaDevolucion; 
    }
    

    public void setFechaDevolucion(LocalDate fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((estudiante == null) ? 0 : estudiante.hashCode());
        result = prime * result + ((libro == null) ? 0 : libro.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Prestamo other = (Prestamo) obj;
        if (estudiante == null) {
            if (other.estudiante != null)
                return false;
        } else if (!estudiante.equals(other.estudiante))
            return false;
        if (libro == null) {
            if (other.libro != null)
                return false;
        } else if (!libro.equals(other.libro))
            return false;
        return true;
    }

    //ToString
    @Override
    public String toString() {
        return "Prestamo [fechaDevolucion=" + fechaDevolucion + ", fechaPrestamo=" + fechaPrestamo + ", estudiante="
                + estudiante + ", libro=" + libro + "]";
    }
    

    

}
        
    
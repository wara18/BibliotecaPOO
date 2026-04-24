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

    public double calcularMulta(long diasRetraso, double valorLibro) {
        
        if(diasRetraso > 30){
            diasRetraso=30;
        }

        if(diasRetraso == 0){
            return 0;
        }
       

        return (valorLibro*0.01) + calcularMulta(diasRetraso - 1,valorLibro);

    }

    //ToString
    @Override
    public String toString() {
        return "Prestamo [fechaDevolucion=" + fechaDevolucion + ", fechaPrestamo=" + fechaPrestamo + ", estudiante="
                + estudiante + ", libro=" + libro + "]";
    }
    

    

}
        
    
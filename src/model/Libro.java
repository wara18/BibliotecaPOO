package model;

public class Libro {

    private String ISBN;
    private String titulo;
    private String autor;
    private int anio;
    private boolean disponibilidad;
    private double valorLibro;
    
    //Constructor
    public Libro(String ISBN, String titulo, String autor, int anio, boolean disponibilidad, double valorLibro) {
        this.ISBN = ISBN;
        this.titulo = titulo;
        this.autor = autor;
        this.anio = anio;
        this.disponibilidad = disponibilidad;
        this.valorLibro = valorLibro;
    }


    //Getters
    public String getIsbn() { 
        return ISBN; 
    }
    
    public String getTitulo() { 
        return titulo; 
    }
    
    public String getAutor() { 
        return autor; 
    }
    
    public int getAnio() { 
        return anio; 
    }

    public boolean getLibroDisponible(){
        return disponibilidad;
    }

    public double getValorLibro() { 
        return valorLibro; 
    }
    

    public void setDisponibilidad(boolean disponibilidad) {
        this.disponibilidad = false;
    }


    //ToString
    @Override
    public String toString() {
        return "Libro [ISBN=" + ISBN + ", titulo=" + titulo + ", autor=" + autor + ", anio=" + anio
                + ", disponibilidad=" + disponibilidad + "]";
    }

    
}

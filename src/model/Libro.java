package model;

public class Libro {

    private String ISBN;
    private String titulo;
    private String autor;
    private int anio;
    private boolean disponibilidad;
    
    public Libro(String iSBN, String titulo, String autor, int anio, boolean disponibilidad) {
        ISBN = iSBN;
        this.titulo = titulo;
        this.autor = autor;
        this.anio = anio;
        this.disponibilidad = disponibilidad;
    }

    
}

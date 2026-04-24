package model;

public class Estudiante {

    private String legajo;
    private String nombre;
    private String carrera;
    private String mail;
    
    //Constructor
    public Estudiante(String legajo, String nombre, String carrera, String mail) {
        this.legajo = legajo;
        this.nombre = nombre;
        this.carrera = carrera;
        this.mail = mail;
    }

    //getters
    public String getLegajo() {
        return legajo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCarrera() {
        return carrera;
    }

    public String getMail() {
        return mail;
    }


    //ToString
    @Override
    public String toString() {
        return "Estudiante [legajo=" + legajo + ", nombre=" + nombre + ", carrera=" + carrera + ", mail=" + mail + "]";
    }

    


}
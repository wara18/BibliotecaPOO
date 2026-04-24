package service;
import model.Libro;
import model.Estudiante;
import model.Prestamo;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import exception.EstudianteNoEncontradoException;
import exception.LibroNoDisponibleException;
import exception.LimitePrestamosExcedidoException;

public class BibliotecaService {

    private ArrayList<Libro> catalogo;
    private HashMap<String, Estudiante> estudiantes; // clave es el legajo
    private HashSet<Prestamo> prestamosActivos;

    
    public BibliotecaService() { // Constructor
        this.catalogo = new ArrayList<>();
        this.estudiantes = new HashMap<>();
        this.prestamosActivos = new HashSet<>();

    }

    //Prestamos Por Estudiante
    public int prestamosPorEstudiante(Estudiante estudiante){

        int cantPrestamos=0;
        for (Prestamo prestamo : prestamosActivos) {
           if(prestamo.getEstudiante().getLegajo().equals(estudiante.getLegajo())) { // La matricula del estudiante ingresado, el if compara si esa matricula coincide con alguna de las que tiene un prestamo asociado
            cantPrestamos++;
           }
        }
        return cantPrestamos;
    }

    //Sumar libros a la biblioteca.
    public void registrarLibro(Libro libro){
        catalogo.add(libro);
    }

    //Sumar estudiantes al listado de la biblioteca.
    public void registrarEstudiante(Estudiante estudiante){ // 
        estudiantes.put(estudiante.getLegajo(),estudiante);
    }

    //ERRORES
    public void registrarPrestamo(Libro libro, Estudiante estudiante) throws LibroNoDisponibleException,EstudianteNoEncontradoException,LimitePrestamosExcedidoException{ //  
        if(!libro.getLibroDisponible()){ // Primero tenemos que ver que el libro este disponible
            throw new LibroNoDisponibleException("El libro no esta disponible"); // Lanzamos la excepcion
        }
        if(estudiantes.get(estudiante.getLegajo()) == null){ // Verificamos que el estudiante exista, el metodo get devuelve un null si no existe
            throw new EstudianteNoEncontradoException("No se encontro el estudiante en cuestion"); // Lanzamos la excepcion
        }
        if(prestamosPorEstudiante(estudiante)==3){
            throw new LimitePrestamosExcedidoException("El estudiante ya tiene 3 prestamos");
        }
        // LUEGO DE ESTO SE VERIFICO QUE EL ESTUDIANTE EXISTE, NO TIENE 3 PRESTAMOS, Y EL LIBRO EXISTE. ENTONCES SE PUEDE CONTINUAR CON LA CREACION DEL PRESTAMO


        prestamosActivos.add(new Prestamo(libro, estudiante, LocalDate.now())); // Se crea prestamo junto con la hora local
        libro.setDisponibilidad(false); // Se cambia la disponibilidad
    }
    
    // Metodo para devolver libros.
    public void registrarDevolucion(Libro libro) {

        Prestamo prestamoEncontrado = null;

        for(Prestamo prestamo : prestamosActivos){
            if(prestamo.getLibro().getIsbn().equals(libro.getIsbn())){
                prestamoEncontrado = prestamo;
                break;
            }
        }
       
        if(prestamoEncontrado != null){
            libro.setDisponibilidad(true);
            long diasRetraso = ChronoUnit.DAYS.between(prestamoEncontrado.getFechaPrestamo(), LocalDate.now());
            double valorLibro = prestamoEncontrado.getLibro().getValorLibro();
            
            if(diasRetraso > 0) {
                double multa = calcularMulta((int) diasRetraso, valorLibro);
                if(multa>0) {
                    System.out.println("El recargo por la tardanza es de: " + multa);
                } else {
                    System.out.println("Se entrego sin dias de retraso! no hay multa aplicable, monto total:" + valorLibro);
                }
            }
            
            prestamoEncontrado.setFechaDevolucion(LocalDate.now()); // seteamos la fecha de devolucion del libro
            prestamosActivos.remove(prestamoEncontrado); //  borramos el prestamo una vez devuelto
            
        }
    

    }

    // metodo calcular multa segun retraso.
    public double calcularMulta(int diasRetraso, double valorLibro) {
        
        if(diasRetraso > 30){
            diasRetraso=30;
        }

        if(diasRetraso == 0){
            return 0;
        }
       

        return (valorLibro*0.01) + calcularMulta(diasRetraso - 1,valorLibro);

    }

    // Metodo para buscar libro parcialmente por titulo.
    public void buscarLibro(String texto){

        for(Libro libro : catalogo){
            if(libro.getTitulo().toLowerCase().contains(texto.toLowerCase())){
                System.out.println("Libro encontrado: " + libro.getTitulo());
            }
        }
    }

    // Metodo para ver los prestamos por estudiante.
    public void listarPrestamosPorEstudiante(Estudiante estudiante){
        for(Prestamo prestamo : prestamosActivos){
            if(prestamo.getEstudiante().getLegajo().equals(estudiante.getLegajo())){
                System.out.println(prestamo);
            }
        }
    }


    //ToS
    @Override
    public String toString() {
        return "BibliotecaService [catalogo=" + catalogo + "\n";
    }


}



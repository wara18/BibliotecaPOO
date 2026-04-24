import model.Libro;
import model.Prestamo;
import exception.EstudianteNoEncontradoException;
import exception.LibroNoDisponibleException;
import exception.LimitePrestamosExcedidoException;
import model.Estudiante;
import service.BibliotecaService;

public class Principal {

    public static void main(String[] args) {
        
        //Clase bibliotecaserivce
        BibliotecaService service= new BibliotecaService();

        //Libros Creados(Existentes)
        Libro libro1 = new Libro("1111", "Las aventuras de paki", "Wari", 2001, true);
        Libro libro2 = new Libro("2222", "Pakitron remix", "Paki", 2002, true);
        Libro libro3 = new Libro("3333", "Oma", "Wari", 2005, true);
        Libro libro4 = new Libro("4444", "Popis adventures", "Tron", 2004, true);
        Libro libro5 = new Libro("5555", "Escapa de popis", "Gamier", 2005, true);

        //Estudiantes Creados
        Estudiante estudianteA = new Estudiante("EISI1510", "Pakito", "ISI", "Pakitogamer777@gmail.com");

        
        //Guardar Libro, estudiantes
        service.registrarLibro(libro1);
        service.registrarLibro(libro2);
        service.registrarLibro(libro3);
        service.registrarLibro(libro4);
        service.registrarLibro(libro5);
        service.registrarEstudiante(estudianteA);
        
        try {
            service.registrarPrestamo(libro1, estudianteA);
            service.registrarPrestamo(libro1, estudianteA);
            service.registrarPrestamo(libro1, estudianteA);
            service.registrarPrestamo(libro1, estudianteA);
        } catch (LibroNoDisponibleException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (EstudianteNoEncontradoException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (LimitePrestamosExcedidoException e) {
            System.out.println("Error: " + e.getMessage());
        }


        System.out.println(service);


    }
}


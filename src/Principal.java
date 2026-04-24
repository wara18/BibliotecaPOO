import model.Libro;
import model.Prestamo;

import java.time.LocalDate;

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
        Libro libro1 = new Libro("1111", "RK, un mundo en el paraiso", "Geovani", 2025, true, 10000);
        Libro libro2 = new Libro("2222", "Calculo de Una Variable", "Maximiliano Sotelo", 2005, true, 1000);
        Libro libro3 = new Libro("3333", "Jujutsu Kaisen VL23", "Gege Akutami", 2018, true, 20000);
        Libro libro4 = new Libro("4444", "Harry Poter y La Piedra Filosofal", "Santiago Nuñez Castelli", 1999, true, 2000);
        Libro libro5 = new Libro("5555", "FISICA MODERNA", "Kento Nanami", 2018, true, 30000);

        //Estudiantes Creados
        Estudiante estudianteA = new Estudiante("EISI1510", "Kento Nanami", "ISI", "NoWork@gmail.com");
        Estudiante estudianteB = new Estudiante("EISI1430", "Itadori Yuji", "ISI", "NoKILL@gmail.com");
        Estudiante estudianteC = new Estudiante("EISI1313", "Juan Herrera", "ISI", "juanASD@gmail.com");
        Estudiante estudianteD = new Estudiante("EISI1213", "Samuel De Luque", "ISI", "samuelcito777@gmail.com");
        
        //Guardar Libro, estudiantes
        service.registrarLibro(libro1);
        service.registrarLibro(libro2);
        service.registrarLibro(libro3);
        service.registrarLibro(libro4);
        service.registrarLibro(libro5);
        service.registrarEstudiante(estudianteA);
        service.registrarEstudiante(estudianteB);
        service.registrarEstudiante(estudianteC);
        
        //Excepciones CASOS PEDIDOS POR EL TP ----------------------------


        // CASO 1: Préstamo exitoso

        try {
            service.registrarPrestamo(libro1, estudianteA); // Se intenta registrar un prestamo pasandole el libro y el estudiante
            System.out.printf("Prestamo exitoso: [%s] prestado al estudiante: %s\n", libro1.getTitulo(),estudianteA.getNombre());
        } catch (LibroNoDisponibleException | EstudianteNoEncontradoException | LimitePrestamosExcedidoException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // CASO 2: LibroNoDisponibleException
        
        try {
            service.registrarPrestamo(libro1, estudianteB); // Intento de prestar libro ya PRESTADO (LibroNoDisponibleException)
        } catch (LibroNoDisponibleException | EstudianteNoEncontradoException | LimitePrestamosExcedidoException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // CASO 3: EstudianteNoEncontradoException
        
        try {
            service.registrarPrestamo(libro5, estudianteD); // estudianteD no registrado en la lista
        } catch (LibroNoDisponibleException | EstudianteNoEncontradoException | LimitePrestamosExcedidoException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // CASO 4: LimitePrestamosExcedidoException
        try {
            service.registrarPrestamo(libro2, estudianteA);
            service.registrarPrestamo(libro3, estudianteA);
            service.registrarPrestamo(libro4, estudianteA); // Limite de prestamo excedido para el estudiante A (LimitePrestamosExcedidoException)
        } catch (LibroNoDisponibleException | EstudianteNoEncontradoException | LimitePrestamosExcedidoException e) {
            System.out.println("Error: " + e.getMessage());
        }
        
        // CASO 5: Multa por 15 días de retraso
            double multa = service.calcularMulta(15, libro5.getValorLibro()); // Multa calculada por retraso de devolucion
            System.out.println("Multa por 15 dias de retraso: $" + multa);

    }
}


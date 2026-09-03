package principal;

import interfaces.Descargable;
import interfaces.Prestable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import modelo.Libro;
import modelo.LibroDigital;
import modelo.MaterialBibliografico;
//import modelo.Revista;

public class Main {

    private static final List<MaterialBibliografico> biblioteca = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;

        do {
            mostrarMenu();
            opcion = Integer.parseInt(scanner.nextLine());

            switch (opcion) {
                case 1 -> registrarLibro();
                case 2 -> System.out.println("Funcionalidad de registrar revista no implementada.");
                case 3 -> registrarLibroDigital();
                case 4 -> mostrarMateriales();
                case 5 -> prestarMaterial();
                case 6 -> devolverMaterial();
                case 7 -> descargarMaterial();
                case 8 -> mostrarEstadisticas();
                case 0 -> System.out.println("Saliendo del sistema...");
                default -> System.out.println("Opción no válida. Intente de nuevo.");
            }
            System.out.println();
        } while (opcion != 0);
    }

    private static void mostrarMenu() {
        System.out.println("====== BIBLIOTECA UNIVERSITARIA ======");
        System.out.println("1. Registrar libro");
        System.out.println("2. Registrar revista");
        System.out.println("3. Registrar libro digital");
        System.out.println("4. Mostrar materiales");
        System.out.println("5. Prestar material");
        System.out.println("6. Devolver material");
        System.out.println("7. Descargar material digital");
        System.out.println("8. Mostrar estadísticas");
        System.out.println("0. Salir");
        System.out.print("Seleccione una opción: ");
    }

    private static void registrarLibro() {
        System.out.print("Código: ");
        String codigo = scanner.nextLine();
        System.out.print("Título: ");
        String titulo = scanner.nextLine();
        System.out.print("Año de publicación: ");
        int anio = Integer.parseInt(scanner.nextLine());
        System.out.print("Autor: ");
        String autor = scanner.nextLine();

        biblioteca.add(new Libro(codigo, titulo, anio, autor));
        System.out.println("Libro registrado exitosamente.");
    }

    /*private static void registrarRevista() {
        System.out.print("Código: ");
        String codigo = scanner.nextLine();
        System.out.print("Título: ");
        String titulo = scanner.nextLine();
        System.out.print("Año de publicación: ");
        int anio = Integer.parseInt(scanner.nextLine());
        System.out.print("Número de edición: ");
        int numeroEdicion = Integer.parseInt(scanner.nextLine());

        //biblioteca.add(new Revista(codigo, titulo, anio, numeroEdicion));
        //System.out.println("Revista registrada exitosamente.");
    }
*/
    private static void registrarLibroDigital() {
        System.out.print("Código: ");
        String codigo = scanner.nextLine();
        System.out.print("Título: ");
        String titulo = scanner.nextLine();
        System.out.print("Año de publicación: ");
        int anio = Integer.parseInt(scanner.nextLine());
        System.out.print("Autor: ");
        String autor = scanner.nextLine();
        System.out.print("Tamaño del archivo (MB): ");
        double tamanoMB = Double.parseDouble(scanner.nextLine());

        biblioteca.add(new LibroDigital(codigo, titulo, anio, autor, tamanoMB));
        System.out.println("Libro digital registrado exitosamente.");
    }

    private static void mostrarMateriales() {
        if (biblioteca.isEmpty()) {
            System.out.println("No hay materiales registrados.");
            return;
        }
        // Reto 5: Polimorfismo. Se recorre la lista general invocado el método sobrescrito
        for (MaterialBibliografico mat : biblioteca) {
            mat.mostrarInformacion();
            System.out.println("-----------------------------------");
        }
    }

    private static void prestarMaterial() {
        System.out.print("Código del material a prestar: ");
        String codigo = scanner.nextLine();
        MaterialBibliografico mat = buscarPorCodigo(codigo);

        if (mat == null) {
            System.out.println("Material no encontrado.");
        } else if (mat instanceof Prestable prestable) {
            prestable.prestar();
        } else {
            System.out.println("Este material no se puede prestar.");
        }
    }

    private static void devolverMaterial() {
        System.out.print("Código del material a devolver: ");
        String codigo = scanner.nextLine();
        MaterialBibliografico mat = buscarPorCodigo(codigo);

        if (mat == null) {
            System.out.println("Material no encontrado.");
        } else if (mat instanceof Prestable prestable) {
            prestable.devolver();
        } else {
            System.out.println("Este material no tiene opción de devolución.");
        }
    }

    private static void descargarMaterial() {
        System.out.print("Código del material a descargar: ");
        String codigo = scanner.nextLine();
        MaterialBibliografico mat = buscarPorCodigo(codigo);

        if (mat == null) {
            System.out.println("Material no encontrado.");
        } else if (mat instanceof Descargable descargable) {
            descargable.descargar();
        } else {
            System.out.println("Este material no se puede descargar.");
        }
    }

    private static void mostrarEstadisticas() {
        System.out.println("Total de materiales creados: " 
                + MaterialBibliografico.getCantidadTotalMateriales());
    }

    private static MaterialBibliografico buscarPorCodigo(String codigo) {
        for (MaterialBibliografico mat : biblioteca) {
            if (mat.getCodigo().equalsIgnoreCase(codigo)) {
                return mat;
            }
        }
        return null;
    }
}
// alexis
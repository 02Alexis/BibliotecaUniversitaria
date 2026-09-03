package principal;

import java.util.Scanner;
import modelo.Libro;
import modelo.LibroDigital;
import modelo.Revista;
import servicio.GestorBiblioteca;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);

    private static final GestorBiblioteca gestor =
            new GestorBiblioteca();

    public static void main(String[] args) {

        int opcion;

        do {

            mostrarMenu();

            opcion = Integer.parseInt(scanner.nextLine());

            switch (opcion) {

                case 1 -> registrarLibro();

                case 2 -> registrarRevista();

                case 3 -> registrarLibroDigital();

                case 4 -> gestor.mostrarTodosLosMateriales();

                case 5 -> prestarMaterial();

                case 6 -> devolverMaterial();

                case 7 -> descargarMaterial();

                case 8 -> gestor.mostrarEstadisticas();

                case 0 ->
                        System.out.println(
                                "Saliendo del sistema..."
                        );

                default ->
                        System.out.println(
                                "Opción no válida. Intente de nuevo."
                        );
            }

            System.out.println();

        } while (opcion != 0);

        scanner.close();
    }

    private static void mostrarMenu() {

        System.out.println(
                "====== BIBLIOTECA UNIVERSITARIA ======"
        );

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

        System.out.println("===== REGISTRAR LIBRO =====");

        System.out.print("Código: ");
        String codigo = scanner.nextLine();

        System.out.print("Título: ");
        String titulo = scanner.nextLine();

        System.out.print("Año de publicación: ");
        int anio = Integer.parseInt(scanner.nextLine());

        System.out.print("Autor: ");
        String autor = scanner.nextLine();

        Libro libro =
                new Libro(codigo, titulo, anio, autor);

        gestor.registrarMaterial(libro);
    }

    private static void registrarRevista() {

        System.out.println("===== REGISTRAR REVISTA =====");

        System.out.print("Código: ");
        String codigo = scanner.nextLine();

        System.out.print("Título: ");
        String titulo = scanner.nextLine();

        System.out.print("Año de publicación: ");
        int anio = Integer.parseInt(scanner.nextLine());

        System.out.print("Número de edición: ");
        int numeroEdicion =
                Integer.parseInt(scanner.nextLine());

        Revista revista =
                new Revista(
                        codigo,
                        titulo,
                        anio,
                        numeroEdicion
                );

        gestor.registrarMaterial(revista);
    }

    private static void registrarLibroDigital() {

        System.out.println(
                "===== REGISTRAR LIBRO DIGITAL ====="
        );

        System.out.print("Código: ");
        String codigo = scanner.nextLine();

        System.out.print("Título: ");
        String titulo = scanner.nextLine();

        System.out.print("Año de publicación: ");
        int anio = Integer.parseInt(scanner.nextLine());

        System.out.print("Autor: ");
        String autor = scanner.nextLine();

        System.out.print("Tamaño del archivo (MB): ");
        double tamanoArchivo =
                Double.parseDouble(scanner.nextLine());

        LibroDigital libroDigital =
                new LibroDigital(
                        codigo,
                        titulo,
                        anio,
                        autor,
                        tamanoArchivo
                );

        gestor.registrarMaterial(libroDigital);
    }

    private static void prestarMaterial() {

        System.out.print(
                "Código del material a prestar: "
        );

        String codigo = scanner.nextLine();

        gestor.prestarMaterial(codigo);
    }

    private static void devolverMaterial() {

        System.out.print(
                "Código del material a devolver: "
        );

        String codigo = scanner.nextLine();

        gestor.devolverMaterial(codigo);
    }

    private static void descargarMaterial() {

        System.out.print(
                "Código del material a descargar: "
        );

        String codigo = scanner.nextLine();

        gestor.descargarMaterial(codigo);
    }
}
package principal;

import modelo.Libro;

public class Main {

    public static void main(String[] args) {

        Libro libro1 = new Libro(
                "L001",
                "Cien años de soledad",
                1967,
                "Gabriel García Márquez"
        );

        Libro libro2 = new Libro(
                "L002",
                "El principito",
                "Antoine de Saint-Exupéry"
        );

        System.out.println("===== LIBRO 1 =====");
        libro1.mostrarInformacion();

        System.out.println();

        System.out.println("===== LIBRO 2 =====");
        libro2.mostrarInformacion();

        System.out.println();

        System.out.println("===== PRUEBA DE PRÉSTAMO =====");

        libro1.prestar();

        System.out.println();

        libro1.mostrarInformacion();

        System.out.println();

        System.out.println("===== DEVOLUCIÓN =====");

        libro1.devolver();

        System.out.println();

        libro1.mostrarInformacion();

        System.out.println();

        System.out.println("Total de materiales creados: "
                + modelo.MaterialBibliografico
                .getCantidadTotalMateriales());
    }
}
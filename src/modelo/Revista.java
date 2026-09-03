package modelo;

import interfaces.Prestable;

public class Revista extends MaterialBibliografico implements Prestable {

    private int numeroEdicion;
    private boolean prestado;

    // Constructor completo
    public Revista(String codigo, String titulo,
                   int anioPublicacion, int numeroEdicion) {

        super(codigo, titulo, anioPublicacion);
        this.numeroEdicion = numeroEdicion;
        this.prestado = false;
    }

    // Constructor sobrecargado
    public Revista(String codigo, String titulo,
                   int numeroEdicion) {

        super(codigo, titulo);
        this.numeroEdicion = numeroEdicion;
        this.prestado = false;
    }

    public int getNumeroEdicion() {
        return numeroEdicion;
    }

    public boolean isPrestado() {
        return prestado;
    }

    @Override
    public void mostrarInformacion() {

        System.out.println("Tipo: Revista");
        System.out.println("Código: " + getCodigo());
        System.out.println("Título: " + getTitulo());
        System.out.println("Año de publicación: "
                + getAnioPublicacion());
        System.out.println("Número de edición: " + numeroEdicion);

        if (prestado) {
            System.out.println("Estado: Prestado");
        } else {
            System.out.println("Estado: Disponible");
        }
    }

    @Override
    public void prestar() {

        if (!prestado) {
            prestado = true;
            System.out.println("La revista ha sido prestada.");
        } else {
            System.out.println("La revista ya está prestada.");
        }
    }

    @Override
    public void devolver() {

        if (prestado) {
            prestado = false;
            System.out.println("La revista ha sido devuelta.");
        } else {
            System.out.println("La revista no estaba prestada.");
        }
    }
}
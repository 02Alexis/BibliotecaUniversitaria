package modelo;

import interfaces.Prestable;

public class Libro extends MaterialBibliografico implements Prestable {

    private String autor;
    private boolean prestado;

    // Constructor completo
    public Libro(String codigo, String titulo,
                 int anioPublicacion, String autor) {

        super(codigo, titulo, anioPublicacion);
        this.autor = autor;
        this.prestado = false;
    }

    // Constructor sobrecargado
    public Libro(String codigo, String titulo, String autor) {

        super(codigo, titulo);
        this.autor = autor;
        this.prestado = false;
    }

    public String getAutor() {
        return autor;
    }

    public boolean isPrestado() {
        return prestado;
    }

    @Override
    public void mostrarInformacion() {

        System.out.println("Tipo: Libro");
        System.out.println("Código: " + getCodigo());
        System.out.println("Título: " + getTitulo());
        System.out.println("Año de publicación: "
                + getAnioPublicacion());
        System.out.println("Autor: " + autor);

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
            System.out.println("El libro ha sido prestado.");
        } else {
            System.out.println("El libro ya está prestado.");
        }
    }

    @Override
    public void devolver() {

        if (prestado) {
            prestado = false;
            System.out.println("El libro ha sido devuelto.");
        } else {
            System.out.println("El libro no estaba prestado.");
        }
    }
}
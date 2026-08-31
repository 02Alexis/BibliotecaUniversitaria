package modelo;

import interfaces.Descargable;

public class LibroDigital extends MaterialBibliografico implements Descargable {

    private final String autor;
    private double tamanoArchivoMB;

    // Constructor completo
    public LibroDigital(String codigo, String titulo, int anioPublicacion, String autor, double tamanoArchivoMB) {
        super(codigo, titulo, anioPublicacion);
        this.autor = autor;
        this.tamanoArchivoMB = tamanoArchivoMB;
    }

    // Constructor sobrecargado (Cumple Reto 2)
    public LibroDigital(String codigo, String titulo, String autor, double tamanoArchivoMB) {
        super(codigo, titulo);
        this.autor = autor;
        this.tamanoArchivoMB = tamanoArchivoMB;
    }

    public String getAutor() {
        return autor;
    }

    public double getTamanoArchivoMB() {
        return tamanoArchivoMB;
    }

    public void setTamanoArchivoMB(double tamanoArchivoMB) {
        this.tamanoArchivoMB = tamanoArchivoMB;
    }

    @Override
    public void descargar() {
        System.out.println("Descargando '" + getTitulo() + "' (" + tamanoArchivoMB + " MB)...");
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("--- LIBRO DIGITAL ---");
        System.out.println("Código: " + getCodigo());
        System.out.println("Título: " + getTitulo());
        System.out.println("Año de publicación: " + getAnioPublicacion());
        System.out.println("Autor: " + autor);
        System.out.println("Tamaño de archivo: " + tamanoArchivoMB + " MB");
        System.out.println("Estado: Disponible para descarga");
    }
}
// clase padre
package modelo;

public abstract class MaterialBibliografico {

    private String codigo;
    private String titulo;
    private int anioPublicacion;

    private static int cantidadTotalMateriales = 0;

    // Constructor completo
    public MaterialBibliografico(String codigo, String titulo, int anioPublicacion) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.anioPublicacion = anioPublicacion;

        cantidadTotalMateriales++;
    }

    // Constructor sobrecargado
    public MaterialBibliografico(String codigo, String titulo) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.anioPublicacion = 0;

        cantidadTotalMateriales++;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getAnioPublicacion() {
        return anioPublicacion;
    }

    public static int getCantidadTotalMateriales() {
        return cantidadTotalMateriales;
    }

    public abstract void mostrarInformacion();
}
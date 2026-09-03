package servicio;

import java.util.ArrayList;
import java.util.List;

import interfaces.Descargable;
import interfaces.Prestable;
import modelo.MaterialBibliografico;

public class GestorBiblioteca {

    private List<MaterialBibliografico> listaMateriales;

    public GestorBiblioteca() {
        listaMateriales = new ArrayList<>();
    }

    public void registrarMaterial(MaterialBibliografico material) {

        listaMateriales.add(material);

        System.out.println("Material registrado exitosamente.");
    }

    public void mostrarTodosLosMateriales() {

        if (listaMateriales.isEmpty()) {
            System.out.println("No hay materiales registrados.");
            return;
        }

        System.out.println("===== MATERIALES REGISTRADOS =====");

        for (MaterialBibliografico material : listaMateriales) {

            material.mostrarInformacion();

            System.out.println("-----------------------------------");
        }
    }

    public void prestarMaterial(String codigo) {

        MaterialBibliografico material = buscarMaterial(codigo);

        if (material == null) {

            System.out.println("Material no encontrado.");
            return;
        }

        if (material instanceof Prestable prestable) {

            prestable.prestar();

        } else {

            System.out.println(
                    "Este material no se puede prestar."
            );
        }
    }

    public void devolverMaterial(String codigo) {

        MaterialBibliografico material = buscarMaterial(codigo);

        if (material == null) {

            System.out.println("Material no encontrado.");
            return;
        }

        if (material instanceof Prestable prestable) {

            prestable.devolver();

        } else {

            System.out.println(
                    "Este material no tiene opción de devolución."
            );
        }
    }

    public void descargarMaterial(String codigo) {

        MaterialBibliografico material = buscarMaterial(codigo);

        if (material == null) {

            System.out.println("Material no encontrado.");
            return;
        }

        if (material instanceof Descargable descargable) {

            descargable.descargar();

        } else {

            System.out.println(
                    "Este material no se puede descargar."
            );
        }
    }

    public void mostrarEstadisticas() {

        System.out.println(
                "Total de materiales creados: "
                + MaterialBibliografico
                        .getCantidadTotalMateriales()
        );
    }

    private MaterialBibliografico buscarMaterial(String codigo) {

        for (MaterialBibliografico material : listaMateriales) {

            if (material.getCodigo().equalsIgnoreCase(codigo)) {
                return material;
            }
        }

        return null;
    }
}
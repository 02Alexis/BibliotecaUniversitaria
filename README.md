<a name="readme-top"></a>

<details>
<summary>Tabla de contenidos</summary>

1. [Descripción](#descripción)
1. [Tipos de Material](#tipos-de-material)
1. [Organización del proyecto](#organización-del-proyecto)
2. [Paquetes](#paquete-modelo)
   - [Paquete Modelo](#paquete-modelo)
   - [Paquete Interfaces](#paquete-interfaces)
   - [Paquete Servicio](#paquete-servicio)
   - [Paquete Principal](#paquete-principal)
1. [Requisitos](#requisitos)
1. [Compilación](#compilación)
1. [Ejecución](#ejecución)
1. [Funcionalidades](#funcionalidades)
2. [Conceptos de POO evidenciados](#conceptos-de-poo-evidenciados)
   - [Encapsulamiento](#encapsulamiento)
   - [Sobrecarga](#sobrecarga)
   - [Herencia](#herencia)
   - [Clase abstracta](#clase-abstracta)
   - [Interfaces](#interfaces)
   - [Polimorfismo](#polimorfismo)
1. [Diagrama UML](#diagrama-uml)

</details>

# Biblioteca Universitaria

[Documentacion](https://docs.google.com/document/d/1ruTj5JhnZvG64X7dGwDrf-wHWLKU3Z05/edit?usp=drive_link&ouid=110833674822568697663&rtpof=true&sd=true)

## Descripción

Aplicación de consola desarrollada en Java para gestionar materiales bibliográficos de una biblioteca universitaria.

El sistema implementa los conceptos fundamentales de Programación Orientada a Objetos solicitados en el Laboratorio 1 de Técnicas de Programación y Laboratorio:

- Clases y objetos.
- Encapsulamiento.
- Constructores y sobrecarga.
- Miembros `static`.
- Herencia.
- Clase abstracta.
- Interfaces.
- Polimorfismo.
- Entrada y salida de información por consola.

<p align="right">(<a href="#readme-top">volver arriba</a>)</p>

## Tipos de material

La aplicación permite gestionar tres tipos de materiales:

| Material | Datos particulares | Puede prestarse | Puede descargarse |
|---|---|---|---|
| Libro | Autor | Sí | No |
| Revista | Número de edición | Sí | No |
| Libro digital | Autor y tamaño del archivo | No | Sí |

Todos los materiales heredan de la clase abstracta `MaterialBibliografico`, que contiene la información común:

- Código.
- Título.
- Año de publicación.

<p align="right">(<a href="#readme-top">volver arriba</a>)</p>

## Organización del proyecto

El código fuente se encuentra organizado por paquetes:

```text
src/
├── interfaces/
│   ├── Descargable.java
│   └── Prestable.java
│
├── modelo/
│   ├── MaterialBibliografico.java
│   ├── Libro.java
│   ├── Revista.java
│   └── LibroDigital.java
│
├── servicio/
│   └── GestorBiblioteca.java
│
└── principal/
    └── Main.java
```
<p align="right">(<a href="#readme-top">volver arriba</a>)</p>

### Paquete `modelo`

Contiene las clases que representan los materiales bibliográficos.

- `MaterialBibliografico`: clase abstracta base.
- `Libro`: material que puede prestarse.
- `Revista`: material que puede prestarse.
- `LibroDigital`: material que puede descargarse.

### Paquete `interfaces`

Contiene las capacidades que pueden tener los materiales:

- `Prestable`: define las operaciones `prestar()` y `devolver()`.
- `Descargable`: define la operación `descargar()`.

### Paquete `servicio`

Contiene `GestorBiblioteca`, encargado de registrar, consultar, prestar, devolver, descargar y mostrar estadísticas de los materiales.

### Paquete `principal`

Contiene `Main`, que presenta el menú de consola y permite al usuario interactuar con el sistema.

<p align="right">(<a href="#readme-top">volver arriba</a>)</p>

## Requisitos

Para compilar y ejecutar el proyecto se necesita:

- Java JDK instalado.
- Terminal o consola.
- Ubicarse en la carpeta `src` del proyecto.

Se recomienda utilizar una versión de Java que soporte la sintaxis utilizada por el proyecto.

<p align="right">(<a href="#readme-top">volver arriba</a>)</p>

## Compilación

Desde la carpeta `src`, ejecutar:

```bash
javac modelo/*.java interfaces/*.java servicio/*.java principal/*.java
```

Si la compilación termina sin mostrar errores, el proyecto está listo para ejecutarse.

## Ejecución

Después de compilar, ejecutar desde la misma carpeta `src`:

```bash
java principal.Main
```

También es posible ejecutar directamente el archivo principal desde la carpeta `src/principal` utilizando:

```bash
java Main.java
```

Sin embargo, la forma recomendada para ejecutar el proyecto completo y respetar la organización por paquetes es:

```bash
java principal.Main
```
<p align="right">(<a href="#readme-top">volver arriba</a>)</p>

## Menú de la aplicación

Al ejecutar el programa se muestra el siguiente menú:

```text
====== BIBLIOTECA UNIVERSITARIA ======
1. Registrar libro
2. Registrar revista
3. Registrar libro digital
4. Mostrar materiales
5. Prestar material
6. Devolver material
7. Descargar material digital
8. Mostrar estadísticas
0. Salir
```
<p align="right">(<a href="#readme-top">volver arriba</a>)</p>

### Funcionalidades

**1. Registrar libro**

Solicita:

- Código.
- Título.
- Año de publicación.
- Autor.

**2. Registrar revista**

Solicita:

- Código.
- Título.
- Año de publicación.
- Número de edición.

**3. Registrar libro digital**

Solicita:

- Código.
- Título.
- Año de publicación.
- Autor.
- Tamaño del archivo en MB.

**4. Mostrar materiales**

Muestra todos los materiales registrados. Los diferentes tipos se almacenan en una colección común de tipo `MaterialBibliografico` y cada objeto ejecuta su propia implementación de `mostrarInformacion()`.

**5. Prestar material**

Solicita el código del material. Los libros y revistas pueden prestarse. Los materiales que no implementan la capacidad `Prestable` informan que no pueden prestarse.

**6. Devolver material**

Solicita el código del material y permite devolver los materiales que implementan `Prestable`.

**7. Descargar material digital**

Solicita el código del material. Los libros digitales implementan `Descargable` y pueden descargarse.

**8. Mostrar estadísticas**

Muestra la cantidad total de materiales creados durante la ejecución mediante el miembro `static` de `MaterialBibliografico`.

**0. Salir**

Finaliza la aplicación.

<p align="right">(<a href="#readme-top">volver arriba</a>)</p>

## Conceptos de POO evidenciados

### Encapsulamiento

Los atributos de las clases se manejan con acceso restringido (`private`) y se proporcionan métodos de acceso cuando son necesarios.

### Sobrecarga

Se implementaron constructores sobrecargados para permitir diferentes formas de crear los materiales cuando algún dato opcional no está disponible.

### `static`

`MaterialBibliografico` contiene el contador:

```java
private static int cantidadTotalMateriales;
```

Este contador pertenece a la clase porque representa la cantidad total de materiales creados, no una cantidad independiente para cada objeto.

### Herencia

La jerarquía principal es:

```text
MaterialBibliografico
├── Libro
├── Revista
└── LibroDigital
```

### Clase abstracta

`MaterialBibliografico` es abstracta porque representa la información común de los materiales y no se instancia directamente.

### Interfaces

Las capacidades se representan mediante:

```text
Prestable
├── Libro
└── Revista

Descargable
└── LibroDigital
```

### Polimorfismo

Los diferentes tipos de materiales se manejan mediante una colección común:

```java
List<MaterialBibliografico>
```

Al recorrer la colección y ejecutar:

```java
material.mostrarInformacion();
```

cada objeto utiliza la implementación correspondiente a su clase concreta.

<p align="right">(<a href="#readme-top">volver arriba</a>)</p>

## Verificación básica

Para comprobar el funcionamiento completo se recomienda:

1. Registrar un libro.
2. Registrar una revista.
3. Registrar un libro digital.
4. Mostrar los materiales registrados.
5. Prestar un libro.
6. Prestar una revista.
7. Intentar prestar un libro digital y verificar que el sistema lo rechace.
8. Devolver un material prestado.
9. Descargar un libro digital.
10. Consultar las estadísticas.
11. Salir de la aplicación.

<p align="right">(<a href="#readme-top">volver arriba</a>)</p>

## Diagrama UML

<img width="1600" height="852" alt="WhatsApp Image 2026-08-25 at 12 09 20 PM" src="https://github.com/user-attachments/assets/8131ddc2-b6ac-4d11-84da-8cd0b2cc6cbf" />

<p align="right">(<a href="#readme-top">volver arriba</a>)</p>

## Autores

- Alexis Tamayo Quintero
- Jose Carlos Robledo
- Juan José Giraldo Alvarez

## Asignatura

**Técnicas de Programación y Laboratorio**

**Laboratorio 1 — Programación Orientada a Objetos**

**Facultad de Ingeniería — 2026/2**

<p align="right">(<a href="#readme-top">volver arriba</a>)</p>

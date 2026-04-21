import java.io.*;

public class Biblioteca {

    private String nombre;
    private String director;
    private Catalogo catalogo;

    public Biblioteca(String nombre, String director) {
        this.nombre = nombre;
        this.director = director;
    }
    public void construirCatalogo(int capacidad) {
        catalogo = new Catalogo(capacidad);
    }
public void eliminarLibro(String isbn) {

        if (catalogo == null) {
            throw new RuntimeException("El catálogo no existe");
        }

        boolean eliminado = false;

        for (int i = 0; i < catalogo.numLibros; i++) {

            if (catalogo.libros[i].getIsbn().equals(isbn)) {

                for (int j = i; j < catalogo.numLibros - 1; j++) {
                    catalogo.libros[j] = catalogo.libros[j + 1];
                }

                catalogo.libros[catalogo.numLibros - 1] = null;
                catalogo.numLibros--;

                System.out.println("Libro eliminado correctamente");
                eliminado = true;
                break;
            }
        }

        if (!eliminado) {
            System.out.println("No existe ningún libro con ese ISBN");
        }
}
    public void agregarLibro(Libro libro) {

        if (catalogo == null) {
            throw new RuntimeException("El catálogo no existe");
        }

        if (catalogo.numLibros < catalogo.capacidad) {

            catalogo.libros[catalogo.numLibros] = libro;
            catalogo.numLibros++;

        } else {

            System.out.println("No hay espacio en el catálogo");
        }
    }
    public void buscarLibro(String isbn) {
        if (catalogo == null) {
            throw new RuntimeException("El catálogo no existe");
        }
        boolean encontrado = false;
        for (int i = 0; i < catalogo.numLibros; i++) {
            if (catalogo.libros[i].getIsbn().equals(isbn)) {
                System.out.println("Libro encontrado");
                System.out.println(catalogo.libros[i]);
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            System.out.println("No existe ningún libro con ese ISBN");
        }
    }
    public void mostrarCatalogo() {
        if (catalogo == null){
            throw new RuntimeException( "El catálogo no existe");
            }
        if (catalogo.numLibros == 0) {
            System.out.println("El catálogo está vacío");
        }
        else {
            for (int i = 0; i < catalogo.numLibros; i++) {
                System.out.println(catalogo.libros[i]);
            }
        }
    }

    // clase anidada
    class Catalogo {

        private Libro[] libros;
        private int capacidad;
        private int numLibros;

        public Catalogo(int capacidad) {
            this.capacidad = capacidad;
            libros = new Libro[capacidad];
            numLibros = 0;
        }
    }
    public void exportarLibros(String nombreFichero) {

        if (catalogo == null) {
            throw new RuntimeException("El catálogo no existe");
        }

        try {
            ObjectOutputStream oos = new ObjectOutputStream(
                    new FileOutputStream(nombreFichero)
            );

            oos.writeObject(catalogo.libros);

            oos.close();

            System.out.println("Libros exportados correctamente a " + nombreFichero);

        } catch (IOException e) {
            System.out.println("Error al exportar los libros");
            e.printStackTrace();
        }
    }
}
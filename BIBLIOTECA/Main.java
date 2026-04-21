//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
    Biblioteca biblioteca = new Biblioteca ( "Biblioteca Central" , "Sara");

    biblioteca.construirCatalogo(4);
    LibroTerror l1 = new LibroTerror(
            "STEPHEN KING",
            350,
            "111",
            9.5);
    LibroPoliciaca l2 = new LibroPoliciaca(
            "Agatha Christie",
            300,
            "333",
            "misterio",
            "Poirot");
    LibroComedia l3 = new LibroComedia(
            "David Safier",
            200,
            "222",
            "satírico");
    LibroTerror l4 = new LibroTerror(
                "Clive Barker",
                280,
                "444",
                8.7
        );
        LibroEnsayo l5 = new LibroEnsayo(
                "Yuval Noah Harari",
                320,
                "666",
                "historia y sociedad"
        );
        biblioteca.agregarLibro(l1);
        biblioteca.agregarLibro(l2);
        biblioteca.agregarLibro(l3);
        biblioteca.agregarLibro(l4);
        biblioteca.agregarLibro(l5);

        biblioteca.mostrarCatalogo();
        biblioteca.exportarLibros("libros.obj");
    }
    }

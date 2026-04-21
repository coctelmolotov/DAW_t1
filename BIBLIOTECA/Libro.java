import java.io.Serializable;

public abstract class Libro implements Serializable {
    private String autor;
    private int numeroPaginas;
    private String isbn;

    public Libro(String autor, int numeroPaginas, String isbn) {
        this.autor = autor;
        this.numeroPaginas = numeroPaginas;
        this.isbn = isbn;
    }

    public String getAutor() {
        return autor;
    }

    public int getNumeroPaginas() {
        return numeroPaginas;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setNumeroPaginas(int numeroPaginas) {
        this.numeroPaginas = numeroPaginas;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    @Override
    public String toString() {
        return "Autor: " + autor +
                ", Número de páginas: " + numeroPaginas +
                ", ISBN: " + isbn;
    }
}
public class LibroEnsayo extends Libro {
    private String tema;
    public LibroEnsayo(String autor, int numeroPaginas,String isbn, String tema){
        super(autor, numeroPaginas, isbn);
        this.tema = tema;
    }
    public String getTema() {
        return tema;
    }
    public void setTema(String tema) {
        this.tema = tema;
    }
    @Override
    public String toString() {
        return "Libro de Ensayo ->" + super.toString() + ", Tema: "
+ tema;
    }
}

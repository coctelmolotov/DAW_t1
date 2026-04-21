public class LibroPoliciaca extends Libro {

    private String trama;
    private String personaje;

    public LibroPoliciaca(String autor, int numeroPaginas, String isbn, String trama, String personaje) {
        super(autor, numeroPaginas, isbn);
        this.trama = trama;
        this.personaje = personaje;
    }

    public String getTrama() {
        return trama;
    }

    public void setTrama(String trama) {
        this.trama = trama;
    }

    public String getPersonaje() {
        return personaje;
    }

    public void setPersonaje(String personaje) {
        this.personaje = personaje;
    }

    @Override
    public String toString() {
        return "Libro Policiaco -> " + super.toString() +
                ", Trama: " + trama +
                ", Personaje: " + personaje;
    }
}

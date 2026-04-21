public class LibroTerror extends Libro {
    private double calificacion;

    public LibroTerror(String autor, int numeroPaginas, String isbn, double calificacion) {
        super(autor, numeroPaginas, isbn);
        this.calificacion = calificacion;
    }

    public double getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(double calificacion) {
        this.calificacion = calificacion;
    }

    @Override
    public String toString() {
        return "Libro de Terror -> " + super.toString() +
                ", Calificación: " + calificacion;
    }
}

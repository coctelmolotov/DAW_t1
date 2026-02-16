public class Coche {
    private String marca;
    private String modelo;
    private int cv;
    private int cc;
    private String matricula;
    private double velocidad;      // km/h
    private double kmRecorridos;   // km

    public Coche(String marca, String modelo, int cv, int cc, String matricula) {
        this.marca = marca;
        this.modelo = modelo;
        this.cv = cv;
        this.cc = cc;
        this.matricula = matricula;
        this.velocidad = 0;
        this.kmRecorridos = 0;
    }

    public void acelerar(double velocidadIndicada) {
        // Un coche deberá acelerar como mínimo 10km/h
        if (velocidadIndicada < 10) {
            velocidadIndicada = 10;
        }

        double incremento;

        if (cv < 100) {
            // Aleatorio entre 0 y velocidadIndicada
            incremento = Math.random() * velocidadIndicada;
        } else {
            // Aleatorio entre 10 y velocidadIndicada
            // (si velocidadIndicada == 10, incremento será 10)
            incremento = 10 + Math.random() * (velocidadIndicada - 10);
        }

        // Aumenta velocidad
        velocidad += incremento;

        // Aumenta km en el 50% del incremento
        kmRecorridos += incremento * 0.5;
    }

    public void mostrarDatos() {
        System.out.println("---- DATOS COCHE ----");
        System.out.println("Marca: " + marca);
        System.out.println("Modelo: " + modelo);
        System.out.println("CV: " + cv);
        System.out.println("CC: " + cc);
        System.out.println("Matrícula: " + matricula);
        System.out.printf("Velocidad: %.2f km/h%n", velocidad);
        System.out.printf("KM recorridos: %.2f km%n", kmRecorridos);
        System.out.println("---------------------");
    }

    public String getMatricula() { return matricula; }
    public double getKmRecorridos() { return kmRecorridos; }
}
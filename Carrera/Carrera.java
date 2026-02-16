public class Carrera {
    private Coche participante1;
    private Coche participante2;
    private Coche ganador; // inicialmente null

    private double kmTotales;
    private int numeroVueltas;

    public Carrera(double kmTotales, int numeroVueltas) {
        this.kmTotales = kmTotales;
        this.numeroVueltas = numeroVueltas;
        this.ganador = null;
    }

    public void setParticipante1(Coche participante1) {
        this.participante1 = participante1;
    }

    public void setParticipante2(Coche participante2) {
        this.participante2 = participante2;
    }

    public void iniciarCarrera() {
        if (participante1 == null || participante2 == null) {
            System.out.println("Error: faltan participantes en la carrera.");
            return;
        }

        System.out.println("=== INICIO CARRERA ===");
        System.out.println("Participante 1:");
        participante1.mostrarDatos();
        System.out.println("Participante 2:");
        participante2.mostrarDatos();

        int vueltasDadas = 0;

        while (ganador == null) {

            int vueltasEnEsteBloque;

            if (vueltasDadas == 0) {
                vueltasEnEsteBloque = numeroVueltas;
            } else {
                vueltasEnEsteBloque = 1;
            }

            for (int i = 0; i < vueltasEnEsteBloque; i++) {
                vueltasDadas++;

                participante1.acelerar(30);
                participante2.acelerar(30);

                if (participante1.getKmRecorridos() >= kmTotales
                        || participante2.getKmRecorridos() >= kmTotales) {
                    break;
                }
            }


            if (participante1.getKmRecorridos() >= kmTotales
                    || participante2.getKmRecorridos() >= kmTotales) {

                if (participante1.getKmRecorridos() > participante2.getKmRecorridos()) {
                    ganador = participante1;

                } else if (participante2.getKmRecorridos() > participante1.getKmRecorridos()) {
                    ganador = participante2;

                } else {

                    if (Math.random() < 0.5) {
                        ganador = participante1;
                    } else {
                        ganador = participante2;
                    }
                    System.out.println("¡Empate! El ganador se ha decidido aleatoriamente.");
                }


            }
        }

        System.out.println("=== FIN CARRERA ===");
        System.out.println("Vueltas dadas: " + vueltasDadas);
        System.out.println("Resultado final:");
        participante1.mostrarDatos();
        participante2.mostrarDatos();

        System.out.println("El ganador ha sido el coche con matrícula " + ganador.getMatricula());
    }
}
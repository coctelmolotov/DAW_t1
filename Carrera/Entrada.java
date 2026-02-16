import java.util.Scanner;

public class Entrada {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Introduce los km totales de la carrera: ");
        double kmTotales = scanner.nextDouble();

        System.out.print("Introduce el número de vueltas iniciales: ");
        int numeroVueltas = scanner.nextInt();


        Coche coche1 = new Coche("Volkswagen", "Golf", 110, 1200, "1234-ABC");
        Coche coche2 = new Coche("MG", "ZS", 111, 1100, "5678-DEF");


        Carrera carrera = new Carrera(kmTotales, numeroVueltas);


        carrera.setParticipante1(coche1);
        carrera.setParticipante2(coche2);


        carrera.iniciarCarrera();

        scanner.close();
    }
}
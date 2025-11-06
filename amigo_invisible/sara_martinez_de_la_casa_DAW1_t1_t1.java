import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); //utilizamos scanner que permite leer desde el teclado

        System.out.println("¿Cuántos amigos entran en el juego?");
        int numeroParticipantes = scanner.nextInt(); //variable para guardar el numero de participantes
        scanner.nextLine(); // salto de linea

        ArrayList<String> nombres = new ArrayList<>(); //array para guardar los nombre

        int i = 0;

        while (i < numeroParticipantes) {
            System.out.println("Introduce el nombre del amigo " + (i + 1) + ":");
            String nombre = scanner.nextLine();

            if (nombres.contains(nombre)) { //comprobramos si el nombre introducido ya esta en la lista
                System.out.println("Ese nombre ya ha sido introducido. Prueba con otro.");
            } else {
                nombres.add(nombre);
                i++; // Solo sumamos si el nombre no está repetido
            }
        }
        ArrayList<String> copiaMezclada = new ArrayList<>(nombres);
        boolean valido = false; //usamos esta bandera hasta que las parejas cumplan los requisitos
//cuando la combinacion es valida, pasamos al siguiente bucle
        while (!valido) {
            for (int x = copiaMezclada.size() - 1; x > 0; x--) {
                int indiceAleatorio = (int)(Math.random() * (x + 1));
                String temp = copiaMezclada.get(x);
                copiaMezclada.set(x, copiaMezclada.get(indiceAleatorio));
                copiaMezclada.set(indiceAleatorio, temp);
            }
            valido = true;

            for (int z = 0; z < nombres.size(); z++) {
                if (nombres.get(z).equals(copiaMezclada.get(z))) {
                    valido = false; // alguien se ha tocado a sí mismo
                    break;
                }
            }
        }
        System.out.println("\nLas parejas del amigo invisible son:");
        for (int j = 0; j < nombres.size(); j++) {
            System.out.println(nombres.get(j) + " -> " + copiaMezclada.get(j));
        }



    }
}


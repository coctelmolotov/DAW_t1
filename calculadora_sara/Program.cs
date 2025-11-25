using System;

class Calculadora
{
    static void Main(string[] args)
    {
        // Declaramos dos variables para guardar los números introducidos por el usuario
        double numero1, numero2;

        // Bucle para pedir dos números positivos al usuario
        do
        {
            Console.Write("Introduce el primer número: ");
            numero1 = Convert.ToDouble(Console.ReadLine());

            Console.Write("Introduce el segundo número: ");
            numero2 = Convert.ToDouble(Console.ReadLine());

            if (numero1 < 0 || numero2 < 0)
            {
                Console.WriteLine("Ambos números deben ser positivos. Inténtalo de nuevo.");
            }

        } while (numero1 < 0 || numero2 < 0);

        // Bucle que muestra el menú de operaciones hasta que el usuario elija salir
        bool continuar = true;

        while (continuar)
        {
            Console.WriteLine("\n--- MENÚ DE OPERACIONES ---");
            Console.WriteLine("1. Sumar");
            Console.WriteLine("2. Restar");
            Console.WriteLine("3. Multiplicar");
            Console.WriteLine("4. Dividir");
            Console.WriteLine("5. Salir");
            Console.Write("Elige una opción (1-5): ");

            string opcion = Console.ReadLine()!;

            switch (opcion)
            {
                // Caso para sumar los dos números
                case "1":
                    Console.WriteLine($"Resultado: {numero1} + {numero2} = {numero1 + numero2}");
                    break;
                // Caso para restar los dos números
                case "2":
                    Console.WriteLine($"Resultado: {numero1} - {numero2} = {numero1 - numero2}");
                    break;
                // Caso para multiplicar los dos números
                case "3":
                    Console.WriteLine($"Resultado: {numero1} * {numero2} = {numero1 * numero2}");
                    break;
                // Caso para dividir los dos números
                case "4":
                    if (numero2 != 0)
                        Console.WriteLine($"Resultado: {numero1} / {numero2} = {numero1 / numero2}");
                    else
                        Console.WriteLine("Error: División por cero.");
                    break;
                // Caso para salir del programa
                case "5":
                    continuar = false;
                    Console.WriteLine("Saliendo del programa...");
                    break;
                default:
                    Console.WriteLine("Opción no válida. Elige entre 1 y 5.");
                    break;
            }
        }
        // Fin del programa
    }
}
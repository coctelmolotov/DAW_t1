using System;
using System.Collections.Generic;

namespace RunningApp
{
    class Program
    {
        static List<Usuario> usuarios = new List<Usuario>();
        static Usuario? usuarioLogeado = null;
        static void Main(string[] args)
        {
            while (true)
            {
                Console.WriteLine("--- Menú ---");
                Console.WriteLine("1. Registrar usuario");
                Console.WriteLine("2. Login");
                Console.WriteLine("3. Salir");
                Console.Write("Elige una opción: ");
                string option = Console.ReadLine() ?? "";
                Console.WriteLine();
                switch (option)
                {
                    case "1":
                        RegistrarUsuario();
                        break;
                    case "2":
                        Login();
                        break;
                    case "3":
                        return;
                    default:
                        Console.WriteLine("Opcion no valida.");
                        break;
                }
                Console.WriteLine();
            }
        }
        static string LeerPasswordOculta() // metodo para ocultar el password cada vez que lo intrduzcamos
        {
            string password = "";
            ConsoleKeyInfo key;

            do
            {
                key = Console.ReadKey(true);

                if (key.Key != ConsoleKey.Backspace && key.Key != ConsoleKey.Enter)
                {
                    password += key.KeyChar;
                    Console.Write("*");
                }
                else if (key.Key == ConsoleKey.Backspace && password.Length > 0)
                {
                    password = password.Substring(0, password.Length - 1);
                    Console.Write("\b \b");
                }
            }
            while (key.Key != ConsoleKey.Enter);

            Console.WriteLine();
            return password;
        }

        static void RegistrarUsuario() //metodo para registrar el usuario
        {
            Console.Write("Email: ");
            string email = Console.ReadLine() ?? "";

            Console.Write("Password: ");
            string password = LeerPasswordOculta();

            // No permitir duplicados por email
            foreach (Usuario u in usuarios)
            {
                if (u.Email == email)
                {
                    Console.WriteLine("Ese usuario ya existe.");
                    return;
                }
            }

            Usuario nuevoUsuario = new Usuario(email, password);
            usuarios.Add(nuevoUsuario);

            Console.WriteLine("Usuario registrado correctamente.");
        }
        static void Login() // metodo para loguear el usuario
        {
            Console.Write("Email: ");
            string email = Console.ReadLine() ?? "";

            Console.Write("Password: ");
            string password = LeerPasswordOculta();

            for (int i = 0; i < usuarios.Count; i++)
            {
                if (usuarios[i].Email == email && usuarios[i].Password == password)
                {
                    usuarioLogeado = usuarios[i];
                    Console.WriteLine("Login correcto.");
                    Console.WriteLine();
                    MenuEntrenamientos();
                    return;
                }
            }

            Console.WriteLine("Credenciales incorrectas.");
        }

        static void MenuEntrenamientos() // metodo para desplegar nuestro menu de entrenamientos y elegir lo que deseamos hacer
        {
            while (usuarioLogeado != null)
            {
                Console.WriteLine("--- Menú de entrenamientos ---");
                Console.WriteLine("1. Registrar entrenamiento");
                Console.WriteLine("2. Listar entrenamientos");
                Console.WriteLine("3. Vaciar entrenamientos");
                Console.WriteLine("4. Cerrar sesión");
                Console.Write("Elige una opción: ");

                string opcion = Console.ReadLine() ?? "";
                Console.WriteLine();

                switch (opcion)
                {
                    case "1":
                        RegistrarEntrenamiento();
                        break;
                    case "2":
                        ListarEntrenamientos();
                        break;
                    case "3":
                        VaciarEntrenamientos();
                        break;
                    case "4":
                        usuarioLogeado = null;
                        Console.WriteLine("Sesión cerrada.");
                        return;
                    default:
                        Console.WriteLine("Opción no válida.");
                        break;
                }

                Console.WriteLine();
            }
        }
        static void RegistrarEntrenamiento() // metodo para introducir nuestros entrenamientos
        {
            if (usuarioLogeado == null) return;

            double distancia;
            while (true)
            {
                Console.Write("Distancia (km): ");
                string entrada = Console.ReadLine() ?? "";
                if (double.TryParse(entrada, out distancia) && distancia > 0)
                    break;
                Console.WriteLine("Distancia no válida. Introduce un número mayor que 0.");
            }

            double tiempo;
            while (true)
            {
                Console.Write("Tiempo (min): ");
                string entrada = Console.ReadLine() ?? "";
                if (double.TryParse(entrada, out tiempo) && tiempo > 0)
                    break;
                Console.WriteLine("Tiempo no válido. Introduce un número mayor que 0.");
            }

            usuarioLogeado.Entrenamientos.Add(new Entrenamiento(distancia, tiempo));
            Console.WriteLine("Entrenamiento registrado correctamente.");
        }

        static void ListarEntrenamientos() // metodo para desplegar nuestro listado de entrenamuentos
        {
            if (usuarioLogeado == null) return;

            if (usuarioLogeado.Entrenamientos.Count == 0)
            {
                Console.WriteLine("No hay entrenamientos registrados.");
                return;
            }

            Console.WriteLine("--- Tus entrenamientos ---");
            for (int i = 0; i < usuarioLogeado.Entrenamientos.Count; i++)
            {
                Console.WriteLine($"{i + 1}. {usuarioLogeado.Entrenamientos[i]}");
            }
        }

        static void VaciarEntrenamientos()
        {
            if (usuarioLogeado == null) return;

            if (usuarioLogeado.Entrenamientos.Count == 0)
            {
                Console.WriteLine("No hay entrenamientos que borrar.");
                return;
            }

            Console.Write("¿Seguro que quieres borrar todos los entrenamientos? (s/n): ");
            string confirmacion = Console.ReadLine() ?? "";

            if (confirmacion.ToLower() == "s")
            {
                usuarioLogeado.Entrenamientos.Clear();
                Console.WriteLine("Entrenamientos eliminados.");
            }
            else
            {
                Console.WriteLine("Operación cancelada.");
            }
        }
    }
}

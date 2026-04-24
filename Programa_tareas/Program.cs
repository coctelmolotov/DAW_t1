using System;
using System.Collections.Generic;
using System.IO;

class Program
{
    static List<Tarea> listaTareas = new List<Tarea>();
    static int contadorId = 1;

    static void Main(string[] args)
    {
        int opcion;

        do
        {
            Console.WriteLine("\n--- MENÚ ---");
            Console.WriteLine("1. Crear tarea");
            Console.WriteLine("2. Buscar por tipo");
            Console.WriteLine("3. Eliminar tarea");
            Console.WriteLine("4. Exportar tareas");
            Console.WriteLine("5. Importar tareas");
            Console.WriteLine("6. Salir");

            Console.Write("Elige una opción: ");
            opcion = int.Parse(Console.ReadLine());

            switch (opcion)
            {
                case 1:
                    CrearTarea();
                    break;
                case 2:
                    BuscarPorTipo();
                    break;
                case 3:
                    EliminarTarea();
                    break;
                case 4:
                    ExportarTareas();
                    break;
                case 5:
                    ImportarTareas();
                    break;
                case 6:
                    Console.WriteLine("Saliendo del programa...");
                    break;
                default:
                    Console.WriteLine("Opción no válida");
                    break;
            }

        } while (opcion != 6);
    }
    static void CrearTarea()
    {
        Console.Write("Nombre: ");
        string nombre = Console.ReadLine();

        Console.Write("Descripción: ");
        string descripcion = Console.ReadLine();

        Console.Write("Tipo (Persona, Trabajo, Ocio): ");
        TipoTarea tipo = (TipoTarea)Enum.Parse(typeof(TipoTarea), Console.ReadLine(), true);

        Console.Write("Prioridad (true/false): ");
        bool prioridad = bool.Parse(Console.ReadLine());

        Tarea nueva = new Tarea(contadorId, nombre, descripcion, tipo, prioridad);
        listaTareas.Add(nueva);

        contadorId++;

        Console.WriteLine("Tarea creada correctamente");
    }
    static void BuscarPorTipo()
    {
        Console.Write("Introduce tipo (Persona, Trabajo, Ocio): ");
        TipoTarea tipo = (TipoTarea)Enum.Parse(typeof(TipoTarea), Console.ReadLine(), true);

        foreach (Tarea t in listaTareas)
        {
            if (t.Tipo == tipo)
            {
                Console.WriteLine(t);
            }
        }
    }
    static void EliminarTarea()
    {
        Console.Write("Introduce ID a eliminar: ");
        int id = int.Parse(Console.ReadLine());

        Tarea tareaEliminar = null;

        foreach (Tarea t in listaTareas)
        {
            if (t.Id == id)
            {
                tareaEliminar = t;
                break;
            }
        }

        if (tareaEliminar != null)
        {
            listaTareas.Remove(tareaEliminar);
            Console.WriteLine("Tarea eliminada");
        }
        else
        {
            Console.WriteLine("No encontrada");
        }
    }
    static void ExportarTareas()
    {
        using (StreamWriter sw = new StreamWriter("tareas.txt"))
        {
            foreach (Tarea t in listaTareas)
            {
                sw.WriteLine($"{t.Id};{t.Nombre};{t.Descripcion};{t.Tipo};{t.Prioridad}");
            }
        }

        Console.WriteLine("Tareas exportadas correctamente");
    }
    static void ImportarTareas()
    {
        if (File.Exists("tareas.txt"))
        {
            listaTareas.Clear();
            string[] lineas = File.ReadAllLines("tareas.txt");

            foreach (string linea in lineas)
            {
                string[] partes = linea.Split(';');

                int id = int.Parse(partes[0]);
                string nombre = partes[1];
                string descripcion = partes[2];
                TipoTarea tipo = (TipoTarea)Enum.Parse(typeof(TipoTarea), partes[3]);
                bool prioridad = bool.Parse(partes[4]);

                Tarea t = new Tarea(id, nombre, descripcion, tipo, prioridad);
                listaTareas.Add(t);

                if (id >= contadorId)
                {
                    contadorId = id + 1;
                }
            }

            Console.WriteLine("Tareas importadas correctamente");
        }
        else
        {
            Console.WriteLine("No existe el fichero");
        }
    }
}
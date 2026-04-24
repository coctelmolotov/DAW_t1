public class Tarea
{
    public int Id { get; set; }
    public string Nombre { get; set; }
    public string Descripcion { get; set; }
    public TipoTarea Tipo { get; set; }
    public bool Prioridad { get; set; }

    public Tarea(int id, string nombre, string descripcion, TipoTarea tipo, bool prioridad)
    {
        Id = id;
        Nombre = nombre;
        Descripcion = descripcion;
        Tipo = tipo;
        Prioridad = prioridad;
    }

    public override string ToString()
    {
        return $"ID: {Id} | Nombre: {Nombre} | Descripción: {Descripcion} | Tipo: {Tipo} | Prioridad: {Prioridad}";
    }
}
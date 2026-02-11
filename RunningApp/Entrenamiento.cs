namespace RunningApp
{
    public class Entrenamiento
    {
        public double Distancia { get; set; }
        public double Tiempo { get; set; }

        public Entrenamiento(double distancia, double tiempo)
        {
            Distancia = distancia;
            Tiempo = tiempo;
        }

        public override string ToString()
        {
            return $"Distancia: {Distancia} km - Tiempo: {Tiempo} min";
        }
    }
}
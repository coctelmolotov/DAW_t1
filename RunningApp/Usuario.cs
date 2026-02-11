using System.Collections.Generic;

namespace RunningApp
{
    public class Usuario
    {
        public string Email { get; set; }
        public string Password { get; set; }
        public List<Entrenamiento> Entrenamientos { get; set; }

        public Usuario(string email, string password)
        {
            Email = email;
            Password = password;
            Entrenamientos = new List<Entrenamiento>();
        }
    }
}
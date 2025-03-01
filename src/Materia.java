public class Materia {
    // Atributos de la clase Materia

    private String nombre;
    private Profesor profesor;
    private Salon salon;
    // Constructor de la clase Materia

    public Materia(String nombre, Profesor profesor, Salon salon) {
        this.nombre = nombre;
        this.profesor = profesor;
        this.salon = salon;
    }
    // Getters y setters para los atributos de la clase Materia

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    public Salon getSalon() {
        return salon;
    }

    public void setSalon(Salon salon) {
        this.salon = salon;
    }
}
public class Salon {
    // Atributos de la clase 

    private String nombre;
    private String edificio;

    public Salon(String nombre, String edificio) {
        this.nombre = nombre;
        this.edificio = edificio;
    }
// Getters y setters 
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEdificio() {
        return edificio;
    }

    public void setEdificio(String edificio) {
        this.edificio = edificio;
    }
}
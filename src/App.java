import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

    public static void main(String[] args) throws Exception {
        List<Profesor> profesores = new ArrayList<>();
        List<Salon> salones = new ArrayList<>();
        List<Materia> materias = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("-----Menu------");
            System.out.println("1) Agregar un profesor");
            System.out.println("2) Agregar un salon");
            System.out.println("3) Agregar una materia");
            System.out.println("4) Mostrar materias registradas");
            System.out.println("5) Salir");
            System.out.println("Ingresa una opción");

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    agregarProfesor(scanner, profesores);
                    break;
                case 2:
                    agregarSalon(scanner, salones);
                    break;
                case 3:
                    agregarMateria(scanner, materias, profesores, salones);
                    break;
                case 4:
                    mostrarMaterias(materias); // Método agregado
                    break;
                case 5:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 5);

        scanner.close();
    }

    private static void agregarProfesor(Scanner scanner, List<Profesor> profesores) {
        String nombre;
        do {
            System.out.println("Ingresa el nombre del profesor (solo letras):");
            nombre = scanner.nextLine();
            if (!nombre.matches("[a-zA-Z]+")) {
                System.out.println("Error: El nombre debe contener solo letras.");
            }
        } while (!nombre.matches("[a-zA-Z]+"));

        System.out.println("Ingresa la clave del profesor:");
        String clave = scanner.nextLine();
        System.out.println("Ingresa la edad del profesor:");
        int edad = scanner.nextInt();
        scanner.nextLine();

        profesores.add(new Profesor(nombre, edad, clave));
        System.out.println("Profesor agregado correctamente.");
    }

    private static void agregarSalon(Scanner scanner, List<Salon> salones) {
        System.out.println("Ingresa el nombre del salón:");
        String nombre = scanner.nextLine();
        System.out.println("Ingresa el edificio del salón:");
        String edificio = scanner.nextLine();

        salones.add(new Salon(nombre, edificio));
        System.out.println("Salón agregado correctamente.");
    }

    private static void agregarMateria(Scanner scanner, List<Materia> materias, List<Profesor> profesores, List<Salon> salones) {
        if (profesores.isEmpty() || salones.isEmpty()) {
            System.out.println("Error: No hay profesores o salones registrados.");
            return;
        }

        String nombreMateria;
        boolean nombreRepetido;
        do {
            System.out.println("Ingresa el nombre de la materia (más de 4 letras, no solo números):");
            nombreMateria = scanner.nextLine();
            if (nombreMateria.length() <= 4 || nombreMateria.matches("[0-9]+")) {
                System.out.println("Error: El nombre de la materia debe tener más de 4 letras y no puede ser solo números.");
            }
            nombreRepetido = materiaRepetida(nombreMateria, materias);
            if (nombreRepetido) {
                System.out.println("Error: El nombre de la materia ya existe. Ingresa otro nombre.");
            }
        } while (nombreMateria.length() <= 4 || nombreMateria.matches("[0-9]+") || nombreRepetido);

        System.out.println("Selecciona el profesor:");
        for (int i = 0; i < profesores.size(); i++) {
            System.out.println((i + 1) + ". " + profesores.get(i).getNombre());
        }
        int profesorIndex = scanner.nextInt() - 1;
        scanner.nextLine();
        Profesor profesor = profesores.get(profesorIndex);

        if (profesorOcupado(profesor, materias)) {
            System.out.println("Error: El profesor ya tiene una clase asignada. Debe asignar a otro disponible.");
            return;
        }

        System.out.println("Selecciona el salón:");
        for (int i = 0; i < salones.size(); i++) {
            System.out.println((i + 1) + ". " + salones.get(i).getNombre());
        }
        int salonIndex = scanner.nextInt() - 1;
        scanner.nextLine();
        Salon salon = salones.get(salonIndex);

        if (salonOcupado(salon, materias)) {
            System.out.println("Error: El salón ya está asignado. Busca otro salón disponible.");
            return;
        }

        materias.add(new Materia(nombreMateria, profesor, salon));
        System.out.println("Materia agregada correctamente.");
    }

    private static boolean profesorOcupado(Profesor profesor, List<Materia> materias) {
        for (Materia materia : materias) {
            if (materia.getProfesor().equals(profesor)) {
                return true;
            }
        }
        return false;
    }

    private static boolean salonOcupado(Salon salon, List<Materia> materias) {
        for (Materia materia : materias) {
            if (materia.getSalon().equals(salon)) {
                return true;
            }
        }
        return false;
    }

    private static boolean materiaRepetida(String nombreMateria, List<Materia> materias) {
        for (Materia materia : materias) {
            if (materia.getNombre().equals(nombreMateria)) {
                return true;
            }
        }
        return false; // Se agregó esta línea para que siempre devuelva un valor booleano
    }

    private static void mostrarMaterias(List<Materia> materias) {
        if (materias.isEmpty()) {
            System.out.println("No hay materias registradas.");
        } else {
            System.out.println("Materias registradas:");
            for (Materia materia : materias) {
                System.out.println("Materia: " + materia.getNombre() + " | Profesor: " + materia.getProfesor().getNombre() + " | Salón: " + materia.getSalon().getNombre());
            }
        }
    }
}
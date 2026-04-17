import java.util.Scanner;
import servicio.GestorTareas;

public class Main {

    static GestorTareas gestor = new GestorTareas();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int opcion;

        do {
            mostrarMenu();
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1: agregar(); break;
                case 2: gestor.listar(); break;
                case 3: gestor.listarPendientes(); break;
                case 4: gestor.listarCompletadas(); break;
                case 5: completar(); break;
                case 6: eliminar(); break;
                case 7: estadisticas(); break;
                case 8: System.out.println("Saliendo..."); break;
                default: System.out.println("Opción no válida.");
            }
        } while (opcion != 8);
    }

    static void mostrarMenu() {
        System.out.println("=== Gestor de Tareas ===");
        System.out.println("1. Agregar tarea");
        System.out.println("2. Listar todas las tareas");
        System.out.println("3. Listar tareas pendientes");
        System.out.println("4. Listar tareas completadas");
        System.out.println("5. Completar tarea");
        System.out.println("6. Eliminar tarea");
        System.out.println("7. Estadísticas");
        System.out.println("8. Salir");
        System.out.print("Seleccione una opción: ");
    }

    static void agregar() {
        System.out.print("Titulo: ");
        String titulo = sc.nextLine();
        System.out.print("Descripcion: ");
        String descripcion = sc.nextLine();
        gestor.agregar(titulo, descripcion);
    }

    static void completar() {
        System.out.print("ID de la tarea a completar: ");
        int id = sc.nextInt();
        gestor.completar(id);
    }

    static void eliminar() {
        System.out.print("ID de la tarea a eliminar: ");
        int id = sc.nextInt();
        gestor.eliminar(id);
    }

    static void estadisticas() {
        int total = gestor.totalTareas();
        int completadas = gestor.tareasCompletadas();
        int pendientes = gestor.tareasPendientes();

        System.out.println("=== Estadísticas ===");
        System.out.println("Total de tareas: " + total);
        System.out.println("Tareas completadas: " + completadas);
        System.out.println("Tareas pendientes: " + pendientes);

        if (total > 0) {
            double porcentaje = (completadas * 100.0) / total;
            System.out.printf("Porcentaje completadas: %.2f%%\n", porcentaje);
        }
    }
}
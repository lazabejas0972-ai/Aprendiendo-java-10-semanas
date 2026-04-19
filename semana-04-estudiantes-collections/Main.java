import java.util.Scanner;
import modelo.*;
import servicio.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        GestorEstudiantes gestor = new GestorEstudiantes();

        cargarDatosPrueba(gestor);
        int opcion;
        do{
            System.out.println("\n=== GESTOR DE ESTUDIANTES ===");
            System.out.println("1. Agregar estudiante");
            System.out.println("2. Buscar estudiante por carnet");
            System.out.println("3. Actualizar promedio");
            System.out.println("4. Eliminar estudiante");
            System.out.println("5. Mostrar ranking completo");
            System.out.println("6. Mostrar top 5 estudiantes");
            System.out.println("7. Filtrar por carrera");
            System.out.println("8. Estadisticas");
            System.out.println("9. Historial");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();
            sc.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    agregarEstudiante(sc, gestor);
                    break;
                case 2:
                    buscarEstudiante(sc, gestor);
                    break;
                case 3:
                    actualizarPromedio(sc, gestor);
                    break;
                case 4:
                    eliminarEstudiante(sc, gestor);
                    break;
                case 5:
                    gestor.mostrarRanking();
                    break;
                case 6:
                    gestor.mostrarTop5();
                    break;
                case 7:
                    System.out.print("Carrera: ");
                    gestor.filtrarPorCarrera(sc.nextLine());
                    break;
                case 8:
                    gestor.mostrarEstadisticas();
                    break;
                case 9:
                    gestor.mostrarHistorial();
                    break;
                case 0:
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        }while(opcion != 0);
        sc.close();
    }

    private static void agregarEstudiante(Scanner sc, GestorEstudiantes gestor){
        System.out.print("Carnet: ");
        String carnet = sc.nextLine();
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Carrera: ");
        String carrera = sc.nextLine();
        System.out.print("Promedio: ");
        double promedio = sc.nextDouble();
        sc.nextLine();

        boolean ok = gestor.agregar(new Estudiante(carnet, nombre, carrera, promedio));
        System.out.println(ok ? " Estudiante registrado." : "Error: carnet ya existente.");
    }

    private static void buscarEstudiante(Scanner sc, GestorEstudiantes gestor){
        System.out.print("Carnet: ");
        String carnet = sc.nextLine();
        Estudiante e = gestor.buscar(carnet);
        if(e != null){
            System.out.println("Estudiante encontrado:");
            System.out.println(e);
        }else{
            System.out.println("Estudiante no encontrado.");
        }
    }

    private static void actualizarPromedio(Scanner sc, GestorEstudiantes gestor){
        System.out.print("Carnet: ");
        String carnet = sc.nextLine();
        System.out.print("Nuevo promedio: ");
        double nuevoPromedio = sc.nextDouble();
        sc.nextLine();

        boolean ok = gestor.actualizarPromedio(carnet, nuevoPromedio);
        System.out.println(ok ? " Promedio actualizado." : "Error: estudiante no encontrado.");
    }

    private static void eliminarEstudiante(Scanner sc, GestorEstudiantes gestor){
        System.out.print("Carnet: ");
        String carnet = sc.nextLine();
        boolean ok = gestor.eliminar(carnet);
        System.out.println(ok ? " Estudiante eliminado." : "Error: estudiante no encontrado.");
    }

    private static void cargarDatosPrueba(GestorEstudiantes gestor){
        gestor.agregar(new Estudiante("20210001", "Ana Gómez", "Ingeniería en Sistemas", 85.5));
        gestor.agregar(new Estudiante("20210002", "Luis Pérez", "Derecho", 78.0));
        gestor.agregar(new Estudiante("20210003", "María Rodríguez", "Medicina", 92.3));
        gestor.agregar(new Estudiante("20210004", "Carlos Sánchez", "Arquitectura", 88.7));
        gestor.agregar(new Estudiante("20210005", "Sofía Martínez", "Psicología", 80.2));
    }
}
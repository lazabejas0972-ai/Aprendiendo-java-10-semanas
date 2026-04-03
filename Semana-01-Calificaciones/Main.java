import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static String[] nombres = new String[5];
    static double[] promedio = new double[5];
    static int TotalEstudiantes = 0;

    public static void main(String[] args) {
        int opcion;
        do {
            verMenu();
            opcion = leerEntero("Opcion: ");
            switch (opcion) {
                case 1: agregarEstudiante(); break;
                case 2: mostrarResultados(); break;
                case 3: promedioGeneral(); break;
                case 4: notaMasAltayBaja(); break;
                case 5: contarAprobadosYReprobados(); break;
                case 6: System.out.println("Saliendo del programa..."); break;
                default: System.out.println("Opcion no valida."); break;
            }
        } while (opcion != 6);
    }

    public static void verMenu() {
        System.out.println("\n====MENU====");
        System.out.println("1. Agregar Estudiantes");
        System.out.println("2. Mostrar Resultados");
        System.out.println("3. Promedio General");
        System.out.println("4. Nota Mas Alta y Baja");
        System.out.println("5. Aprobados y Reprobados");
        System.out.println("6. Salir");
    }

    public static void agregarEstudiante() {
        if (TotalEstudiantes >= nombres.length) {
            System.out.println("Limite alcanzado.");
            return;
        }

        sc.nextLine();
        System.out.print("Nombre: ");
        nombres[TotalEstudiantes] = sc.nextLine();

        double[] notas = new double[3];
        for (int i = 0; i < 3; i++) {
            notas[i] = leerNota("Nota " + (i + 1) + ": ");
        }

        promedio[TotalEstudiantes] = calcpromedio(notas);
        TotalEstudiantes++;

        System.out.println("Estudiante agregado.");
    }

    public static void mostrarResultados() {
        if (TotalEstudiantes == 0) {
            System.out.println("No hay datos.");
            return;
        }

        for (int i = 0; i < TotalEstudiantes; i++) {
            String estado = estaAprobado(promedio[i]) ? "Aprobado" : "Reprobado";
            System.out.println(nombres[i] + " - " + promedio[i] + " - " + estado);
        }
    }

    public static void promedioGeneral() {
        if (TotalEstudiantes == 0) {
            System.out.println("No hay datos.");
            return;
        }

        double suma = 0;

        for (int i = 0; i < TotalEstudiantes; i++) {
            suma += promedio[i];
        }

        double promGen = suma / TotalEstudiantes;
        System.out.println("Promedio General: " + promGen);
    }

    public static void notaMasAltayBaja() {
        if (TotalEstudiantes == 0) {
            System.out.println("No hay datos.");
            return;
        }

        double max = promedio[0], min = promedio[0];

        for (int i = 0; i < TotalEstudiantes; i++) {
            if (promedio[i] > max) max = promedio[i];
            if (promedio[i] < min) min = promedio[i];
        }

        System.out.println("Nota mas alta: " + max);
        System.out.println("Nota mas baja: " + min);
    }

    public static void contarAprobadosYReprobados() {
        if (TotalEstudiantes == 0) {
            System.out.println("No hay datos.");
            return;
        }

        System.out.printf("%-15s %8s %12s%n", "NOMBRE", "PROMEDIO", "ESTADO");
        System.out.println("-------------------------------------");

        for (int i = 0; i < TotalEstudiantes; i++) {
            String estado = estaAprobado(promedio[i]) ? "APROBADO" : "REPROBADO";
            System.out.printf("%-15s %8.2f %12s%n", nombres[i], promedio[i], estado);
        }
    }

    public static double calcpromedio(double[] notas) {
        double suma = 0;
        for (double n : notas) suma += n;
        return suma / notas.length;
    }

    public static boolean estaAprobado(double promedio) {
        return promedio >= 51;
    }

    public static double leerNota(String mensaje) {
        double nota;
        do {
            nota = leerDouble(mensaje);
            if (nota < 0 || nota > 100) {
                System.out.println("Nota invalida.");
            }
        } while (nota < 0 || nota > 100);
        return nota;
    }

    public static int leerEntero(String mensaje) {
    while (true) {
        try {
            System.out.print(mensaje);
            return Integer.parseInt(sc.nextLine());
        } catch (Exception e) {
            System.out.println("Ingrese numero valido.");
        }
    }
    }

    public static double leerDouble(String mensaje) {
    while (true) {
        try {
            System.out.print(mensaje);
            return Double.parseDouble(sc.nextLine());
        } catch (Exception e) {
            System.out.println("Ingrese numero valido.");
        }
    }
    }
}
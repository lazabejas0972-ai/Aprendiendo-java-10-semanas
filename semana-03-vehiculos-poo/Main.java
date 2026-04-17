import java.util.ArrayList;
import java.util.Scanner;
import modelo.*;
import servicio.*;

public class Main {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        GestorVehiculos gestor = new GestorVehiculos();

        ArrayList<Vehiculo> flota = new ArrayList<>();

        flota.add(new Auto("Toyota", "Corolla", 2024, 4));
        flota.add(new Moto("Honda", "CB500", 2023, false));
        flota.add(new Camion("Volvo", "FH16", 2022, 24));
        flota.add(new AutoElectrico("Tesla", "Model 3", 2024, 4, 80));
        flota.add(new MotoElectrica("NIU", "MQi+", 2023, 60));

        System.out.println("=== DEMOSTRACION POLIMORFISMO ===");
        for (Vehiculo v : flota) {
            v.acelerar();
        }

        int opcion;

        do {
            System.out.println("\n=== GESTION DE VEHICULOS ===");
            System.out.println("1. Agregar vehiculo");
            System.out.println("2. Listar todos");
            System.out.println("3. Filtrar por tipo");
            System.out.println("4. Ver electricos y baterias");
            System.out.println("5. Cargar baterias bajas");
            System.out.println("6. Demostrar polimorfismo");
            System.out.println("7. Estadisticas");
            System.out.println("8. Salir");
            System.out.print("Opcion: ");

            opcion = in.nextInt();
            in.nextLine();

            switch (opcion) {

                case 1:
                    System.out.println("1.Auto 2.Moto 3.Camion 4.AutoElectrico 5.MotoElectrica");
                    int tipo = in.nextInt();
                    in.nextLine();

                    System.out.print("Marca: ");
                    String marca = in.nextLine();

                    System.out.print("Modelo: ");
                    String modelo = in.nextLine();

                    System.out.print("Año: ");
                    int anio = in.nextInt();
                    in.nextLine();

                    if (tipo == 1) {
                        System.out.print("Puertas: ");
                        int puertas = in.nextInt();
                        in.nextLine();
                        gestor.agregar(new Auto(marca, modelo, anio, puertas));
                    } else if (tipo == 2) {
                        gestor.agregar(new Moto(marca, modelo, anio, false));
                    } else if (tipo == 3) {
                        System.out.print("Toneladas: ");
                        double ton = in.nextDouble();
                        in.nextLine();
                        gestor.agregar(new Camion(marca, modelo, anio, ton));
                    } else if (tipo == 4) {
                        System.out.print("Puertas: ");
                        int puertas = in.nextInt();
                        in.nextLine();
                        System.out.print("Bateria: ");
                        int bat = in.nextInt();
                        in.nextLine();
                        gestor.agregar(new AutoElectrico(marca, modelo, anio, puertas, bat));
                    } else if (tipo == 5) {
                        System.out.print("Bateria: ");
                        int bat = in.nextInt();
                        in.nextLine();
                        gestor.agregar(new MotoElectrica(marca, modelo, anio, bat));
                    }
                    break;
                case 2:
                    gestor.ListarTodos();
                    break;
                case 3:
                    System.out.print("Tipo (auto/moto/camion/electrico): ");
                    String tipoFiltro = in.nextLine();
                    gestor.listarPorTipo(tipoFiltro);
                    break;
                case 4:
                    gestor.listarElectricos();
                    break;
                case 5:
                    gestor.cargarElectricosNecesarios();
                    break;
                case 6:
                    gestor.demostrarPolimorfismo();
                    break;
                case 7:
                    gestor.mostrarEstadisticas();
                    break;
                case 8:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opcion invalida");
            }
        } while (opcion != 8);
    }
}
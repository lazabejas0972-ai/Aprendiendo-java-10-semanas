package servicio;
import java.util.ArrayList;
import modelo.*;

public class GestorVehiculos {
    private ArrayList<Vehiculo> vehiculos;

    public GestorVehiculos(){
        vehiculos = new ArrayList<>();
    }

    public void agregar(Vehiculo v){
        vehiculos.add(v);
        System.out.println("Agregado: "+v.getInfo());
    }

    public void ListarTodos(){
        System.out.println("\n=== toda la flota ===");
        if(vehiculos.isEmpty()){
            System.out.println("Sin vehiculos");
            return;
        }
        for(Vehiculo v : vehiculos){
            System.out.println(v.getInfo());
        }
    }

    public void listarPorTipo(String tipo) {
        System.out.println("\n=== Tipo: " + tipo + " ===");

        for (Vehiculo v : vehiculos) {

            if (tipo.equalsIgnoreCase("auto") && v instanceof Auto && !(v instanceof AutoElectrico)) {
                System.out.println(v.getInfo());
            }

            if (tipo.equalsIgnoreCase("moto") && v instanceof Moto && !(v instanceof MotoElectrica)) {
                System.out.println(v.getInfo());
            }

            if (tipo.equalsIgnoreCase("camion") && v instanceof Camion) {
                System.out.println(v.getInfo());
            }

            if (tipo.equalsIgnoreCase("electrico") && v instanceof Electrico) {
                System.out.println(v.getInfo());
            }
        }
    }

    public void listarElectricos() {
        System.out.println("\n=== Vehiculos electricos ===");

        boolean hay = false;

        for (Vehiculo v : vehiculos) {
            if (v instanceof Electrico) {
                Electrico e = (Electrico) v;
                System.out.println(v.getInfo() + " | Bateria: " + e.getNivelBateria() + "%");
                hay = true;
            }
        }

        if (!hay) {
            System.out.println("No hay electricos");
        }
    }

    public void cargarElectricosNecesarios() {
        System.out.println("\n=== Verificando baterias ===");

        for (Vehiculo v : vehiculos) {
            if (v instanceof Electrico) {
                Electrico e = (Electrico) v;

                if (e.necesitaCarga()) {
                    System.out.print(v.getInfo() + " -> ");
                    e.cargarBateria();
                }
            }
        }
    }

    public void demostrarPolimorfismo() {
        System.out.println("\n=== Polimorfismo ===");

        for (Vehiculo v : vehiculos) {
            v.acelerar(); // cada uno hace algo distinto
        }
    }

    public void mostrarEstadisticas() {
        int total = vehiculos.size();
        int electricos = 0;
        int necesitan = 0;

        for (Vehiculo v : vehiculos) {
            if (v instanceof Electrico) {
                electricos++;

                if (((Electrico) v).necesitaCarga()) {
                    necesitan++;
                }
            }
        }

        System.out.println("\n=== Estadisticas ===");
        System.out.println("Total vehiculos: " + total);
        System.out.println("Electricos: " + electricos);
        System.out.println("Necesitan carga: " + necesitan);
    }
}
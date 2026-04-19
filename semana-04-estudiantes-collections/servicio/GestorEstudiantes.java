package servicio;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeSet;
import modelo.Estudiante;

public class GestorEstudiantes {

    private HashMap<String, Estudiante> porCarnet;
    private TreeSet<Estudiante> ranking;
    private ArrayList<String> historial;

    public GestorEstudiantes() {
        porCarnet = new HashMap<>();
        ranking = new TreeSet<>();
        historial = new ArrayList<>();
    }

    public boolean agregar(Estudiante e){
        if (porCarnet.containsKey(e.getCarnet())){
            return false;
        }
        porCarnet.put(e.getCarnet(), e);
        ranking.add(e);
        historial.add("AGREGAR: " + e.getCarnet() + " - " + e.getNombre());
        return true;
    }

    public Estudiante buscar(String carnet){
        return porCarnet.get(carnet);
    }

    public boolean actualizarPromedio(String carnet, double nuevoPromedio){
        Estudiante e = porCarnet.get(carnet);
        if(e == null) return false;

        ranking.remove(e);
        e.setPromedio(nuevoPromedio);
        ranking.add(e);

        historial.add("ACTUALIZAR: " + carnet + " | Nuevo promedio: " + nuevoPromedio);
        return true;
    }
    public boolean eliminar(String carnet){
        Estudiante e = porCarnet.remove(carnet);
        if ( e == null){
            return false;
        }
        ranking.remove(e);
        historial.add("ELIMINAR: " + carnet + " - " + e.getNombre());
        return true;
    }

    public void mostrarRanking(){
        System.out.println("\n=== RANKING DE ESTUDIANTES ===");
        int pos = 1;
        for (Estudiante e : ranking) {
            System.out.printf("%3d. %s%n", pos++, e);
        }
    }

    public void mostrarTop5(){
        System.out.println("\n=== TOP 5 ESTUDIANTES ===");
        int count = 0;
        Estudiante[] arr = ranking.toArray(new Estudiante[0]);
        for (int i = arr.length - 1; i >= 0 && count < 5; i--) {
            System.out.printf("%d. %s%n", ++count, arr[i]);
        }
    }

    public void filtrarPorCarrera(String carrera){
        System.out.println("\n=== Carrera: "+ carrera + " ===");
        boolean hayAlguno = false;
        for(Estudiante e : porCarnet.values()){
            if(e.getCarrera().equalsIgnoreCase(carrera)){
                System.out.println(e);
                hayAlguno = true;
            }
        }
        if(!hayAlguno){
            System.out.println("No hay estudiantes registrados en esta carrera.");
        }
    }

    public void mostrarEstadisticas(){
        if(ranking.isEmpty()){
            System.out.println("No hay estudiantes registrados para mostrar estadísticas.");
            return;
        }
        double suma = 0;
        for(Estudiante e : ranking) suma+= e.getPromedio();
        System.out.println("\n=== ESTADÍSTICAS ===");
        System.out.println(" Total     : "+ ranking.size());
        System.out.printf(" Promedio   : %.2f%n", (suma / ranking.size()));
        System.out.println(" Mejor     : "+ ranking.last());
        System.out.println(" Peor      : "+ ranking.first());
    }

    public void mostrarHistorial(){
        System.out.println("\n=== HISTORIAL DE OPERACIONES ===");
        if(historial.isEmpty()){
            System.out.println("No se han realizado operaciones aún.");
            return;
        }
        for(String entrada : historial){
            System.out.println(" "+ entrada);
        }
    }
    public int getTotalEstudiantes() { return porCarnet.size();
    }
}
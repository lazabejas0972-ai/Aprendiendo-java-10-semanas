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
}
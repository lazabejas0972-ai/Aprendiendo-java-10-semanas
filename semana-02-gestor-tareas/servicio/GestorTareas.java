package servicio;
import modelo.Tarea;
import java.util.ArrayList;

public class GestorTareas {

    private ArrayList<Tarea> tareas;
    private int contadorId;

    public semana.GestorTareas() {
        tareas = new ArrayList<>();
        contadorId = 1;
    }
    public void agregar(String titulo, String descripcion){
        Tarea nueva = new Tarea(contadorId, titulo, descricion);
        tareas.add(nueva);
        System.out.println("Tarea agregada con ID:" +contadorId);
        contadorId++;
    }
    public void lista(){
        if(tareas.isEmpty()){
            System.out.println("No hay tareas.");
            return;
    }    for(Tarea t: tareas){
            t.mostrarInfo();
        }
    }
    public void 
}
package servicio;

import java.util.ArrayList;
import modelo.Tarea;

public class GestorTareas {

    private ArrayList<Tarea> tareas;
    private int contadorId;

    public GestorTareas() {
        tareas = new ArrayList<>();
        contadorId = 1;
    }

    public void agregar(String titulo, String descripcion) {
        Tarea nueva = new Tarea(contadorId, titulo, descripcion);
        tareas.add(nueva);
        System.out.println("Tarea agregada con ID: " + contadorId);
        contadorId++;
    }

    public void listar() {
        if (tareas.isEmpty()) {
            System.out.println("No hay tareas.");
            return;
        }
        for (Tarea t : tareas) {
            t.mostrarInfo();
        }
    }

    public void listarPendientes() {
        boolean hay = false;
        for (Tarea t : tareas) {
            if (!t.estaCompletada()) {
                t.mostrarInfo();
                hay = true;
            }
        }
        if (!hay) {
            System.out.println("No hay tareas pendientes.");
        }
    }

    public void listarCompletadas() {
        boolean hay = false;
        for (Tarea t : tareas) {
            if (t.estaCompletada()) {
                t.mostrarInfo();
                hay = true;
            }
        }
        if (!hay) {
            System.out.println("No hay tareas completadas.");
        }
    }

    public Tarea buscar(int id) {
        for (Tarea t : tareas) {
            if (t.getId() == id) {
                return t;
            }
        }
        return null;
    }

    public void completar(int id) {
        Tarea t = buscar(id);
        if (t != null) {
            t.completar();
        } else {
            System.out.println("ID no encontrado.");
        }
    }

    public void eliminar(int id) {
        Tarea t = buscar(id);
        if (t != null) {
            tareas.remove(t);
            System.out.println("Tarea eliminada.");
        } else {
            System.out.println("ID no encontrado.");
        }
    }

    public int totalTareas() {
        return tareas.size();
    }

    public int tareasCompletadas() {
        int count = 0;
        for (Tarea t : tareas) {
            if (t.estaCompletada()) {
                count++;
            }
        }
        return count;
    }

    public int tareasPendientes() {
        return totalTareas() - tareasCompletadas();
    }
}
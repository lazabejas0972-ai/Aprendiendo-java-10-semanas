package com.example.modelo;
import com.example.exception.DatoInvalidoException;

public class Contacto {
    private String id;
    private String nombre;
    private String telefono;

    public Contacto(String id, String nombre, String telefono){
        setId(id);
        setNombre(nombre);
        setTelefono(telefono);
    }

    public String getId()       { return id; }
    public String getNombre()   { return nombre; }
    public String getTelefono() { return telefono; }

    public void setId(String id) {
        if (id == null || id.trim().isEmpty()) {
            throw new DatoInvalidoException("El ID del contacto no puede estar vacío");
        }
        this.id = id.trim();
    }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new DatoInvalidoException("El nombre del contacto no puede estar vacío");
        }
        this.nombre = nombre.trim();
    }

    public void setTelefono(String telefono) {
        if (telefono == null || telefono.trim().isEmpty()) {
            throw new DatoInvalidoException("El teléfono del contacto no puede estar vacío");
        }
        this.telefono = telefono;
    }
    public String toString(){
        return String.format("[%s] %s - %s", id, nombre, telefono);
    }
}

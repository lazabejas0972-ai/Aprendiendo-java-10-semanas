package com.example.modelo;

import com.example.exception.DatoInvalidoException;

public class Contacto {
    private String id;
    private String nombre;
    private String telefono;
    private String email;
    private String direccion;

    public Contacto(String id, String nombre, String telefono, String email, String direccion){
        setId(id);
        setNombre(nombre);
        setTelefono(telefono);
        setEmail(email);
        setDireccion(direccion);
    }

    public String getId() { return id; }
    public String getNombre() { return nombre; }
    public String getTelefono() { return telefono; }
    public String getEmail() { return email; }
    public String getDireccion() { return direccion; }

    public void setId(String id) {
        if (id == null || id.trim().isEmpty()) {
            throw new DatoInvalidoException("id", "no puede estar vacío");
        }
        this.id = id.trim();
    }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new DatoInvalidoException("nombre", "no puede estar vacío");
        }
        this.nombre = nombre.trim();
    }

    public void setTelefono(String telefono) {
        if (telefono == null || !telefono.matches("\\d{7,8}")) {
            throw new DatoInvalidoException("telefono", "debe tener entre 7 y 8 digitos");
        }
        this.telefono = telefono;
    }

    public void setEmail(String email) {
        if (email == null || !email.contains("@")) {
            throw new DatoInvalidoException("email", "debe contener @");
        }
        this.email = email;
    }

    public void setDireccion(String direccion) {
        this.direccion = (direccion == null) ? "" : direccion.trim();
    }

    @Override
    public String toString(){
        return String.format("[%s] %s - Tel: %s, Email: %s, Dirección: %s", id, nombre, telefono, email, direccion);
    }
}
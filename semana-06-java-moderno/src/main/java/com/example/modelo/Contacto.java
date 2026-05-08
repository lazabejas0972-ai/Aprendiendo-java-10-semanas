package com.example.modelo;

public class Contacto {

    private String id;
    private String nombre;
    private String telefono;
    private String email;

    public Contacto(
            String id,
            String nombre,
            String telefono,
            String email
    ) {
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {

        return "[" + id + "] "
                + nombre
                + " - "
                + telefono
                + " - "
                + email;
    }
}
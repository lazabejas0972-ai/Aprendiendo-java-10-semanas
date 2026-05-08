package com.example.servicio;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import com.example.modelo.Contacto;
import com.example.util.ManejadorJSON;

public class GestorContactos {

    private static final String ARCHIVO =
            "data/contactos.json";

    private List<Contacto> contactos;

    public GestorContactos() {

        contactos =
                ManejadorJSON.cargar(ARCHIVO);
    }

    public void agregarContacto(
            Contacto contacto
    ) {

        contactos.add(contacto);

        guardar();
    }

    public List<Contacto> listarTodos() {

        return contactos;
    }

    public List<Contacto> buscarPorNombre(
            String fragmento
    ) {

        return contactos.stream()
                .filter(c ->
                        c.getNombre()
                                .toLowerCase()
                                .contains(
                                        fragmento
                                                .toLowerCase()
                                )
                )
                .toList();
    }

    public Optional<Contacto> buscarPorId(
            String id
    ) {

        return contactos.stream()
                .filter(c ->
                        c.getId()
                                .equalsIgnoreCase(id))
                .findFirst();
    }

    public long totalConEmail() {

        return contactos.stream()
                .filter(c ->
                        c.getEmail() != null
                                &&
                                !c.getEmail()
                                        .isBlank())
                .count();
    }

    public List<Contacto>
    listarOrdenados() {

        return contactos.stream()
                .sorted(
                        Comparator.comparing(
                                Contacto::getNombre
                        )
                )
                .toList();
    }

    private void guardar() {

        ManejadorJSON.guardar(
                contactos,
                ARCHIVO
        );
    }
}
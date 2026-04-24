package com.example.servicio;

import com.example.exception.ContactoExistenteException;
import com.example.exception.ContactoNoEncontradoException;
import com.example.modelo.Contacto;
import com.example.util.ManejadorJSON;
import java.util.*;

public class AgendaContactos {
    private Map<String, Contacto> contactos;

    public AgendaContactos() {
        contactos = ManejadorJSON.cargar();
    }

    public void agregar(Contacto c) throws ContactoExistenteException {
        if (contactos.containsKey(c.getId())) {
            throw new ContactoExistenteException(c.getId());
        }
        contactos.put(c.getId(), c);
        ManejadorJSON.guardar(contactos);
    }

    public Contacto buscar(String id) throws ContactoNoEncontradoException {
        Contacto c = contactos.get(id);
        if( c == null){
            throw new ContactoNoEncontradoException("No se encontró contacto con id: " + id);
        }
        return c;
    }

    public void eliminar (String id) throws ContactoNoEncontradoException{
        buscar (id);
        contactos.remove(id);
        ManejadorJSON.guardar(contactos);
    }

    public List<Contacto> listar(){
        return new ArrayList<>(contactos.values());
    }

    public int total(){
        return contactos.size();
    }
}
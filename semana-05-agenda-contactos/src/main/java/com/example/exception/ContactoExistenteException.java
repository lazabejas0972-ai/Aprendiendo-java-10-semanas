package com.example.exception;

public class ContactoExistenteException extends Exception{
    private String idDuplicado;
    public ContactoExistenteException(String id){
        super ("Ya existe un contacto con el id: " + id);
        this.idDuplicado = id;
    }
    public String getIdDuplicado() {
        return idDuplicado;
    }
}

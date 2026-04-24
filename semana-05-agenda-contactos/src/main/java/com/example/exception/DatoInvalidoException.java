package com.example.exception;

public class DatoInvalidoException extends RuntimeException {
    private String campo;
    private String mensaje;

    public DatoInvalidoException(String campo, String mensaje) {
        super(String.format("Dato inválido en campo '%s': %s", campo, mensaje));
        this.campo = campo;
        this.mensaje = mensaje;
    }

    public String getCampo() { return campo; }
    public String getMensaje() { return mensaje; }
}

package com.example.servicio;

import com.example.modelo.Contacto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class GestorContactosTest {

    private GestorContactos gestor;

    @BeforeEach
    void setUp() {

        gestor = new GestorContactos();

        gestor.agregarContacto(
                new Contacto(
                        "C001",
                        "Juan Perez",
                        "77777777",
                        "juan@gmail.com"
                )
        );
    }

    @Test
    void buscarPorNombreDebeFuncionar() {

        List<Contacto> resultados =
                gestor.buscarPorNombre(
                        "Juan"
                );

        assertEquals(
                1,
                resultados.size()
        );
    }

    @Test
    void buscarPorIdDebeRetornarOptional() {

        Optional<Contacto> resultado =
                gestor.buscarPorId(
                        "C001"
                );

        assertTrue(
                resultado.isPresent()
        );
    }

    @Test
    void totalConEmailDebeContar() {

        long total =
                gestor.totalConEmail();

        assertEquals(
                1,
                total
        );
    }
}
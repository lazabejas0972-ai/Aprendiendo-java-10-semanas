package com.example.util;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.example.modelo.Contacto;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class ManejadorJSON {

    private static final Gson gson =
            new GsonBuilder()
                    .setPrettyPrinting()
                    .create();

    public static void guardar(
            List<Contacto> contactos,
            String ruta
    ) {

        try (FileWriter writer =
                    new FileWriter(ruta)) {

            gson.toJson(contactos, writer);

        } catch (IOException e) {

            System.out.println(
                    "Error al guardar JSON"
            );
        }
    }

    public static List<Contacto> cargar(
            String ruta
    ) {

        File archivo = new File(ruta);

        if (!archivo.exists()) {
            return new ArrayList<>();
        }

        try (FileReader reader =
                    new FileReader(archivo)) {

            Type tipo =
                    new TypeToken<
                            ArrayList<Contacto>>() {
                    }.getType();

            List<Contacto> lista =
                    gson.fromJson(reader, tipo);

            return lista != null
                    ? lista
                    : new ArrayList<>();

        } catch (IOException e) {

            return new ArrayList<>();
        }
    }
}
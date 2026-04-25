package com.example.util;

import com.example.modelo.Contacto;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class ManejadorJSON {

    private static final Gson gson = new Gson();

    public static ArrayList<Contacto> cargar(String ruta) {
        try (Reader reader = new FileReader(ruta)) {
            Type tipoLista = new TypeToken<ArrayList<Contacto>>(){}.getType();
            ArrayList<Contacto> lista = gson.fromJson(reader, tipoLista);
            return (lista != null) ? lista : new ArrayList<>();
        } catch (Exception e) {
            // Si no existe archivo, retorna lista vacía
            return new ArrayList<>();
        }
    }

    public static void guardarConBackup(ArrayList<Contacto> contactos, String archivo, String backup) {

        try {
            File dir = new File("data");
            if (!dir.exists()) {
                dir.mkdirs();
            }

            File archivoOriginal = new File(archivo);
            if (archivoOriginal.exists()) {
                try (InputStream in = new FileInputStream(archivoOriginal);
                    OutputStream out = new FileOutputStream(backup)) {

                    byte[] buffer = new byte[1024];
                    int length;
                    while ((length = in.read(buffer)) > 0) {
                        out.write(buffer, 0, length);
                    }
                }
            }

            try (Writer writer = new FileWriter(archivo)) {
                gson.toJson(contactos, writer);
            }

        } catch (IOException e) {
            System.out.println("Error al guardar JSON: " + e.getMessage());
        }
    }
}
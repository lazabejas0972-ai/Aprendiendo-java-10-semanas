package com.example;

import java.util.Scanner;

import com.example.modelo.Contacto;
import com.example.servicio.GestorContactos;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        GestorContactos gestor =
                new GestorContactos();

        int opcion;

        do {

            System.out.println("\n=== AGENDA ===");
            System.out.println("1. Agregar");
            System.out.println("2. Listar");
            System.out.println("3. Buscar");
            System.out.println("4. Estadisticas");
            System.out.println("5. Salir");

            System.out.print("Opcion: ");

            opcion =
                    Integer.parseInt(
                            sc.nextLine()
                    );

            switch (opcion) {

                case 1 -> {

                    System.out.print(
                            "ID: "
                    );

                    String id =
                            sc.nextLine();

                    System.out.print(
                            "Nombre: "
                    );

                    String nombre =
                            sc.nextLine();

                    System.out.print(
                            "Telefono: "
                    );

                    String telefono =
                            sc.nextLine();

                    System.out.print(
                            "Email: "
                    );

                    String email =
                            sc.nextLine();

                    gestor.agregarContacto(
                            new Contacto(
                                    id,
                                    nombre,
                                    telefono,
                                    email
                            )
                    );

                    System.out.println(
                            "Contacto agregado"
                    );
                }

                case 2 -> gestor
                        .listarOrdenados()
                        .forEach(System.out::println);

                case 3 -> {

                    System.out.print(
                            "Nombre: "
                    );

                    String nombre =
                            sc.nextLine();

                    gestor.buscarPorNombre(
                                    nombre)
                            .forEach(
                                    System.out::println
                            );
                }

                case 4 -> {

                    System.out.println(
                            "Total contactos: "
                                    +
                                    gestor
                                            .listarTodos()
                                            .size()
                    );

                    System.out.println(
                            "Con email: "
                                    +
                                    gestor
                                            .totalConEmail()
                    );
                }
            }

        } while (opcion != 5);
    }
}
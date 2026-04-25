package com.example;
import java.util.ArrayList;
import java.util.Scanner;

import com.example.exception.ContactoExistenteException;
import com.example.exception.ContactoNoEncontradoException;
import com.example.exception.DatoInvalidoException;
import com.example.modelo.Contacto;
import com.example.servicio.AgendaContactos;
public class Main {
        
        static AgendaContactos agenda = new AgendaContactos();
        static Scanner sc = new Scanner(System.in);

        public static void main(String[] args) {
            int opcion;
            do { 
                mostarMenu();
                opcion = leerOpcion();
                switch (opcion) {
                    case 1 : agregarContacto(); break;
                    case 2 : buscarContacto(); break; 
                    case 3 : eliminarContacto();break; 
                    case 4 : listarContactos(); break;
                    case 5 : System.out.println("Saliendo..."); break;
                    default : System.out.println("Opción inválida.");
                }
            } while (opcion != 5);
            sc.close();
        }

        static int leerOpcion() {
            try {
                return Integer.parseInt(sc.nextLine().trim());
            }catch (NumberFormatException e) {
                return -1;
            }
        }

        static void mostarMenu() {
            System.out.println("\n--- Agenda de Contactos ---");
            System.out.println("1. Agregar contacto");
            System.out.println("2. Listar todos");
            System.out.println("3. Buscar contacto por ID");
            System.out.println("4. Eliminar");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
        }

        static void agregarContacto(){
            try{
                System.out.print("ID: ");
                String id = sc.nextLine();
                System.out.print("Nombre: ");
                String nombre = sc.nextLine();
                System.out.print("Teléfono: ");
                String telefono = sc.nextLine();
                System.out.print("Email: ");
                String email = sc.nextLine();
                System.out.print("Dirección: ");
                String direccion = sc.nextLine();

                agenda.agregar(new Contacto(id, nombre, telefono, email, direccion));
                System.out.println("Contacto agregado exitosamente.");

            }catch (ContactoExistenteException e){
                System.out.println("Error: " + e.getMessage());
            }catch (DatoInvalidoException e){
                System.out.println("Dato invalido en: " + e.getMessage()+" "+e.getCampo());
            }
        }

        static void listarContactos(){
            ArrayList<Contacto> lista = agenda.listarTodos();
            if(lista.isEmpty()){
                System.out.println("No hay contactos ");
                return;
            }
            System.out.println("\n=== CONTACTOS (" + lista.size()+ ") ===");
            for (Contacto c : lista) {
            System.out.println(c);
        }
        System.out.println("Total: " + agenda.total());
        }

        static void buscarContacto(){
            System.out.print("ID a buscar:");
            String id = sc.nextLine();
            try {
                System.out.println(agenda.buscar(id));
            } catch (ContactoNoEncontradoException e) {
                System.out.println(e.getMessage());
            }
        }

        static void eliminarContacto(){
            System.out.print("ID a eliminar:");
            String id = sc.nextLine();
            try {
                agenda.eliminar(id);
                System.out.println("Contacto eliminado.");
            } catch (ContactoNoEncontradoException e) {
                System.out.println(e.getMessage());
            }
        }
}
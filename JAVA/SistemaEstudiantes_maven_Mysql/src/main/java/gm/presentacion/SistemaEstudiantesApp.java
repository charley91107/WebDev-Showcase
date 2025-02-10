package gm.presentacion;

import java.util.Scanner;
import gm.dao.EstudianteDAO;
import gm.modelo.Estudiante;


public class SistemaEstudiantesApp {
    public static void main(String[] args) {
        var salir = false;
        var consola = new Scanner(System.in);
        //se crea una instancia de la clase servicio
        var estudianteDAO = new EstudianteDAO();
        while(!salir){
            try {
                mostrarMenu();
                salir = ejecutarOpciones(consola, estudianteDAO);
            } catch (Exception e) {
                System.out.println("Ocurrio un error: " + e.getMessage());
            }
            System.out.println();
        }//fin while
    }

    private static void mostrarMenu(){
        System.out.print(""" 
        ***Sistema de estudiantes***
        1.- Listar estudiantes
        2.- Buscar estudiante
        3.- Agregar estudiante
        4.- Modificar estudiante
        5.- Eliminar estudiante
        6.- Salir
        Seleccione una opcion:
        """);
    }

    private static boolean ejecutarOpciones(Scanner consola, EstudianteDAO estudianteDAO){
       var opcion = Integer.parseInt(consola.nextLine());
       var salir = false;
       switch (opcion){
           case 1 -> {
               System.out.println("Listado de estudiantes:");
               var estudiantes = estudianteDAO.listarEstudiantes();
               estudiantes.forEach(System.out::println);
           }
           case 2 -> {
               System.out.println("Ingrese el id del estudiante a buscar:");
               var idEstudiante = Integer.parseInt(consola.nextLine());
               var estudiante = new Estudiante(idEstudiante);
               var encontrado = estudianteDAO.buscarEstudiantePorId(estudiante);
                if (encontrado) {
                     System.out.println("Estudiante encontrado: " + estudiante);
                } else {
                     System.out.println("No se encontro el estudiante: " + estudiante.getIdEstudiante());
                }
           }
           case 3 -> {
               System.out.print("Ingrese el nombre del estudiante:");
               var nombre = consola.nextLine();
               System.out.print("Ingrese el apellido del estudiante:");
               var apellido = consola.nextLine();
               System.out.print("Ingrese el telefono del estudiante:");
               var telefono = consola.nextLine();
               System.out.print("Ingrese el email del estudiante:");
               var email = consola.nextLine();
               var estudiante = new Estudiante(nombre, apellido, telefono, email);
               var agregado = estudianteDAO.agregarEstudiante(estudiante);
               if (agregado) {
                   System.out.println("Estudiante agregado: " + estudiante);
               } else {
                   System.out.println("No se pudo agregar el estudiante: " + estudiante);
               }
           }
           case 4 -> {
                System.out.print("Ingrese el id del estudiante a modificar:");
                var idEstudiante = Integer.parseInt(consola.nextLine());
                System.out.print("Ingrese el nombre del estudiante:");
                var nombre = consola.nextLine();
                System.out.print("Ingrese el apellido del estudiante:");
                var apellido = consola.nextLine();
                System.out.print("Ingrese el telefono del estudiante:");
                var telefono = consola.nextLine();
                System.out.print("Ingrese el email del estudiante:");
                var email = consola.nextLine();
                var estudiante = new Estudiante(idEstudiante, nombre, apellido, telefono, email);
                var modificado = estudianteDAO.modificarEstudiante(estudiante);
                if (modificado) {
                     System.out.println("Estudiante modificado: " + estudiante);
                } else {
                     System.out.println("No se pudo modificar el estudiante: " + estudiante);
                }
           }
           case 5 -> {
               System.out.print("Ingrese el id del estudiante a eliminar:");
               var idEstudiante = Integer.parseInt(consola.nextLine());
               var estudiante = new Estudiante(idEstudiante);
               var eliminado = estudianteDAO.eliminarEstudiante(estudiante);
               if (eliminado) {
                   System.out.println("Estudiante eliminado: " + estudiante);
               } else {
                   System.out.println("No se pudo eliminar el estudiante: " + estudiante);
               }
           }
           case 6 -> {
               System.out.println("Saliendo del sistema...");
               salir = true;
           }
           default -> System.out.println("Opcion no valida");
       }
       return salir;
    }
}
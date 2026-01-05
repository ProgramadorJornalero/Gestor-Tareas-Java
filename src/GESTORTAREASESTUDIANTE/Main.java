package GESTORTAREASESTUDIANTE;

import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    static Scanner sc=new Scanner(System.in);
    static ArrayList<Tarea> tareas=new ArrayList<>();
    public static void main(String[] args) {
        cargarTareas();

        System.out.println("Hola, Este codigo sirve para gestionar tareas en una lista");
        int opcion;

        do {
            System.out.println("Menu principal");
            System.out.println("1-Crear nueva tarea");
            System.out.println("2-Eliminar tarea");
            System.out.println("3-Consultar tareas");
            System.out.println("4- Marcar tarea como completado");
            System.out.println("5-Salir");
            System.out.println("Seleccione alguna opcion");
            try {
                opcion=sc.nextInt();
                sc.nextLine();

            } catch (InputMismatchException e) {
                System.out.println("Opcion invalida, intentelo de nuevo");
                sc.nextLine();
                opcion=0;
            }
            switch (opcion){
                case 1:
                    Agregartarea();
                    break;
                case 2:
                    Eliminartarea();
                    break;
                case 3:
                    Consultartareas();
                    break;
                case 4:
                    Completartarea();
                    break;
                case 5:
                    System.out.println("Gracias por usar el administrador de tareas");
                    break;
                default:
                    System.out.println("Error, opcion invalida");
            }




        }while (opcion!=5);

    }
    private static void Agregartarea() {
        System.out.println("*** Nueva Tarea ***");
        boolean completado = false;
        while (!completado) {
            System.out.println("Ingrese el nombre de la tarea o 0 para cancelar: ");
            String title = sc.nextLine();
            if (title.equals("0")) {
                System.out.println("Accion cancelada por el usuario");
                completado=true;
            }else {
                System.out.println("Ingrese la descripcion de la tarea o 0 para cancelar: ");
                String description = sc.nextLine();
                if (description.equals("0")) {
                    System.out.println("Accion cancelada por el usuario");
                    completado = true;
                } else {
                    Tarea tarea = new Tarea(title, description);
                    tareas.add(tarea);
                    completado = true;
                    System.out.println("Tarea añadida con exito");
                    guardarTareas();


                }
            }
        }
    }
    private static void Eliminartarea(){
        if (tareas.isEmpty()){
            System.out.println("No existen tareas a eliminar");
            return;
        }else {
            boolean completado = false;
            while (!completado) {
                Consultartareas();
                System.out.println("Ingrese el indice de la tarea que desea eliminar o 0 para cancelar: ");
                try {
                    int indice = sc.nextInt();
                    sc.nextLine();
                    if (indice == 0) {
                        System.out.println("Accion cancelada por el usuario");
                        completado = true;
                    } else if (indice > 0 && indice <= tareas.size()) {
                        tareas.remove(indice - 1);
                        System.out.println("Tarea eliminada con exito");
                        guardarTareas();
                        completado = true;
                    } else {
                        System.out.println("Error, el indice ingresado no esta asociado a ninguna tarea existente");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Ingrese un digito valido");
                    sc.nextLine();
                }
            }
        }

    }
    private static void Consultartareas(){
        System.out.println("*** Lista de tareas registradas ***");
        if (tareas.isEmpty()){
            System.out.println("No existen tareas registradas");
        }else {
            for (int i = 0; i < tareas.size(); i++) {
                System.out.println(i+1+".- "+tareas.get(i).toString());

            }
        }

    }
    public static void Completartarea() {
        if (tareas.isEmpty()) {
            System.out.println("No hay tareas existentes");
            return;
        } else {

            boolean completado = false;
            while (!completado) {
                Consultartareas();
                System.out.println("Ingrese el indice de la tarea que desea marcar como completada o 0 para cancelar: ");
                try {
                    int indice = sc.nextInt();
                    sc.nextLine();
                    if (indice == 0){
                        System.out.println("Accion cancelada por el usuario");
                        completado=true;
                    }else if (indice > 0 && indice <= tareas.size()) {
                        Tarea tarea = tareas.get(indice - 1);
                        tarea.setCheck(true);
                        guardarTareas();
                        System.out.println("Tarea marcada como realizada");
                        completado=true;
                    } else {
                        System.out.println("Error, el indice ingresado no esta asociado a ninguna tarea existente");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Ingrese un digito valido");
                    sc.nextLine();
                }
            }
        }
    }
        private static void guardarTareas(){
            try {
                FileWriter escribir=new FileWriter("tareas.txt");
                for (Tarea tarea:tareas) {
                    escribir.write(tarea.getTitle()+";"+tarea.getDescription()+";"+tarea.isCheck()+"\n");


                }
                escribir.close();
            } catch (IOException e) {
                System.out.println("Error, el programa fallo al actualizar las tareas ");
            }

        }
        private static void cargarTareas(){
            try {
                File archivo=new File("tareas.txt");
                if (!archivo.exists()){
                    return;
                }
                tareas.clear();
                Scanner cargar=new Scanner(archivo);
                while (cargar.hasNextLine()){
                    String linea= cargar.nextLine();
                    String[]partestexto=linea.split(";");
                     if (partestexto.length==3){
                         String titulo=partestexto[0];
                         String descripcion=partestexto[1];
                         boolean estado=Boolean.parseBoolean(partestexto[2]);

                         Tarea tareaArchivo=new Tarea(titulo,descripcion);
                         if (estado){
                             tareaArchivo.setCheck(true);
                         }
                         tareas.add(tareaArchivo);
                     }

                }
                cargar.close();

            } catch (IOException e) {
                System.out.println("Error, el programa fallo al cargar las tareas ");
            }
        }
    }
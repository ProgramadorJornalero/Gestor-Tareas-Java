package GESTORTAREASESTUDIANTE;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    static Scanner sc=new Scanner(System.in);
    static ArrayList<Tarea> tareas=new ArrayList<>();
    public static void main(String[] args) {

        System.out.println("Hola, Este codigo sirve para gestionar tareas en una lista");
        int opcion=0;

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
    private static void Agregartarea(){
        System.out.println("*** Nueva Tarea ***");
        System.out.println("Ingrese el nombre de la tarea: ");
        String title=sc.nextLine();
        System.out.println("Ingrese la descripcion de la tarea: ");
        String description= sc.nextLine();
        Tarea tarea=new Tarea(title,description);
        tareas.add(tarea);
        System.out.println("Tarea añadida con exito");


    }
    private static void Eliminartarea(){
        Consultartareas();
        if (tareas.isEmpty()){
            return;
        }else {
            System.out.println("Ingrese el indice de la tarea que desea eliminar: ");
            try {
                int indice= sc.nextInt();
                sc.nextLine();

                if (indice>0&&indice<= tareas.size()){
                    tareas.remove(indice-1);
                    System.out.println("Tarea eliminada con exito");
                }else {
                    System.out.println("Error, el indice ingresado no esta asociado a ninguna tarea existente");
                }
            }catch (InputMismatchException e){
                System.out.println("Ingrese un digito valido");
                sc.nextLine();
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
    public static void Completartarea(){
        Consultartareas();
        if (tareas.isEmpty()){
            return;
        }else {
            System.out.println("Ingrese el indice de la tarea que desea marcar como completada: ");
            try {
                int indice= sc.nextInt();
                sc.nextLine();

                if (indice>0&&indice<= tareas.size()){
                    Tarea tarea=tareas.get(indice-1);
                    tarea.setCheck(true);
                    System.out.println("Tarea marcada como realizada");
                }else {
                    System.out.println("Error, el indice ingresado no esta asociado a ninguna tarea existente");
                }
            }catch (InputMismatchException e){
                System.out.println("Ingrese un digito valido");
                sc.nextLine();
            }
        }
        }

    }


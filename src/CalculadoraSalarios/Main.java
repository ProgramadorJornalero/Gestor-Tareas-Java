package CalculadoraSalarios;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Calculadora de Nomina");
        try {
            System.out.println("Ingrese el nombre del empleado: ");
            String nombre= sc.nextLine();
            System.out.println("Ingrese el salario por hora: ");
            double salarioPorHora = sc.nextDouble();
            System.out.println("Ingrese el numero de horas trabajadas: ");
            float horasTrabajadas= sc.nextFloat();

            Empleado empleado=new Empleado(nombre,salarioPorHora,horasTrabajadas);

            System.out.println("-------------------------------");
            System.out.println(empleado.calcularSueldo());
            System.out.println("-------------------------------");

        } catch (RuntimeException e) {
            System.out.println("Ingrese un dato valido por favor");
        }


    }
}

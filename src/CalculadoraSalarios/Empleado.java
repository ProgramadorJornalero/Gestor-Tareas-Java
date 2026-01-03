package CalculadoraSalarios;

public class Empleado {
    private String nombre;
    private double salarioPorHora;
    private double horasTrabajadas;

    public Empleado(String nombre, double salarioPorHora, float horasTrabajadas) {
        this.nombre = nombre;
        this.salarioPorHora = salarioPorHora;
        this.horasTrabajadas = horasTrabajadas;

    }

    public String calcularSueldo() {
        int horasBase = 40;
        double salarioHorasExtra=0;
        double salarioBase=0;
        double horasExtra=0;
        double total=0;
        if (horasTrabajadas <= horasBase) {
            salarioBase=horasTrabajadas*salarioPorHora;
            total=salarioBase;

        } else {
             salarioBase = horasBase * salarioPorHora;
             horasExtra = horasTrabajadas - horasBase;
             salarioHorasExtra = horasExtra * (salarioPorHora * 2);
            total=salarioBase+salarioHorasExtra;

        }

        return """
                \n=========================================
                RECIBO DE NÓMINA: %s
                =========================================
                Horas Totales Trabajadas: %.1f
                Precio por Hora: $%.2f
                
                DESGLOSE:
                (+) Sueldo Base (Normal):    $%.2f
                (+) Horas Extra (%.1f hrs):  $%.2f
                -----------------------------------------
                (=) TOTAL A PAGAR:           $%.2f
                =========================================
                """.formatted(nombre, horasTrabajadas, salarioPorHora,salarioBase,horasExtra,salarioHorasExtra,total);
    }
}
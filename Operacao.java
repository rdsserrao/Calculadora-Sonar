import java.text.*;

public class Operacao {

    static DecimalFormat decFor = new DecimalFormat("#.##");

    public void sum(double num1, double num2){
        System.out.println("Soma: " + decFor.format(num1) + " + " + decFor.format(num2) + " = " + decFor.format(num1+num2));
        System.out.println("");
    }
    public void sub(double num1, double num2){
        System.out.println("Subtração: " + decFor.format(num1) + " - " + decFor.format(num2) + " = " + decFor.format(num1-num2));
        System.out.println("");
    }
    public void mult(double num1, double num2){
        System.out.println("Multiplicação: " + decFor.format(num1) + " * " + decFor.format(num2) + " = " + decFor.format(num1*num2));
        System.out.println("");
    }
    public void div(double num1, double num2){
        System.out.println("Divisão: " + decFor.format(num1) + " / " + decFor.format(num2) + " = " + decFor.format(num1/num2));
        System.out.println("");
    }
}

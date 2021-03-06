import java.util.Scanner;


public class CalculadoraFinal {


    static Scanner scanner = new Scanner(System.in);
    
        
    public static void main(String[] args){


        System.out.println("");
        System.out.println("Calculadora persistente");
        
        int opcao = 0;


        do {
            escolhaOpcao(opcao);
            opcao = scanner.nextInt();

            validaopcao(opcao);

            if ( opcao == 1 ) {
            novaOperacao();
            

            }
        }
        while (opcao != 2);

        scanner.close();
        
    }

    public static void escolhaOpcao(int opcao) {
        System.out.println("");
        System.out.println("Escolha uma opção: ");
        System.out.println("1: Nova operação");
        System.out.println("2: Sair");
        }

    public static void validaopcao(int opcao) {
            if (opcao != 1 && opcao != 2)
            System.out.println("Opção inválida.");
            
        }

    public static void novaOperacao() {

        int oper = 0;
        double num1, num2;
        char resp;
        int i = 0;

        System.out.println("Introduza um número: ");
        num1 = scanner.nextDouble();

        do {

        System.out.println("Introduza o operador: ");
        System.out.println("1:   +");
        System.out.println("2:   -");
        System.out.println("3:   *");
        System.out.println("4:   /");
        oper = scanner.nextInt();
        
        System.out.println("Introduza outro número: ");
        num2 = scanner.nextDouble();

        Operacao operacao = new Operacao();
        double valor = 0;

        switch (oper) {
            case 1:
            double soma = num1 + num2;
            operacao.sum(num1, num2);
            if (soma != 0)
            valor = soma;
            num1 = valor;
                break;
            case 2:
            double subtracao = num1 - num2;
            operacao.sub(num1, num2);
            if (subtracao != 0)
            valor = subtracao;
            num1 = valor;
                break;
            case 3:
            double multiplicacao = num1 * num2;
            operacao.mult(num1, num2);
            if (multiplicacao != 0)
            valor = multiplicacao;
            num1 = valor;
                break;
            case 4:
            double divisao = num1 / num2;
            operacao.div(num1, num2);
            if (divisao != 0)
            valor = divisao;
            num1 = valor;
                break;
        }
        System.out.println("Pretende incluir mais algum número? ");
        System.out.println("s:  Sim ");
        System.out.println("n:  Não ");
        resp = scanner.next().charAt(0);
        if (resp == 's') {
         i = 1; }
         if (resp == 'n') {
         i = 2; }
         
        } while (i != 2);
    }
    

}


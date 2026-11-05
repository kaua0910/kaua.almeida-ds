import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n===== MENU DE EXERCÍCIOS =====");
            System.out.println("1 - Contar até N");
            System.out.println("2 - Contagem 10 a 0");
            System.out.println("3 - Somar até 0");
            System.out.println("4 - Tabuada");
            System.out.println("5 - Dia da semana");
            System.out.println("6 - Menu simples");
            System.out.println("7 - Números pares");
            System.out.println("8 - Verificar senha");
            System.out.println("9 - 0 a 50");
            System.out.println("10 - Repetir frase");
            System.out.println("11 - Maior idade");
            System.out.println("12 - Contagem regressiva");
            System.out.println("13 - Soma pares/ímpares");
            System.out.println("14 - Operações");
            System.out.println("15 - Validar resposta");
            System.out.println("16 - Multiplicação por soma");
            System.out.println("17 - Contar letras");
            System.out.println("18 - Classificação nota");
            System.out.println("19 - Ímpares 1 a 30");
            System.out.println("20 - Simulador ligação");
            System.out.println("0 - Sair");

            opcao = sc.nextInt();

            switch (opcao) {

                case 1:
                    System.out.print("Digite N: ");
                    int n1 = sc.nextInt();
                    int i1 = 1;
                    while (i1 <= n1) {
                        System.out.println(i1);
                        i1++;
                    }
                    break;

                case 2:
                    for (int i = 10; i >= 0; i--) {
                        System.out.println(i);
                    }
                    break;

                case 3:
                    int num = -1, soma = 0;
                    while (num != 0) {
                        System.out.print("Digite número (0 para parar): ");
                        num = sc.nextInt();
                        soma += num;
                    }
                    System.out.println("Soma: " + soma);
                    break;

                case 4:
                    System.out.print("Digite número: ");
                    int tab = sc.nextInt();
                    for (int i = 1; i <= 10; i++) {
                        System.out.println(tab + " x " + i + " = " + (tab * i));
                    }
                    break;

                case 5:
                    System.out.print("Digite dia (1-7): ");
                    int dia = sc.nextInt();
                    switch (dia) {
                        case 1: System.out.println("Domingo"); break;
                        case 2: System.out.println("Segunda"); break;
                        case 3: System.out.println("Terça"); break;
                        case 4: System.out.println("Quarta"); break;
                        case 5: System.out.println("Quinta"); break;
                        case 6: System.out.println("Sexta"); break;
                        case 7: System.out.println("Sábado"); break;
                        default: System.out.println("Inválido");
                    }
                    break;

                case 6:
                    int op;
                    do {
                        System.out.println("1- Olá | 0- Sair");
                        op = sc.nextInt();
                        if (op == 1) System.out.println("Olá!");
                    } while (op != 0);
                    break;

                case 7:
                    System.out.print("Digite N: ");
                    int n7 = sc.nextInt();
                    for (int i = 0; i <= n7; i++) {
                        if (i % 2 == 0) System.out.println(i);
                    }
                    break;

                case 8:
                    System.out.print("Digite senha: ");
                    String senha = sc.next();
                    if (senha.equals("1234")) {
                        System.out.println("Acesso permitido");
                    } else {
                        System.out.println("Acesso negado");
                    }
                    break;

                case 9:
                    int i9 = 0;
                    while (i9 <= 50) {
                        System.out.println(i9);
                        i9++;
                    }
                    break;

                case 10:
                    System.out.print("Quantas vezes repetir? ");
                    int vezes = sc.nextInt();
                    for (int i = 0; i < vezes; i++) {
                        System.out.println("Java é legal!");
                    }
                    break;

                case 11:
                    System.out.print("Digite idade: ");
                    int idade = sc.nextInt();
                    if (idade >= 18) {
                        System.out.println("Maior de idade");
                    } else {
                        System.out.println("Menor de idade");
                    }
                    break;

                case 12:
                    System.out.print("Digite início: ");
                    int inicio = sc.nextInt();
                    for (int i = inicio; i >= 0; i--) {
                        System.out.println(i);
                    }
                    break;

                case 13:
                    int pares = 0, impares = 0;
                    for (int i = 1; i <= 10; i++) {
                        if (i % 2 == 0) pares += i;
                        else impares += i;
                    }
                    System.out.println("Pares: " + pares);
                    System.out.println("Ímpares: " + impares);
                    break;

                case 14:
                    System.out.println("1-Somar 2-Subtrair");
                    int op14 = sc.nextInt();
                    if (op14 == 1) System.out.println("Somar");
                    else if (op14 == 2) System.out.println("Subtrair");
                    break;

                case 15:
                    String resp = "";
                    while (!resp.equals("sim")) {
                        System.out.print("Digite 'sim': ");
                        resp = sc.next();
                    }
                    break;

                case 16:
                    System.out.print("Digite A: ");
                    int a = sc.nextInt();
                    System.out.print("Digite B: ");
                    int b = sc.nextInt();
                    int resultado = 0, i16 = 0;
                    while (i16 < b) {
                        resultado += a;
                        i16++;
                    }
                    System.out.println("Resultado: " + resultado);
                    break;

                case 17:
                    System.out.print("Digite palavra: ");
                    String palavra = sc.next();
                    for (int i = 0; i < palavra.length(); i++) {
                        System.out.println(palavra.charAt(i));
                    }
                    break;

                case 18:
                    System.out.print("Digite nota: ");
                    int nota = sc.nextInt();
                    if (nota >= 7) System.out.println("Aprovado");
                    else if (nota >= 5) System.out.println("Recuperação");
                    else System.out.println("Reprovado");
                    break;

                case 19:
                    for (int i = 1; i <= 30; i++) {
                        if (i % 2 != 0) System.out.println(i);
                    }
                    break;

                case 20:
                    System.out.println("1-Ligar 2-Desligar");
                    int op20 = sc.nextInt();
                    switch (op20) {
                        case 1: System.out.println("Ligando..."); break;
                        case 2: System.out.println("Encerrando..."); break;
                        default: System.out.println("Inválido");
                    }
                    break;

                case 0:
                    System.out.println("Encerrando...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }

        } while (opcao != 0);

        sc.close();
    }
}
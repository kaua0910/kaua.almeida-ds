import java.util.Scanner;
public class exercicio3{
    public static void main (String [] args){
    Scanner entrada = new Scanner (System.in);
    System.out.println("Digite um numero");
    int numero = entrada.nextInt();
    int numerodois = 0;
    while (numero != 0 ) 
    {        numerodois = numero + numerodois;
        System.out.println("digite um numero");
        numero = entrada.nextInt();

    }
    System.out.println(numerodois);
}
    
    
    
}
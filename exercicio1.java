import java.util.Scanner;
public class exercicio1{
    public static void main(String [] args){
    Scanner entrada = new Scanner (System.in);
    
    System.out.println("Digite um Numero: ");
        int numero = entrada.nextInt();
        
        for (int i = 0; i <= numero; i++) 
        {
            System.out.println("O seu nummero nao: " + i);
        }

    
    
    }
}

import java.util.Scanner;



public class Main {
    public static void main(String[] args) {
       
        Scanner sc = new Scanner(System.in);
        

        String nome;

        System.out.println("Digite seu nome: ");
        nome = sc.nextLine();
        System.out.println();
        System.out.println("Bem vindo " + nome + "!");
        System.out.println();


            System.out.println("\n--- MENU ---");
                System.out.println("1. Cadastrar música");
                System.out.println("2. Listar músicas");
                System.out.println("3. Avaliar música");
                System.out.println("4. Ver histórico de avaliações");
                System.out.println("0. Sair");
                System.out.println();








    }
}
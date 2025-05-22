
import java.util.ArrayList;
import java.util.Scanner;
import src.track;



public class Main {
    public static void main(String[] args) {
       
        Scanner sc = new Scanner(System.in);
        ArrayList<track> tracks = new ArrayList<>();
        String nome;

        System.out.println("Digite seu nome: ");
        nome = sc.nextLine();
        System.out.println();
        System.out.println("Bem vindo " + nome + "!");
        System.out.println();

        int opcao;

            System.out.println("\n--- MENU ---");
                System.out.println("1. Cadastrar música");
                System.out.println("2. Cadastrar álbum");
                System.out.println("3. Listar músicas");
                System.out.println("4. Listar álbuns");
                System.out.println("5. Avaliar música/álbum");
                System.out.println("6. Ver histórico de avaliações");
                System.out.println("0. Sair");
                System.out.println();
                opcao = Integer.parseInt(sc.nextLine());

    switch (opcao) {

            case 1:
        




    }







    }
}
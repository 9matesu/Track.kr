package src;
import java.util.ArrayList;
import java.util.Scanner;



public class Main {
    public static void main(String[] args) {
       
        Scanner sc = new Scanner(System.in);

        // declaração de arrays para cadastro
        ArrayList<track> tracks = new ArrayList<>();

        System.out.println(
    "  _                  _      _         \n" +
    " | |                | |    | |        \n" +
    " | |_ _ __ __ _  ___| | __ | | ___ __ \n" +
    " | __| '__/ _` |/ __| |/ / | |/ / '__|\n" +
    " | |_| | | (_| | (__|   < _|   <| |   \n" +
    "  \\__|_|  \\__,_|\\___|_|\\_(_)_|\\_\\_|   \n" +
    "                                      \n" +
    "                                      "
    );

        String nome;
        System.out.println("Digite seu nome: ");
        nome = sc.nextLine();
        System.out.println();
        System.out.println("Ola, " + nome +"!");
        System.out.println();

        int opcao;

            System.out.println("\n--- MENU ---");
                System.out.println("1. Cadastrar música");
                System.out.println("2. Cadastrar álbum");
                System.out.println("3. Listar músicas");
                System.out.println("4. Listar álbuns");
                System.out.println("5. Ver histórico de avaliações");
                System.out.println("6. Exportar lista");
                System.out.println("0. Sair");
                System.out.println();
                opcao = Integer.parseInt(sc.nextLine());

    switch (opcao) {

            case 1:
            TrackUtils.cadastrarMusica(sc, tracks);

            
            TrackUtils.cadastrarMusica(sc, tracks);
            break;

            case 2:
            TrackUtils.cadastrarAlbum(sc, tracks);
            break;

            case 3:
            TrackUtils.listarMusicas(tracks);
            break;

            case 4:
            TrackUtils.listarAlbuns(tracks);
            break;

            case 5:
            TrackUtils.avaliarTrack(sc, tracks);
            break;

            case 6: // exporta as listas 
            
            save.writeArquivo(); 

            case 0:
            System.exit(0);
            
    }






        sc.close();
    }
}
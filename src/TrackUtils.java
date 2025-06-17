package src;

import java.util.ArrayList;
import java.util.Scanner;

public class TrackUtils {

        

    public static void cadastrarMusica(Scanner sc, ArrayList<track> tracks) {
        System.out.print("Digite o nome da música: ");
        String faixa = sc.nextLine();
        System.out.print("Digite o nome do artista: ");
        String artista = sc.nextLine();
        System.out.print("Digite o nome do álbum: ");
        String album = sc.nextLine();
        System.out.print("Digite o ano de lançamento: ");
        int ano = Integer.parseInt(sc.nextLine());
        System.out.print("Digite a nota: ");
        int rate = Integer.parseInt(sc.nextLine());

        tracks.add(new track(faixa, artista, album, ano, rate));
        System.out.println("Música cadastrada com sucesso!");
    }

    public static void listarMusicas(ArrayList<track> tracks) {
        System.out.println("\n--- Músicas Cadastradas ---");
        for (track t : tracks) {
            System.out.println(t.formatarEmTexto());
        }
    }


    public static void historicoAvaliacoes(ArrayList<track> tracks) {
        System.out.println("\n--- Histórico de Avaliações ---");
        for (track t : tracks) {
            if (t.getRate() > 0) {
                System.out.println(t.formatarEmTexto());
            }
        }
    }
}

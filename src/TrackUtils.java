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
        tracks.add(new track(faixa, artista, album, ano, 0));
        System.out.println("Música cadastrada com sucesso!");
    }

    public static void listarMusicas(ArrayList<track> tracks) {
        System.out.println("\n--- Músicas Cadastradas ---");
        for (track t : tracks) {
            System.out.println(t.formatarEmTexto());
        }
    }

    public static void avaliarTrack(Scanner sc, ArrayList<track> tracks) {
        System.out.print("Digite o nome da música ou álbum para avaliar: ");
        String nome = sc.nextLine();
        track t = null;
        for (track track : tracks) {
            if (track.getFaixa().equalsIgnoreCase(nome) || track.getAlbum().equalsIgnoreCase(nome)) {
                t = track;
                break;
            }
        }
        if (t != null) {
            double avaliacao;
            do {
                System.out.print("Digite a avaliação (0 a 10): ");
                avaliacao = Double.parseDouble(sc.nextLine());
                if (avaliacao < 0 || avaliacao > 10) {
                    System.out.println("Nota inválida! Por favor, insira uma nota entre 0 e 10.");
                }
            } while (avaliacao < 0 || avaliacao > 10);
            t.setRate((int) avaliacao);
            System.out.println("Avaliação registrada com sucesso!");
        } else {
            System.out.println("Música ou álbum não encontrado!");
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

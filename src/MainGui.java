package src;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

public class MainGui {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Track.kr");
        frame.setLayout(new FlowLayout());

        ArrayList<track> listaDeMusicas = new ArrayList<>(); // setar escopo para salvar e mostrar as músicas


        // botões
        JButton b_cadastrarMusica = new JButton("Cadastrar Música");
        b_cadastrarMusica.setPreferredSize(new Dimension(200,50));
        b_cadastrarMusica.setMaximumSize(new Dimension(200,50));

        // botao abre janela
        b_cadastrarMusica.addActionListener(new ActionListener() {

    @Override 
    public void actionPerformed (ActionEvent e) {
        JFrame F_cadastrarmusica = new JFrame("Cadastrar Música");
        F_cadastrarmusica.setSize(new Dimension(350, 300));
        F_cadastrarmusica.setLayout(new GridLayout(6, 2, 5, 5));
        F_cadastrarmusica.setLocationRelativeTo(null);
        F_cadastrarmusica.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Campos de entrada
        JLabel l_nome = new JLabel("   Nome:");
        JTextField tf_nome = new JTextField();

        JLabel l_artista = new JLabel("   Artista:");
        JTextField tf_artista = new JTextField();

        JLabel l_album = new JLabel("   Álbum:");
        JTextField tf_album = new JTextField();

        JLabel l_ano = new JLabel("   Ano:");
        JTextField tf_ano = new JTextField();

        JLabel l_nota = new JLabel("   Nota:");
        JTextField tf_nota = new JTextField();

        JButton b_salvar = new JButton("   Salvar");
        b_salvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String nome = tf_nome.getText();
                String artista = tf_artista.getText();
                String album = tf_album.getText();
                int ano = Integer.parseInt(tf_ano.getText());
                int nota = Integer.parseInt(tf_nota.getText());

                track novaTrack = new track(nome, artista, album, ano, nota);
                listaDeMusicas.add(novaTrack);
                

                JOptionPane.showMessageDialog(F_cadastrarmusica,
                    "Música cadastrada:\n" +
                    "Nome: " + nome + "\n" +
                    "Artista: " + artista + "\n" +
                    "Álbum: " + album + "\n" +
                    "Ano: " + ano + "\n" +
                    "Nota: " + nota
                );

                // Você pode adicionar a lógica para gravar isso em uma lista ou arquivo
            }
        });

        // Adicionando os componentes ao frame
        F_cadastrarmusica.add(l_nome);
        F_cadastrarmusica.add(tf_nome);

        F_cadastrarmusica.add(l_artista);
        F_cadastrarmusica.add(tf_artista);

        F_cadastrarmusica.add(l_album);
        F_cadastrarmusica.add(tf_album);

        F_cadastrarmusica.add(l_ano);
        F_cadastrarmusica.add(tf_ano);

        F_cadastrarmusica.add(l_nota);
        F_cadastrarmusica.add(tf_nota);

        F_cadastrarmusica.add(new JLabel()); // espaço vazio
        F_cadastrarmusica.add(b_salvar);

        F_cadastrarmusica.setVisible(true);
    }
});


        JButton b_listarMusica = new JButton("Listar Músicas");
        b_listarMusica.setPreferredSize(new Dimension(200,50));
        b_listarMusica.setMaximumSize(new Dimension(200,50));

               // botao abre janela
        b_listarMusica.addActionListener(new ActionListener() {

           @Override 
            public void actionPerformed (ActionEvent e) {
                JFrame F_listarMusica = new JFrame("Listar Música");
                F_listarMusica.setSize(new Dimension(300,400));
                F_listarMusica.setLocationRelativeTo(null);
                F_listarMusica.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // só fecha a janela nova
                F_listarMusica.setVisible(true);

                StringBuilder sb = new StringBuilder();
                for (track musica : listaDeMusicas) {
                sb.append(musica.formatarEmTexto());
                sb.append("\n\n");  // separa as músicas com linhas em branco
                }
                String resultado = sb.toString(); // função que puxa as tracks e adiciona numa string

                JLabel campoListar = new JLabel("<html>" + resultado.replace("\n", "<br>") + "</html>");
                JScrollPane scroll = new JScrollPane(campoListar);
                scroll.setPreferredSize(new Dimension(280, 360));

                F_listarMusica.add(campoListar);


            }

        });



        JButton b_historico = new JButton("Histórico de Avaliações");
        b_historico.setPreferredSize(new Dimension(200,50));
        b_historico.setMaximumSize(new Dimension(200,50));

               // botao abre janela
        b_historico.addActionListener(new ActionListener() {

           @Override 
            public void actionPerformed (ActionEvent e) {
                JFrame F_historico = new JFrame("Histórico de Avaliações");
                F_historico.setSize(new Dimension(300,400));
                F_historico.setLocationRelativeTo(null);
                F_historico.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // só fecha a janela nova
                F_historico.setVisible(true);

            }

        });

        JButton b_exportar = new JButton("Exportar Lista");
        b_exportar.setPreferredSize(new Dimension(200,50));
        b_exportar.setMaximumSize(new Dimension(200,50));

               // botao abre janela
        b_exportar.addActionListener(new ActionListener() {

           @Override 
            public void actionPerformed (ActionEvent e) {
                JFrame F_exportar = new JFrame("Exportar Lista");
                F_exportar.setSize(new Dimension(300,400));
                F_exportar.setLocationRelativeTo(null);
                F_exportar.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // só fecha a janela nova
                F_exportar.setVisible(true);

            }

        });

        frame.add(b_cadastrarMusica);    
        frame.add(b_listarMusica);
        frame.add(b_historico);
        frame.add(b_exportar);
        // fim dos botões

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 400);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}

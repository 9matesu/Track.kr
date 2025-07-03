package src;
import java.awt.*;
import javax.swing.*;


public class MainGui {

    static java.util.List<track> historico = new java.util.ArrayList<>();

    public static void main(String[] args) {
    
        JFrame frame = new JFrame("Track.kr");
        frame.setLayout(new BorderLayout(10, 10));

        JPanel painelImagem = new JPanel();
        painelImagem.setPreferredSize(new Dimension(600, 200));
        painelImagem.setLayout(new BorderLayout());

        ImageIcon imagem = new ImageIcon("src/main.png");
        JLabel labelImagem = new JLabel(imagem);
        labelImagem.setHorizontalAlignment(SwingConstants.CENTER);
        painelImagem.add(labelImagem, BorderLayout.CENTER);

        frame.add(painelImagem, BorderLayout.NORTH);

        JPanel painelBotoes = new JPanel(new GridLayout(3, 1, 10, 10));
        painelBotoes.setPreferredSize(new Dimension(600, 180));

        JButton b_cadastrarMusica = new JButton("Cadastrar Música");
        JButton b_historico = new JButton("Histórico de Avaliações");
        JButton b_exportar = new JButton("Exportar Lista");

        painelBotoes.add(b_cadastrarMusica);
        painelBotoes.add(b_historico);
        painelBotoes.add(b_exportar);

        frame.add(painelBotoes, BorderLayout.CENTER);

        b_cadastrarMusica.addActionListener(e -> {
            JFrame F_cadastrarmusica = new JFrame("Cadastrar Música");
            F_cadastrarmusica.setSize(new Dimension(350, 300));
            F_cadastrarmusica.setLayout(new GridLayout(6, 2, 5, 5));
            F_cadastrarmusica.setLocationRelativeTo(null);
            F_cadastrarmusica.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

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

            b_salvar.addActionListener(ev -> {
                try {
                    String nome = tf_nome.getText();
                    String artista = tf_artista.getText();
                    String album = tf_album.getText();
                    int ano = Integer.parseInt(tf_ano.getText());
                    int nota = Integer.parseInt(tf_nota.getText());

                    track novaTrack = new track(nome, album, artista, ano, nota);
                    historico.add(novaTrack);

                    JOptionPane.showMessageDialog(F_cadastrarmusica,
                            "Música cadastrada:\n" +
                                    "Nome: " + nome + "\n" +
                                    "Artista: " + artista + "\n" +
                                    "Álbum: " + album + "\n" +
                                    "Ano: " + ano + "\n" +
                                    "Nota: " + nota
                    );
                    F_cadastrarmusica.dispose();

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(F_cadastrarmusica, "Ano e Nota devem ser números inteiros.");
                }
            });

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

            F_cadastrarmusica.add(new JLabel());
            F_cadastrarmusica.add(b_salvar);

            F_cadastrarmusica.setVisible(true);
        });

        b_historico.addActionListener(e -> {
            JFrame F_historico = new JFrame("Histórico de Avaliações");
            F_historico.setSize(new Dimension(300, 400));
            F_historico.setLocationRelativeTo(null);
            F_historico.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

            JLabel Hist = new JLabel();
            Hist.setVerticalAlignment(SwingConstants.TOP);
            Hist.setHorizontalAlignment(SwingConstants.LEFT);

            StringBuilder texto = new StringBuilder("<html><div style='padding:10px;'>");

            if (historico.isEmpty()) {
                texto.append("Nenhuma música cadastrada.");
            } else {
                for (track t : historico) {
                    texto.append(t.formatarEmTexto().replace("\n", "<br>"));
                    texto.append("<br><br>");
                }
            }
            texto.append("</div></html>");

            Hist.setText(texto.toString());

            JScrollPane scroll = new JScrollPane(Hist);
            F_historico.add(scroll);

            F_historico.setVisible(true);
        });

        b_exportar.addActionListener(e -> {
            if (historico == null || historico.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Nenhuma música para exportar.");
                return;
            }

            StringBuilder textoParaExportar = new StringBuilder();

            for (track t : historico) {
                textoParaExportar.append(t.formatarEmTexto()).append("\n\n");
            }

            save.writeArquivo(textoParaExportar.toString());

            JOptionPane.showMessageDialog(null, "Lista exportada com sucesso!");
        });

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 450);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}

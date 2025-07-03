package src;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class MainGui {

    static java.util.List<track> historico = new java.util.ArrayList<>();

    public static void main(String[] args) {

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ignored) {}

        Color fundo = new Color(46, 46, 46);         // #2E2E2E
        Color painel = new Color(60, 60, 60);        // #3C3C3C
        Color fundobotao = new Color(60, 60, 60);        //rgb(94, 133, 177)
        Color texto = new Color(224, 224, 224);      // #E0E0E0
        Color input = new Color(68, 68, 68);         // #444
        Font fonte = new Font("Segoe UI", Font.PLAIN, 14);
        Font fonteBotao = new Font("Segoe UI", Font.BOLD, 14);

        JFrame frame = new JFrame("Track.kr");
        frame.setLayout(new BorderLayout(10, 10));
        frame.getContentPane().setBackground(fundo);

        JPanel painelImagem = new JPanel(new BorderLayout());
        painelImagem.setPreferredSize(new Dimension(600, 180));
        painelImagem.setBackground(fundo);

        ImageIcon imagem = new ImageIcon("src/main.png");
        JLabel labelImagem = new JLabel(imagem);
        labelImagem.setHorizontalAlignment(SwingConstants.CENTER);
        painelImagem.add(labelImagem, BorderLayout.CENTER);

        frame.add(painelImagem, BorderLayout.NORTH);

        // Painel de botões
        JPanel painelBotoes = new JPanel(new GridLayout(3, 1, 10, 10));
        painelBotoes.setPreferredSize(new Dimension(600, 180));
        painelBotoes.setBackground(fundo);
        painelBotoes.setBorder(new EmptyBorder(10, 20, 10, 20));

        // Botões
        JButton b_cadastrarMusica = new JButton("Cadastrar Música");
        JButton b_historico = new JButton("Histórico de Avaliações");
        JButton b_exportar = new JButton("Exportar Lista");

        JButton[] botoes = { b_cadastrarMusica, b_historico, b_exportar };
        for (JButton botao : botoes) {
            botao.setBackground(fundobotao);
            botao.setForeground(fundobotao);
            botao.setFont(fonteBotao);
            botao.setFocusPainted(false);
            botao.setBorder(BorderFactory.createEmptyBorder(12, 20, 12, 20));
        }

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

            JPanel panel = (JPanel) F_cadastrarmusica.getContentPane();
            panel.setBackground(fundo);
            panel.setBorder(new EmptyBorder(10, 10, 10, 10));

            String[] labelsText = { "Nome:", "Artista:", "Álbum:", "Ano:", "Nota:" };
            JLabel[] labels = new JLabel[5];
            JTextField[] fields = new JTextField[5];

            for (int i = 0; i < 5; i++) {
                labels[i] = new JLabel("  " + labelsText[i]);
                labels[i].setForeground(texto);
                labels[i].setFont(fonte);
                fields[i] = new JTextField();
                fields[i].setBackground(input);
                fields[i].setForeground(texto);
                fields[i].setCaretColor(texto);
                fields[i].setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
                F_cadastrarmusica.add(labels[i]);
                F_cadastrarmusica.add(fields[i]);
            }

            JButton b_salvar = new JButton("Salvar");
            b_salvar.setBackground(painel);
            b_salvar.setForeground(fundo);
            b_salvar.setFont(fonteBotao);
            b_salvar.setFocusPainted(false);

            b_salvar.addActionListener(ev -> {
                try {
                    String nome = fields[0].getText();
                    String artista = fields[1].getText();
                    String album = fields[2].getText();
                    int ano = Integer.parseInt(fields[3].getText());
                    int nota = Integer.parseInt(fields[4].getText());

                    track novaTrack = new track(nome, album, artista, ano, nota);
                    historico.add(novaTrack);

                    JOptionPane.showMessageDialog(F_cadastrarmusica,
                            "Música cadastrada:\n" +
                                    "Nome: " + nome + "\n" +
                                    "Artista: " + artista + "\n" +
                                    "Álbum: " + album + "\n" +
                                    "Ano: " + ano + "\n" +
                                    "Nota: " + nota,
                            "Sucesso",
                            JOptionPane.INFORMATION_MESSAGE
                    );
                    F_cadastrarmusica.dispose();

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(F_cadastrarmusica, "Ano e Nota devem ser números inteiros.");
                }
            });

            F_cadastrarmusica.add(new JLabel());
            F_cadastrarmusica.add(b_salvar);

            F_cadastrarmusica.setVisible(true);
        });

        b_historico.addActionListener(e -> {
            JFrame F_historico = new JFrame("Histórico de Avaliações");
            F_historico.setSize(new Dimension(350, 400));
            F_historico.setLocationRelativeTo(null);
            F_historico.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

            JLabel Hist = new JLabel();
            Hist.setVerticalAlignment(SwingConstants.TOP);
            Hist.setHorizontalAlignment(SwingConstants.LEFT);
            Hist.setFont(fonte);
            Hist.setForeground(texto);

            StringBuilder textoHist = new StringBuilder("<html><div style='padding:10px;color:#E0E0E0;'>");

            if (historico.isEmpty()) {
                textoHist.append("Nenhuma música cadastrada.");
            } else {
                for (track t : historico) {
                    textoHist.append(t.formatarEmTexto().replace("\n", "<br>"));
                    textoHist.append("<br><br>");
                }
            }

            textoHist.append("</div></html>");
            Hist.setText(textoHist.toString());

            JScrollPane scroll = new JScrollPane(Hist);
            scroll.getViewport().setBackground(fundo);
            scroll.setBackground(fundo);
            scroll.setBorder(null);

            F_historico.getContentPane().setBackground(fundo);
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
        frame.setSize(350, 480);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}

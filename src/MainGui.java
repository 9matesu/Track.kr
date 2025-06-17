package src;
import java.awt.*;
import javax.swing.*;

public class MainGui {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Track.kr");
        frame.setLayout(new FlowLayout());

        JButton b_cadastrarMusica = new JButton("Cadastrar Música");
        b_cadastrarMusica.setPreferredSize(new Dimension(200,50));
        
        JButton b_cadastrarMusica = new JButton("Cadastrar Música");
        b_cadastrarMusica.setPreferredSize(new Dimension(200,50));


        frame.add(b_cadastrarMusica);                         // adiciona botão no frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1200, 800);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}

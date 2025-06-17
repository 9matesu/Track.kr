package src;
import javax.swing.*;

public class MainGui {
    JFrame frame;

    public MainGui() {
        frame = new JFrame("Track.kr");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static class Botao extends JFrame {
    private JButton ok;
 
    public Botao(){
    super("Criando botões");

    ok = new JButton("OK");
    add(ok);
 }

}


    public static void main(String[] args) {
        new MainGui(); 

         Botao botao1 = new Botao();
  
        botao1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        botao1.setSize(350,80);
        botao1.setVisible(true);
    }
}

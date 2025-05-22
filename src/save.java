package src;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class save {

    // cria o arquivo lista.txt
       public static File cFile(){
         String homeDirectory = System.getProperty("user.home");
         File desktopDirectory = new File(homeDirectory, "Desktop");
        return new File (desktopDirectory, "lista.txt");
            }

            // uso em Main: chamar writeArquivo(texto);
            // deve formatar todas as variaveis para a variavel final texto, para escrever no arquvo;
            public static void writeArquivo(String texto){
                File file = cFile();
                try (FileWriter writer = new FileWriter(file, true)) {
                    writer.write(texto + "\n");
                    System.out.println("Conteudo escrito no arquivo" + texto);
                } catch (IOException e) {{
                    System.out.println("Erro ao escrever no arquivo" + e.getMessage());
                }}
            }




}

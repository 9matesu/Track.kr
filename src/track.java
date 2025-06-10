package src;
import java.util.Calendar; 

// declara variáveis para uso em vetores dentro de main

public class track {
    private String faixa;
    private String artista;
    private String album;
    private int ano;
    private int rate;
    private Calendar registrationDate; 

    // inicializa as variáveis para uso
    public track(String faixa, String artista, String album, int ano, int rate, Calendar registrationDate) {
        this.faixa = faixa;
        this.artista = artista;
        this.album = album;
        this.ano = ano;
        this.rate = rate;
        this.registrationDate = registrationDate;

    }

    // getters, para acessar essas variáveis em main, usar método do getter
    public String getFaixa(){
        return faixa;
    }
    public String getArtista(){
        return artista;
    }
    public String getAlbum(){
        return album;
    }
    public int getAno(){
        return ano;
    }
    public int getRate(){
        return rate;
    }
     public void setRate(int rate) {
        this.rate = rate;
    }
    public Calendar getRegistrationDate() {
        return registrationDate;
    }

    
    public String formatarEmTexto() {
        return "Faixa: " + faixa + "\nÁlbum: " + album + "\nArtista: " + artista + "\nAno: " + ano + "\nNota: 1" + rate + "\nData: " + registrationDate;
    }


     @Override
    public String toString() {
        String dateString = "N/A"; // Default if registrationDate is null
        if (registrationDate != null) {
            int day = registrationDate.get(Calendar.DAY_OF_MONTH);
            int month = registrationDate.get(Calendar.MONTH) + 1; // Calendar.MONTH is 0-indexed (Jan=0, Dec=11)
            int year = registrationDate.get(Calendar.YEAR);
            int hour = registrationDate.get(Calendar.HOUR_OF_DAY); // 24-hour format
            int minute = registrationDate.get(Calendar.MINUTE);

            // Using String.format to ensure two digits for day, month, hour, minute
            dateString = String.format("%02d/%02d/%d %02d:%02d", day, month, year, hour, minute);
            
        }

        return dateString;
}
}

package src;

// declara variáveis para uso em vetores dentro de main

public class Track {
    private String faixa;
    private String artista;
    private String album;
    private int ano;
    private int rate;

    // inicializa as variáveis para uso
    public Track(String faixa, String artista, String album, int ano, int rate) {
        this.faixa = faixa;
        this.artista = artista;
        this.album = album;
        this.ano = ano;
        this.rate = rate;
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
    
    public String formatarEmTexto() {
        return "Faixa: " + faixa + "\nÁlbum: " + album + "\nArtista: " + artista + "\nAno: " + ano + "\nNota: 1" + rate;
    }

}

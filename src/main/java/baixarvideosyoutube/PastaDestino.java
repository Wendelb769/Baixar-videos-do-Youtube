package baixarvideosyoutube;

public class PastaDestino {
    private String pasta = "Arquivos Baixados/%(title)s.%(ext)s";

    public PastaDestino(){
        
    }

    public String getPasta(){
        return pasta;

    }
}

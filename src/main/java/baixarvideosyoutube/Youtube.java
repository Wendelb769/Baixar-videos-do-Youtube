package baixarvideosyoutube;

public class Youtube {
    private String urlVideo;
    private String formatoDoVideo;
    private String formatoDoArquivo;
    private String formatoMp3 = "mp3";
    private String ytDlpExe = "yt-dlp/yt-dlp.exe";

    public Youtube(String urlVideo, String formatoDoVideo, String formatoDoArquivo){
        this.urlVideo = urlVideo;
        this.formatoDoVideo = formatoDoVideo;
        this.formatoDoArquivo = formatoDoArquivo;
    }

    public void setUrlVideo(String urlVideo){
        this.urlVideo = urlVideo;
    }

    public String getUrlVideo(){
        return urlVideo;
    }

    public void setFormatoDoVideo(String formatoDoVideo){
        this.formatoDoVideo = formatoDoVideo;
    }

    public String getFormatoDoVideo(){
        return formatoDoVideo;
    }

    public void setFormatoDoArquivo(String formatoDoArquivo){
        this.formatoDoArquivo = formatoDoArquivo;
    }

    public String getFormatoDoArquivo(){
        return formatoDoArquivo;
    }

    public String getFormatoMp3(){
        return formatoMp3;
    }

    public String getYtDlpExe(){
        return ytDlpExe;
    }
}

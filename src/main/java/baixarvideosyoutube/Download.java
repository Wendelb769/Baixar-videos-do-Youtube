package baixarvideosyoutube;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Download {

    Youtube yt = new Youtube(null, null, null);
    PastaDestino pd = new PastaDestino();
    Scanner sc = new Scanner(System.in);
    
    public void escolherFormatoDoArquivo(){
        String escolha;

        System.out.print("\nDeseja baixar o arquivo em MP4 ou MP3");
        System.out.print("\n[1] - MP4");
        System.out.print("\n[2] - MP3\n");
        System.out.print("\nInsira sua escolha: ");
        escolha = sc.nextLine();

        switch (escolha) {
            case "1":
                yt.setFormatoDoArquivo("-f");
                baixarMp4();
                break;

            case "2":
                yt.setFormatoDoArquivo("-x");
                baixarMp3();
                break;

            default:
            System.out.print("\nEsolha uma das duas opções disponíveis");
                break;
        }
    }

    public void baixarMp4(){
        String escolha;

        System.out.print("\nInsira a URL do video: ");
        yt.setUrlVideo(sc.nextLine());

        System.out.print("\nInsira o formato do video conforme as opções abaixo: ");
        System.out.print("\n[1] - Vídeo em melhor qualidade (COM ÁUDIO)\n");
        System.out.print("\nInsira sua escolha: ");
        escolha = sc.nextLine();

        switch (escolha) {
            case "1":
                yt.setFormatoDoVideo("bestvideo+bestaudio");
                try{
                    ProcessBuilder pb = new ProcessBuilder(yt.getYtDlpExe(), "--no-playlist", yt.getFormatoDoArquivo(), yt.getFormatoDoVideo(), "-o", pd.getPasta(), yt.getUrlVideo());
                    Process process = pb.start();
                    pb.redirectErrorStream(true);
        
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        
                    String linhaDeCarregamento;
                    while((linhaDeCarregamento = bufferedReader.readLine()) != null){
                        System.out.println(linhaDeCarregamento);
        
                    }
        
                    int exitCode = process.waitFor();
                    if(exitCode == 0){
                        System.out.print("\nDownload concluído com sucesso.\n");
                        escolherFormatoDoArquivo();

                    } else{
                        System.out.println("\nHouve algum erro, o arquivo não foi baixado.");
                        escolherFormatoDoArquivo();

                    }
        
                } catch(Exception e){
                    e.printStackTrace();
                }
        
            default:
                System.out.print("\nInsira uma das opções disponíveis.");
                baixarMp4();
                break;
        }

    }

    public void baixarMp3(){
        String escolha;

        System.out.print("\nInsira a URL do video: ");
        yt.setUrlVideo(sc.nextLine());

        System.out.print("\nInsira o formato do áudio conforme as opções abaixo: ");
        System.out.print("\n[1] - Música em melhor qualidade (EM MP3)\n");

        System.out.print("\nInsira sua escolha: ");
        escolha = sc.nextLine();
        
        switch (escolha) {
            case "1":
                yt.setFormatoDoVideo("--audio-format");

                try{
                    ProcessBuilder pb = new ProcessBuilder(yt.getYtDlpExe(), "--no-playlist", yt.getFormatoDoArquivo(), yt.getFormatoDoVideo(), yt.getFormatoMp3(), "-o", pd.getPasta(), yt.getUrlVideo());
                    Process process = pb.start();
                    pb.redirectErrorStream(true);
        
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        
                    String linhaDeCarregamento;
                    while((linhaDeCarregamento = bufferedReader.readLine()) != null){
                        System.out.println(linhaDeCarregamento);
        
                    }
        
                    int exitCode = process.waitFor();
                    if(exitCode == 0){
                        System.out.print("\nDownload concluído com sucesso.\n");
                        escolherFormatoDoArquivo();

                    } else{
                        System.out.println("\nHouve algum erro, o arquivo não foi baixado.");
                        escolherFormatoDoArquivo();

                    }
        
                } catch(Exception e){
                    e.printStackTrace();
                }

            default:
                System.out.print("\nInsira uma das opções disponíveis.");
                baixarMp4();
                break;
        }
    }
}

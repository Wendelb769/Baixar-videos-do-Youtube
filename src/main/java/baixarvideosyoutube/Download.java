package baixarvideosyoutube;

import java.util.Scanner;

public class Download {

    Youtube youtube = new Youtube(null);
    Scanner sc = new Scanner(System.in);
    
    public void baixarVideo(){

        System.out.print("\nInsira a URL do video: ");
        youtube.setUrlVideo(sc.nextLine());
        

    }
    
}

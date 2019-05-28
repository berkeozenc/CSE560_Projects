package DokuzTas;

import java.util.Scanner;

/*Oyuna göre değişecek*/
public class DortluDizi {

    public static void main(String[] args){
        Oyun oyun;
        int M, N;
        Scanner s = new Scanner(System.in);
        System.out.println("Satır sayısını giriniz:");
        M = s.nextInt();
        System.out.println("Sütun sayısını giriniz:");
        N = s.nextInt();
        oyun = new Oyun(M, N);
        oyun.oyna();
    }
}

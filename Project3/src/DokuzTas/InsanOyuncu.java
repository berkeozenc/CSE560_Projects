package DokuzTas;

import java.util.Scanner;

/*Oyuna göre değişecek*/
public class InsanOyuncu extends Oyuncu {

    public InsanOyuncu(String ad){
        super(ad, Renk.SARI, "YOU BEAT ME");
    }

    public int oyna(Tahta tahta){
        int sutun;
        System.out.println("Kocum oyna bir sutun:");
        Scanner s = new Scanner(System.in);
        sutun = s.nextInt();
        while (sutun < 0 || sutun >= tahta.getirSutun() || tahta.sutunDoluMu(sutun)){
            System.out.println("Kocum yanlis oynadin. Bir daha oyna:");
            sutun = s.nextInt();
        }
        return sutun;
    }

}

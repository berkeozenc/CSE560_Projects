package DokuzTas;

/*Oyuna göre değişecek*/
public class Oyun {
    private Oyuncu oyuncular[];
    private Tahta tahta;

    public Oyun(int M, int N){
        oyuncular = new Oyuncu[2];
        oyuncular[0] = new InsanOyuncu("Ilker");
        oyuncular[1] = new BilgisayarOyuncu("SkyNet", 5, DegerlendirmeFonksiyonuTipi.KARMASIK);
        tahta = new Tahta(M, N);
    }

    public void oyna(){
        int sutun, oyuncuIndeks = 0;
        while (true){
            if (oyuncuIndeks == 0){
                tahta.goster();
            }
            sutun = oyuncular[oyuncuIndeks].oyna(tahta);
            tahta.birak(sutun, oyuncular[oyuncuIndeks].getirRenk());
            if (tahta.oyunBitti()){
                if (tahta.doluMu()){
                    System.out.println("BERABERE!");
                } else {
                    if (oyuncuIndeks == 1){
                        tahta.goster();
                    }
                    System.out.println(oyuncular[oyuncuIndeks].getirKazanmaCumlesi());
                }
                break;
            }
            oyuncuIndeks = (oyuncuIndeks + 1) % 2;
        }
    }
}

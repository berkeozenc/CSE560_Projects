package DokuzTas;

import java.util.ArrayList;

/*Oyuna göre değişecek*/
public class Tahta_eski {
    private Tas tahta[][];
    private int satir, sutun;

    public Tahta_eski(int satir, int sutun){
        this.satir = satir;
        this.sutun = sutun;
        tahta = new Tas[satir][sutun];
        for (int i = 0; i < satir; i++){
            tahta[i] = new Tas[sutun];
            for (int j = 0; j < sutun; j++){
                tahta[i][j] = new Tas(Renk.BOS);
            }
        }
    }

    public ArrayList<Hareket> olasiHareketler() {
        Hareket olasiHareket;
        ArrayList<Hareket> hareketler = new ArrayList<Hareket>();
        for (int i = 0; i < sutun; i++) {
            if (!sutunDoluMu(i)) {
                olasiHareket = new Hareket(i);
                hareketler.add(olasiHareket);
            }
        }
        return hareketler;
    }

    public int getirSutun(){
        return sutun;
    }

    public boolean sutunDoluMu(int sutunIndeks){
        return (tahta[satir -1][sutunIndeks].getRenk() != Renk.BOS);
    }

    public boolean doluMu(){
        for (int i = 0; i < sutun; i++){
            if (!sutunDoluMu(i)){
                return false;
            }
        }
        return true;
    }

    public void geriAl(int sutun){
        Tas yeniTas;
        for (int i = satir - 1; i >= 0; i--){
            if (tahta[i][sutun].getRenk() != Renk.BOS){
                yeniTas = new Tas(Renk.BOS);
                tahta[i][sutun] = yeniTas;
                break;
            }
        }
    }

    public void birak(int sutun, Renk renk){
        Tas yeniTas;
        for (int i = 0; i < satir; i++){
            if (tahta[i][sutun].getRenk() == Renk.BOS){
                yeniTas = new Tas(renk);
                tahta[i][sutun] = yeniTas;
                break;
            }
        }
    }

    private boolean dogruHucreMi(int satirNo, int sutunNo){
        return (satirNo >= 0 && satirNo < satir && sutunNo >= 0 && sutunNo < sutun);
    }

    private int ucuAyniDizi(int satirNo, int sutunNo, Renk renk){
        int sayi, x, y, ucluSayisi = 0;
        int ekleme[][] = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
        for (int k = 0; k < 8; k++){
            sayi = 0;
            for (int l = 1; l < 4; l++){
                x = satirNo + l * ekleme[k][0];
                y = sutunNo + l * ekleme[k][1];
                if (dogruHucreMi(x, y) && tahta[x][y].getRenk() == renk){
                    sayi++;
                }
            }
            if (sayi == 2){
                ucluSayisi++;
            }
        }
        return ucluSayisi;
    }

    private Renk hucreyiKontrolEt(int satirNo, int sutunNo){
        int sayi, x, y;
        int ekleme[][] = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
        for (int k = 0; k < 8; k++){
            sayi = 0;
            for (int l = 1; l < 4; l++){
                x = satirNo + l * ekleme[k][0];
                y = sutunNo + l * ekleme[k][1];
                if (dogruHucreMi(x, y) && tahta[x][y].getRenk() == tahta[satirNo][sutunNo].getRenk()){
                    sayi++;
                }
            }
            if (sayi == 3 && tahta[satirNo][sutunNo].getRenk() != Renk.BOS){
                return tahta[satirNo][sutunNo].getRenk();
            }
        }
        return Renk.BOS;
    }

    public int ucuAyniDizi(Renk renk){
        int toplam = 0;
        for (int i = 0; i < satir; i++){
            for (int j = 0; j < sutun; j++){
                toplam += ucuAyniDizi(i, j, renk);
            }
        }
        return toplam;
    }

    public Renk dorduAyniDizi(){
        Renk sonuc;
        for (int i = 0; i < satir; i++){
            for (int j = 0; j < sutun; j++){
                sonuc = hucreyiKontrolEt(i, j);
                if (sonuc != Renk.BOS){
                    return sonuc;
                }
            }
        }
        return Renk.BOS;
    }

    public boolean oyunBitti(){
        return (dorduAyniDizi() != Renk.BOS || doluMu());
    }

    public void goster(){
        for (int i = satir - 1; i >= 0; i--){
            for (int j = 0; j < sutun; j++){
                switch (tahta[i][j].getRenk()){
                    case SARI:
                        System.out.print("X");
                        break;
                    case MAVI:
                        System.out.print("O");
                        break;
                    case BOS:
                        System.out.print("_");
                        break;
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}

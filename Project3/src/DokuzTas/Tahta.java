package DokuzTas;

import java.util.ArrayList;

/**
 *
 * @author haltay
 */
public class Tahta {

    private Tas tahta[];
    
    // bunu da dışarıda kontrol etmeli. Her hamleden sonra bir morris oldu mu diye sorulmalı.
    // eğer morris olmuş ise, o oyuncuya rakip taşı kaldırma hakkı verilmeli.
    private boolean morrisHappened = false;
    
    // bu aşağıdaki satırı koydum, fakat burada olmamalı.
    // dışarıda alternate etmeli. Şimdilik kalsın. Harun.
    private Renk oynamaSirasiSimdiBuRenkte;

    public Tas[] getTahta() {
        return tahta;
    }

    public Tahta() {
        tahta = new Tas[24];
        for (int i = 0; i < 24; i++) {
            tahta[i] = new Tas(Renk.BOS);
        }
        oynamaSirasiSimdiBuRenkte = Renk.MAVI;
    }

    public boolean rakipTasiKaldir(int input) {
        if (tahta[input].getRenk() == Renk.BOS) {
            return false;
        }
        if (tahta[input].getRenk() == oynamaSirasiSimdiBuRenkte) {
            return false;
        }
        if (!morrisHappened) {
            return false;
        }
        tahta[input] = new Tas(Renk.BOS);
        morrisHappened = false;
        return true;
    }

    public boolean tasKoy(int input, Tas tas) throws Exception {
        if (input < 0 || input > 23) {
            throw new Exception("input not in valid region");
        }
        morrisHappened = false;

        if (tahta[input].getRenk() != Renk.BOS) {
            return false;
        }

        tahta[input] = tas;

        morrisHappened = Morris.isCloseMorris(tahta, input);

        return true;
    }

    public boolean tasHareketEttir(int from, int to) throws Exception {
        if (from < 0 || from > 23) {
            throw new Exception("from not in valid region");
        }
        if (to < 0 || to > 23) {
            throw new Exception("to not in valid region");
        }
        if (from == to) {
            throw new Exception("from an to must not be equal");
        }

        morrisHappened = false;

        if (tahta[from].getRenk() == Renk.BOS) {
            return false;
        }
        // burada şimdiki oyuncunun kendi taşını mı hareket ettiriyor, kontrol edilmeli.
        if (tahta[to].getRenk() != Renk.BOS) {
            return false;
        }

        tahta[to] = tahta[from];
        tahta[from] = new Tas(Renk.BOS);

        morrisHappened = Morris.isCloseMorris(tahta, to);

        return true;
    }

    public ArrayList<Hareket> olasiHareketler(Renk renk) throws Exception {
        if (renk == Renk.BOS) {
            throw new Exception("Renk BOS olamaz");
        }

        Hareket olasiHareket;
        ArrayList<Hareket> hareketler = new ArrayList<Hareket>();
        for (int i = 0; i < tahta.length; i++) {
            if (tahta[i].getRenk().equals(Renk.BOS)) {
                continue;
            }
            if (!tahta[i].getRenk().equals(renk)) {
                continue;
            }

            int[] arr = Komsular.getKomsular(i);
            for (int j : arr) {
                if (!tahta[j].getRenk().equals(Renk.BOS)) {
                    continue;
                }
                olasiHareket = new Hareket(i, j);
                hareketler.add(olasiHareket);
            }
        }
        return hareketler;
    }

    public static void main(String argv[]) throws Exception {
        System.out.println("Merhaba Tahta9t");

        Tahta tahta = new Tahta();
//        for (int i = 0; i < tahta.tahta.length; i++) {
//            System.out.println(tahta.tahta[i].getRenk());
//        }
        tahta.tahta[0] = new Tas(Renk.MAVI);
        tahta.tahta[23] = new Tas(Renk.MAVI);
        tahta.tahta[2] = new Tas(Renk.SARI);
        ArrayList<Hareket> hareketler = tahta.olasiHareketler(Renk.MAVI);
        for (Hareket hareket : hareketler) {
            System.out.println(hareket);
        }

    }
}

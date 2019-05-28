package DokuzTas;

/*Oyuna göre değişecek*/
public class Durum {
    private Tahta tahta;
    private int derinlik;

    public Durum(Tahta tahta, int derinlik){
        this.tahta = tahta;
        this.derinlik = derinlik;
    }

    public Tahta getirTahta(){
        return tahta;
    }

    public int derinlikGetir(){
        return derinlik;
    }

    public void hareketEt(Hareket hareket, Renk renk){
        tahta.birak(hareket.getirSutun(), renk);
        derinlik++;
    }

    public void hareketiGeriAl(Hareket hareket){
        tahta.geriAl(hareket.getirSutun());
        derinlik--;
    }

}

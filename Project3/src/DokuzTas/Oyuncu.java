package DokuzTas;

/*Aynen kalacak*/
public abstract class Oyuncu {
    private String ad;
    private String kazanmaCumlesi;
    private Renk renk;

    public Oyuncu(){

    }

    public Oyuncu(String ad, Renk renk, String kazanmaCumlesi){
        this.ad = ad;
        this.renk = renk;
        this.kazanmaCumlesi = kazanmaCumlesi;
    }

    public Renk getirRenk(){
        return renk;
    }

    public String getirKazanmaCumlesi(){
        return kazanmaCumlesi;
    }

    public abstract int oyna(Tahta tahta);

}

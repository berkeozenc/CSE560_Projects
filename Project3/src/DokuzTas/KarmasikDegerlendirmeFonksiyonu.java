package DokuzTas;

/*Şimdilik oyuna göre basit bir şekilde değişecek*/
public class KarmasikDegerlendirmeFonksiyonu implements DegerlendirmeFonksiyonu {
    private Tahta tahta;

    public KarmasikDegerlendirmeFonksiyonu(Tahta tahta){
        this.tahta = tahta;
    }
    
    public double degerlendir(){
        if (tahta.dorduAyniDizi() == Renk.SARI){
            return -10;
        } else {
            if (tahta.dorduAyniDizi() == Renk.MAVI){
                return 10;
            } else {
                int birinciOyuncu = tahta.ucuAyniDizi(Renk.MAVI);
                int ikinciOyuncu = tahta.ucuAyniDizi(Renk.SARI);
                if (Math.max(birinciOyuncu, ikinciOyuncu) != 0){
                    return (birinciOyuncu - ikinciOyuncu + 0.0) / Math.max(birinciOyuncu, ikinciOyuncu);
                } else {
                    return 0;
                }
            }
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DokuzTas;

/**
 *
 * @author Berke
 */
public class BerkeDegerlendirmeFonksiyonu implements DegerlendirmeFonksiyonu {

    private Tahta tahta;
    
    @Override
    public double degerlendir() {
        if (tahta.goalCheck() == Renk.SARI){
            return -10;
        } 
        else{
            if (tahta.goalCheck() == Renk.MAVI){
                return 10;
            }
            else{
                
            }
        }
    }
    
}

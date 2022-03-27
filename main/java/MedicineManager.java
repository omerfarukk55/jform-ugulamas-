/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author MONSTER
 */
import java.util.ArrayList;

public class MedicineManager {


    public boolean yasUygunMu(int yas, int yasSiniri){

        if (yas >= yasSiniri){
            return true;
        }
        return false;
    }

    public boolean durumUygunMu(ArrayList<String> hastaDurumu, ArrayList<String> ilacDurumlari){

        for(String durum : hastaDurumu){
            for (String durum2 : ilacDurumlari){
                if (durum.equals(durum2)){
                    return false;
                }
            }
        }
        return true;
    }

    public boolean alerjenUygunMu(ArrayList<String> hastaAlerjisi, ArrayList<String> ilacAlerjenleri){
        for(String alerjen : hastaAlerjisi){
            for (String durum2 : ilacAlerjenleri){
                if (alerjen.equals(durum2)){
                    System.out.print(alerjen+" ");
                    return false;
                }
            }
        }
        return true;
    }


}

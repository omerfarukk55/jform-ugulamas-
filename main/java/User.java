import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class User {
    private String id;
    private String ad;
    private String soyad;
    private String tcKimlikNo;
    private String dogumTarihi;
    private String email;
    private String telefon;
    private String sifre;
    private String sifre2;
    private int yas;
    private boolean gizlilik=true;
    private ArrayList<String> durumlar = new ArrayList<String>();
    private ArrayList<String> alerjiler = new ArrayList<String>();
    public User(){

    }
    public User(String id, String ad, String soyad, String tcKimlikNo, String dogumTarihi, String email, String telefon, String sifre, String sifre2) {
        this.id = id;
        this.ad = ad;
        this.soyad = soyad;
        this.tcKimlikNo = tcKimlikNo;
        this.dogumTarihi = dogumTarihi;
        this.email = email;
        this.telefon = telefon;
        this.sifre = sifre;
        this.sifre2 = sifre2;
    }

    public User(int yas, ArrayList<String> durumlar, ArrayList<String> alerjiler) {
        if (yas < 0){
            this.yas = 0;
        }else {
            this.yas = yas;
        }
        this.durumlar = durumlar;
        this.alerjiler = alerjiler;
    }

    public boolean isGizlilik() {
        return gizlilik;
    }

    public void setGizlilik(boolean gizlilik) {
        this.gizlilik = gizlilik;
    }

    public String getId() {
        return id;
    }

    public String setId(int id) {

        return this.getAd().substring(0,2)+this.tcKimlikNo.substring(0,5);
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getSoyad() {
        return soyad;
    }

    public void setSoyad(String soyad) {
        this.soyad = soyad;
    }

    public String getTcKimlikNo() {
        return tcKimlikNo;
    }

    public void setTcKimlikNo(String tcKimlikNo) {
        this.tcKimlikNo = tcKimlikNo;
    }

    public String getDogumTarihi() {
        return dogumTarihi;
    }

    public void setDogumTarihi(String dogumTarihi) {
        this.dogumTarihi = dogumTarihi;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getSifre() {
        return sifre;
    }

    public void setSifre(String sifre) {
        this.sifre = sifre;
    }

    public String getSifre2() {
        return sifre2;
    }

    public void setSifre2(String sifre2) {
        this.sifre2 = sifre2;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getYas() {
        return yas;
    }

    public void setYas(int yas) {
        this.yas = yas;
    }

    public ArrayList<String> getDurumlar() {
        return durumlar;
    }

    public void setDurumlar(ArrayList<String> durumlar) {
        this.durumlar = durumlar;
    }

    public ArrayList<String> getAlerjiler() {
        return alerjiler;
    }

    public void setAlerjiler(ArrayList<String> alerjiler) {
        this.alerjiler = alerjiler;
    }
}
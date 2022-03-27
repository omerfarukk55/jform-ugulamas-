import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserManager {
    Database database=new Database();
    public void yeniKullaniciEkle(User user1){
        if(user1.getAd().length()==0) {

            System.out.println("Ad boş olamaz");
            return;
        }
        if(user1.getSoyad().equals("")) {
            System.out.println("Soyad boş bırakılamaz");

            return;
        }
        if(user1.getTcKimlikNo().equals("")) {
            System.out.println("Tc kimlik boş bırakılamaz");
            return;
        }
        if(user1.getDogumTarihi().equals("")) {
            System.out.println("Doğum tarihi boş geçilmez");
            return;
        }
        if(user1.getEmail().equals("")) {
            System.out.println("Eposta boş bırakılmaz");
            return;
        }

        if(user1.getSifre().equals("")) {
            System.out.println("Şifre boş geçilmez");
            return;
        }
        if(user1.getSifre2().equals("")) {
            System.out.println("Şifre boş geçilmez");
            return;
        }
        
        final String EMAIL_PATTERN = "^[A-Za-z0-9+_.-]+@(.+)$";
        final Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(user1.getEmail());
        if(!matcher.matches()){
            System.out.println(user1.getEmail()+" EPOSTA FORMATINA UYGUN DEĞİL.");
            return;
        }
        if (user1.getEmail().equals(database.email1)){
            System.out.println("Eposta once kullanmıs.");
            return;
        }
        System.out.println("Kullanıcı kaydedildi");
         user1.setGizlilik(false);
        add(user1);

    }
    public void giris(User user){
       
        boolean a=false;
        for(String lang:database.email1){
            if (user.getEmail().equals(lang)){

                for(String lang2:database.sifre1){
                    if (user.getSifre().equals(lang2)){
                        a=true;
                    }
                }
            }
        }
        if (a==true){
            System.out.println("Giriş başarılı");
            user.setGizlilik(true);

        }
        else {
            System.out.println("Giriş başarısız");
        }
    }
    public void add(User user){

        database.name.add(user.getAd());
        database.tcKimlikNo1.add(user.getTcKimlikNo());
        database.sifre1.add(user.getSifre());
        database.email1.add(user.getEmail());
        database.soyad1.add(user.getSoyad());
        database.dogumtarihi1.add(user.getDogumTarihi());
        database.telefon1.add(user.getDogumTarihi());

    }
    public void selectDurumlar(User user){
        String[] durumDizisi=
                {"1-) Hamilelik",
                        "2-) Karaciğer Yetmezliği",
                        "3-) Böbrek Yetmezliği",
                        "4-) Kalp Yetmezliği",
                        "0-) Çıkış"};
        for (String durum:durumDizisi) {
            System.out.println(durum);
        }

        System.out.println("Size ait durumların numarasını seçiniz: ");
        Scanner input = new Scanner(System.in);
        boolean devamMi = true;

        while (devamMi){
            int giris = input.nextInt();
            switch (giris){
                case 1: user.getDurumlar().add("Hamilelik"); break;
                case 2: user.getDurumlar().add("Karaciğer Yetmezliği"); break;
                case 3: user.getDurumlar().add("Böbrek Yetmezliği"); break;
                case 4: user.getDurumlar().add("Kalp Yetmezliği"); break;
                case 0: devamMi = false; break;
            }
        }
    }

    public void selectAlerjenler(User user){

        String[] alerjenDizisi=
                {"1-) Parasetamol",
                        "2-) Propranolol Hidroklorür",
                        "3-) Metoprolol süksinata",
                        "0-) Çıkış"};
        for (String durum:alerjenDizisi) {
            System.out.println(durum);
        }

        System.out.println("Size ait alerjenlerin numarasını seçiniz: ");
        Scanner input = new Scanner(System.in);
        boolean devamMi = true;
        while (devamMi){
            int giris = input.nextInt();

            switch (giris){
                case 1: user.getAlerjiler().add("Parasetamol"); break;
                case 2: user.getAlerjiler().add("Propranolol Hidroklorür"); break;
                case 3: user.getAlerjiler().add("Metoprolol süksinata"); break;
                case 0: devamMi = false; break;
            }
        }

    }
}
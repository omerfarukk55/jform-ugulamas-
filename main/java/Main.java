/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author MONSTER
 */
    import java.util.Scanner;

public class Main {



    public static void main(String[] args) {
        User user=new User();
        Scanner scanner=new Scanner(System.in);
        UserManager userManager=new UserManager();
        Database database=new Database();
        Medicines medicine1 = new Medicines("parol",5,18);
        
        MedicineManager manager = new MedicineManager();
          boolean kontrol=true;
        while(kontrol){
            System.out.println("Yapmak istedğiniz işlemi seçin:");
            System.out.println("1 kayıt olma");
            System.out.println("2 Kullanıcı girişi:");
            System.out.println("3 İlacı sorgulama:");
            System.out.println("4 Hasta alerjilerini hastalıklarını girme :");
            System.out.println("5 Çıkış yapılıyor:");
            String secim=scanner.nextLine();

            if (secim.equals("1")){
                System.out.println("adınızı girin");
                String ad=scanner.nextLine();
                System.out.println("soyad girin");
                String soyad=scanner.nextLine();
                System.out.println("Tc kimlik girin");
                String tc=scanner.nextLine();
                System.out.println("Doğum tarihi girin");
                String dogum=scanner.nextLine();
                System.out.println("Yaşınız:");
                int yas=scanner.nextInt();
                scanner.nextLine();
                System.out.println("email girin");
                String email=scanner.nextLine();
                System.out.println("telefon girin");
                String telefon=scanner.nextLine();
                System.out.println("Şifre girin");
                String sifre=scanner.nextLine();
                System.out.println("Şifre tekrar girin");
                String sifre2=scanner.nextLine();
                user.setAd(ad);
                user.setSoyad(soyad);
                user.setTcKimlikNo(tc);
                user.setDogumTarihi(dogum);
                user.setEmail(email);
                user.setTelefon(telefon);
                user.setYas(yas);
                user.setSifre(sifre);
                user.setSifre2(sifre2);
                userManager.yeniKullaniciEkle(user);
            }
            if (secim.equals("2")){
                System.out.println("email girin");
                String email=scanner.nextLine();

                System.out.println("Şifre girin");
                String sifre=scanner.nextLine();
                user.setEmail(email);
                user.setSifre(sifre);

                userManager.giris(user);

            }
            if (secim.equals("3")){
                if (user.isGizlilik()==true){
                    medicine1.addOnerilmeyenDurum("Hamilelik");
                    medicine1.addOnerilmeyenDurum("Karaciğer Yetmezliği");
                    medicine1.addAlerjen("Parasetamol");
                    medicine1.getMinimumYasSiniri();
                    if (manager.yasUygunMu(user.getYas(), medicine1.getMinimumYasSiniri())){
                        if (manager.durumUygunMu(user.getDurumlar(),medicine1.getAllOnerilmeyenDurumlar())){
                            if (manager.alerjenUygunMu(user.getAlerjiler(),medicine1.getAllAlerjenler())){
                                System.out.println(user.getAd()+" ilacını alabilirsiniz!");
                            } else {
                                System.out.println("Alerjenden dolayı alamazsınız!" +
                                        "\nIlacın alerjen maddeleri: "+medicine1.getAllAlerjenler());
                            }
                        } else {
                            System.out.println("Sağlık durumunuzdan dolayı alamazsınız!" +
                                    "\nIlaç, "+medicine1.getAllOnerilmeyenDurumlar()+" durumlarından en az birine sahip olan bireyler için uygun değildir.");
                        }
                    }else {
                        System.out.println("Yaş durumunuzdan dolayı alamazsınız!" +
                                "\nminimum yaş "+medicine1.getMinimumYasSiniri()+" olmalı.");
                    }
                }

            }

            if (user.isGizlilik()==true){
                if (secim.equals("4")){
                    userManager.selectDurumlar(user);
                    userManager.selectAlerjenler(user);
                }

            }
            if (secim.equals("5")){
                System.out.println("Çıkış yapıldı....");
                kontrol=false;
            }
        }}
}

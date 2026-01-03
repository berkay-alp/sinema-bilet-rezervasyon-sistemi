package com.sinema.app;

import com.sinema.model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Sinema Bilet Rezervasyon Sistemi
 * Console tabanlı ana uygulama sınıfı
 */
public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        /* ===============================
           ÖRNEK VERİLER (SİSTEM BAŞLANGICI)
           =============================== */

        // Müşteri
        Customer customer = new Customer("Berkay");

        // Filmler (Polimorfizm)
        Movie movie1 = new TwoDMovie("Inception", 100);
        Movie movie2 = new ThreeDMovie("Avatar", 120);
        Movie movie3 = new TwoDMovie("Interstellar", 110);
        Movie movie4 = new ThreeDMovie("Avengers: Endgame", 130);
        Movie movie5 = new TwoDMovie("The Dark Knight", 105);
        Movie movie6 = new ThreeDMovie("Dune", 125);
        Movie movie7 = new TwoDMovie("Joker", 95);


        // Seanslar
        ShowTime seans1 = new ShowTime(movie1, "14:00", 10);
        ShowTime seans2 = new ShowTime(movie2, "18:00", 10);
        ShowTime seans3 = new ShowTime(movie3, "12:00", 10);
        ShowTime seans4 = new ShowTime(movie3, "16:00", 10);

        ShowTime seans5 = new ShowTime(movie4, "13:30", 10);
        ShowTime seans6 = new ShowTime(movie4, "19:30", 10);

        ShowTime seans7 = new ShowTime(movie5, "11:00", 10);
        ShowTime seans8 = new ShowTime(movie5, "15:00", 10);

        ShowTime seans9 = new ShowTime(movie6, "14:30", 10);
        ShowTime seans10 = new ShowTime(movie6, "20:30", 10);

        ShowTime seans11 = new ShowTime(movie7, "10:30", 10);
        ShowTime seans12 = new ShowTime(movie7, "18:30", 10);

        

        List<ShowTime> seanslar = new ArrayList<>();
        seanslar.add(seans1);
        seanslar.add(seans2);

        seanslar.add(seans3);
        seanslar.add(seans4);

        seanslar.add(seans5);
        seanslar.add(seans6);

        seanslar.add(seans7);
        seanslar.add(seans8);

        seanslar.add(seans9);
        seanslar.add(seans10);

        seanslar.add(seans11);
        seanslar.add(seans12);


        int secim;

        /* ===============================
           ANA MENÜ DÖNGÜSÜ
           =============================== */
        do {
        	System.out.println("======================================");
        	System.out.println("   SİNEMA BİLET REZERVASYON SİSTEMİ   ");
        	System.out.println("======================================");
        	System.out.println("1 - Film ve seansları listele");
        	System.out.println("2 - Rezervasyon yap");
        	System.out.println("3 - Rezervasyon geçmişini göster");
        	System.out.println("0 - Çıkış");
        	System.out.println("--------------------------------------");
        	System.out.print("Seçiminiz: ");


            secim = scanner.nextInt();

            switch (secim) {

                /* ===============================
                   1 - FİLM VE SEANSLARI LİSTELE
                   =============================== */
            case 1:
            	System.out.println();
            	System.out.println("========== VİZYONDAKİ FİLMLER ==========");


                for (int i = 0; i < seanslar.size(); i++) {
                    ShowTime s = seanslar.get(i);
                    Movie film = s.getFilm();

                    System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
                    System.out.println("Seçim No : " + (i + 1));
                    System.out.println("🎬 Film  : " + film.getFilmAdi());
                    System.out.println("⏰ Seans : " + s.getSeansSaati());
                    System.out.println("🎞️ Tür   : " +
                            (film instanceof ThreeDMovie ? "3D" : "2D"));
                    System.out.println("💰 Fiyat : " + film.fiyatHesapla() + " TL");
                    System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━\n");
                }
                break;


                /* ===============================
                   2 - REZERVASYON YAP
                   =============================== */
                case 2:
                    System.out.println("\n--- Rezervasyon Yap ---");

                    // Seans seçimi
                    System.out.println("Bir seans seçiniz:");
                    for (int i = 0; i < seanslar.size(); i++) {
                        System.out.println((i + 1) + " - " +
                                seanslar.get(i).getFilm().getFilmAdi() +
                                " (" + seanslar.get(i).getSeansSaati() + ")");
                    }

                    int seansSecim = scanner.nextInt() - 1;

                    if (seansSecim < 0 || seansSecim >= seanslar.size()) {
                        System.out.println("Geçersiz seans seçimi!");
                        break;
                    }

                    ShowTime secilenSeans = seanslar.get(seansSecim);

                    // Koltuk seçimi
                    
                    secilenSeans.koltuklariGoster();
                    System.out.println();
                    System.out.println("========== KOLTUK DURUMU ==========");


                    int koltukNo = scanner.nextInt();

                    Seat secilenKoltuk = secilenSeans.getSeat(koltukNo);

                    if (secilenKoltuk == null || !secilenKoltuk.isAvailable()) {
                        System.out.println("Bu koltuk dolu veya geçersiz!");
                        break;
                    }

                    // Rezervasyon
                    Booking booking = new Booking(customer, secilenSeans, secilenKoltuk);
                    booking.onayla();

                    double odenecekTutar = secilenSeans.biletFiyatiHesapla();
                    double normalFiyat = secilenSeans.getFilm().fiyatHesapla();

                    System.out.println("\n✅ REZERVASYON BAŞARILI!");
                    System.out.println("🎬 Film  : " + secilenSeans.getFilm().getFilmAdi());
                    System.out.println("⏰ Seans : " + secilenSeans.getSeansSaati());
                    System.out.println("🪑 Koltuk: " + secilenKoltuk.getKoltukNumarasi());

                    if (odenecekTutar < normalFiyat) {
                        System.out.println("🎉 TEBRİKLER!");
                        System.out.println("Bu seansın ilk 3 biletinden birini aldınız.");
                        System.out.println("%20 indirim kazandınız!");
                        System.out.println("💸 Normal Fiyat : " + normalFiyat + " TL");
                        System.out.println("💰 İndirimli Fiyat : " + odenecekTutar + " TL");
                    } else {
                        System.out.println("💰 Bilet Fiyatı : " + normalFiyat + " TL");
                    }



                    break;

                /* ===============================
                   3 - REZERVASYON GEÇMİŞİ
                   =============================== */
                case 3:
                    System.out.println("\n--- Rezervasyon Geçmişi ---");
                    customer.rezervasyonlariGoster();
                    break;

                case 0:
                    System.out.println("Çıkış yapıldı");
                    break;

                default:
                    System.out.println("Geçersiz seçim!");
            }

        } while (secim != 0);

        scanner.close();
    }
}

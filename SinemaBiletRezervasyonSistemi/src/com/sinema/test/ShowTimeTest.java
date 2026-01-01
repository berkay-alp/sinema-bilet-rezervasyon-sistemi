package com.sinema.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.sinema.model.*;

public class ShowTimeTest {
	
	

    @Test
    public void ilkUcBiletIndirimliOlmali() {

        // Film
        Movie film = new TwoDMovie("Test Film", 100);

        // Seans
        ShowTime seans = new ShowTime(film, "14:00", 10);

        // 1. bilet sat
        Seat koltuk1 = seans.getSeat(1);
        Booking booking1 = new Booking(new Customer("Ali"), seans, koltuk1);
        booking1.onayla();

        // Fiyatı al
        double fiyat = seans.biletFiyatiHesapla();

        // Beklenen: %20 indirim
        assertEquals(80.0, fiyat, 0.01);
    }
    
    /**
     * ShowTime sınıfına ait business logic kurallarını test eden JUnit test sınıfıdır.
     *
     * <p>Bu test sınıfı özellikle:</p>
     * <ul>
     *   <li>İlk biletlerde uygulanan indirim kuralını</li>
     *   <li>İndirim sınırının aşılması durumunu</li>
     * </ul>
     * doğrulamak amacıyla oluşturulmuştur.
     */

    
    @Test
    public void dorduncuBiletIndirimsizOlmali() {

        // Film
        Movie film = new TwoDMovie("Test Film", 100);

        // Seans
        ShowTime seans = new ShowTime(film, "16:00", 10);

        // İlk 3 bilet (indirimli)
        for (int i = 1; i <= 3; i++) {
            Seat koltuk = seans.getSeat(i);
            new Booking(new Customer("Musteri" + i), seans, koltuk).onayla();
        }

        // 4. bilet
        Seat dorduncuKoltuk = seans.getSeat(4);
        new Booking(new Customer("Musteri4"), seans, dorduncuKoltuk).onayla();

        // Fiyatı kontrol et
        double fiyat = seans.biletFiyatiHesapla();

        // Beklenen: normal fiyat
        assertEquals(100.0, fiyat, 0.01);
    }

}

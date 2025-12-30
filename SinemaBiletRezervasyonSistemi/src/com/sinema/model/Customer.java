package com.sinema.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Customer sınıfı sistemde bilet alan müşteriyi temsil eder.
 */
public class Customer {

    private String ad;
    private List<Booking> rezervasyonlar;

    /**
     * Yeni bir müşteri oluşturur.
     *
     * @param ad Müşterinin adı
     */
    public Customer(String ad) {
        this.ad = ad;
        this.rezervasyonlar = new ArrayList<>();
    }

    /**
     * Müşterinin rezervasyon listesine yeni rezervasyon ekler.
     */
    public void rezervasyonEkle(Booking booking) {
        rezervasyonlar.add(booking);
    }

    public String getAd() {
        return ad;
    }

    public List<Booking> getRezervasyonlar() {
        return rezervasyonlar;
    }
    /**
     * Müşterinin yaptığı tüm rezervasyonları listeler.
     */
    public void rezervasyonlariGoster() {

        if (rezervasyonlar.isEmpty()) {
            System.out.println("Henüz rezervasyon bulunmamaktadır.");
            return;
        }

        for (Booking booking : rezervasyonlar) {
            System.out.println(
                    "Film: " + booking.getShowTime().getFilm().getFilmAdi() +
                    " | Seans: " + booking.getShowTime().getSeansSaati() +
                    " | Koltuk: " + booking.getSeat().getKoltukNumarasi() +
                    " | Tarih: " + booking.getRezervasyonTarihi()
            );
        }
    }

}

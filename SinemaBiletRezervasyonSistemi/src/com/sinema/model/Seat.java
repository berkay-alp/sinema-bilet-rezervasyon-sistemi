package com.sinema.model;

import com.sinema.interfaces.Bookable;

/**
 * Seat sınıfı sinema salonundaki bir koltuğu temsil eder.
 * Koltuklar rezervasyon yapılabilir (Bookable).
 */
public class Seat implements Bookable {

    private int koltukNumarasi;
    private boolean musait;

    /**
     * Yeni bir koltuk oluşturur.
     *
     * @param koltukNumarasi Koltuğun numarası
     */
    public Seat(int koltukNumarasi) {
        this.koltukNumarasi = koltukNumarasi;
        this.musait = true; // Başlangıçta koltuk boştur
    }

    /**
     * Koltuğun müsait olup olmadığını döndürür.
     */
    @Override
    public boolean isAvailable() {
        return musait;
    }

    /**
     * Koltuğu rezerve eder.
     */
    @Override
    public void book() {
        if (musait) {
            musait = false;
        }
    }

    public int getKoltukNumarasi() {
        return koltukNumarasi;
    }
}

package com.sinema.model;

import java.time.LocalDateTime;

/**
 * Booking sınıfı bir koltuk rezervasyonunu temsil eder.
 */
public class Booking {

    private Customer customer;
    private ShowTime showTime;
    private Seat seat;
    private LocalDateTime rezervasyonTarihi;

    /**
     * Yeni bir rezervasyon oluşturur.
     *
     * @param customer Rezervasyonu yapan müşteri
     * @param showTime Rezervasyon yapılan seans
     * @param seat Rezerve edilen koltuk
     */
    public Booking(Customer customer, ShowTime showTime, Seat seat) {
        this.customer = customer;
        this.showTime = showTime;
        this.seat = seat;
        this.rezervasyonTarihi = LocalDateTime.now();
    }

    /**
     * Rezervasyonu onaylar.
     *
     * @return Rezervasyon başarılıysa true
     */
    public boolean rezervasyonuOnayla() {
        if (seat.isAvailable()) {
            seat.book();
            customer.rezervasyonEkle(this);
            return true;
        }
        return false;
    }
    
    /**
     * Rezervasyonu onaylar ve koltuğu rezerve eder.
     */
    public void onayla() {
        rezervasyonuOnayla();
    }


    public Customer getCustomer() {
        return customer;
    }

    public ShowTime getShowTime() {
        return showTime;
    }

    public Seat getSeat() {
        return seat;
    }

    public LocalDateTime getRezervasyonTarihi() {
        return rezervasyonTarihi;
    }
}

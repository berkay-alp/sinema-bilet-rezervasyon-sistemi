package com.sinema.test;

import static org.junit.Assert.assertFalse;
import org.junit.Test;

import com.sinema.model.*;

public class BookingTest {

    @Test
    public void rezervasyonOnaylanincaKoltukDoluyorMu() {
        Movie film = new TwoDMovie("Test Film", 100);
        ShowTime seans = new ShowTime(film, "18:00", 5);
        Seat seat = seans.getSeat(1);
        Customer customer = new Customer("Ali");

        Booking booking = new Booking(customer, seans, seat);
        booking.onayla();

        // Rezervasyon sonrası koltuk dolu olmalı
        assertFalse(seat.isAvailable());
    }
}

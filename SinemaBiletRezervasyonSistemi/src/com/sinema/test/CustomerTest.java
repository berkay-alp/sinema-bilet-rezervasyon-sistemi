package com.sinema.test;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import com.sinema.model.*;

public class CustomerTest {

    @Test
    public void rezervasyonMusteriyeEkleniyorMu() {
        Customer customer = new Customer("Ayşe");

        Movie film = new TwoDMovie("Test Film", 100);
        ShowTime seans = new ShowTime(film, "16:00", 5);
        Seat seat = seans.getSeat(1);

        Booking booking = new Booking(customer, seans, seat);
        booking.onayla();

        // Müşterinin rezervasyon listesine eklendi mi?
        assertEquals(1, customer.getRezervasyonlar().size());
    }
}

package com.sinema.test;

import static org.junit.Assert.assertTrue;
import org.junit.Test;

import com.sinema.model.Seat;

public class SeatTest {

    @Test
    public void koltukBaslangictaBosMu() {
        Seat seat = new Seat(1);
        assertTrue(seat.isAvailable());
    }
}

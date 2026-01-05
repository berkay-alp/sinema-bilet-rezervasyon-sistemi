package com.sinema.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.sinema.model.Movie;
import com.sinema.model.TwoDMovie;
import com.sinema.model.ThreeDMovie;

public class MovieTypeTest {

    /**
     * 2D filmler için fiyat hesaplamanın doğru çalışıp çalışmadığını test eder.
     */
    @Test
    public void twoDMovieFiyatTesti() {
        Movie film2D = new TwoDMovie("2D Test Film", 100);
        assertEquals(100.0, film2D.fiyatHesapla(), 0.01);
    }

    /**
     * 3D filmler için fiyatın 2D filme göre daha yüksek olduğunu test eder.
     */
    @Test
    public void threeDMovieFiyatTesti() {
        Movie film3D = new ThreeDMovie("3D Test Film", 100);
        assertTrue(film3D.fiyatHesapla() > 100);
    }
}

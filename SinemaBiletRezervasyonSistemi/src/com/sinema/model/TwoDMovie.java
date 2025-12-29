package com.sinema.model;

/**
 * TwoDMovie sınıfı 2D filmleri temsil eder.
 * Movie sınıfından türetilmiştir.
 */
public class TwoDMovie extends Movie {

    /**
     * 2D film oluşturur.
     */
    public TwoDMovie(String filmAdi, double temelFiyat) {
        super(filmAdi, temelFiyat);
    }

    /**
     * 2D filmlerde fiyat, temel fiyattır.
     */
    @Override
    public double fiyatHesapla() {
        return temelFiyat;
    }
}

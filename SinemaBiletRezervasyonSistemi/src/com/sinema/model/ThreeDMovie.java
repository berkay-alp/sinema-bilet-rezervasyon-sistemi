package com.sinema.model;

/**
 * ThreeDMovie sınıfı 3D filmleri temsil eder.
 * 3D filmler için ekstra ücret uygulanır.
 */
public class ThreeDMovie extends Movie {

    // 3D film için ek ücret
    private static final double EK_UCRET = 20.0;

    /**
     * 3D film oluşturur.
     */
    public ThreeDMovie(String filmAdi, double temelFiyat) {
        super(filmAdi, temelFiyat);
    }

    /**
     * 3D filmlerde fiyat, temel fiyata ek ücret eklenerek hesaplanır.
     */
    @Override
    public double fiyatHesapla() {
        return temelFiyat + EK_UCRET;
    }
}

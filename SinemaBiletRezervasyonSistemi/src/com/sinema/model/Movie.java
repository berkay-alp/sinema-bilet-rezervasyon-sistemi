package com.sinema.model;

/**
 * Movie sınıfı bir filmi temsil eder.
 * Bu sınıf soyuttur, yani doğrudan nesnesi oluşturulamaz.
 * 2D ve 3D filmler bu sınıftan türetilir.
 */
public abstract class Movie {

    // Filmin adı (örnek: Avatar)
    protected String filmAdi;

    // Filmin temel fiyatı (2D fiyatı gibi düşünebilirsin)
    protected double temelFiyat;

    /**
     * Movie sınıfının yapıcı metodu (constructor).
     * Film adı ve temel fiyat buradan atanır.
     */
    public Movie(String filmAdi, double temelFiyat) {
        this.filmAdi = filmAdi;
        this.temelFiyat = temelFiyat;
    }

    /**
     * Filmin fiyatını döndüren metot.
     * Bu metot soyuttur.
     * Yani 2D ve 3D filmler kendi fiyat hesaplarını yazmak zorundadır.
     */
    public abstract double fiyatHesapla();

    /**
     * Filmin adını döndürür.
     */
    public String getFilmAdi() {
        return filmAdi;
    }

    /**
     * Filmin temel fiyatını döndürür.
     */
    public double getTemelFiyat() {
        return temelFiyat;
    }
}

package com.sinema.interfaces;

/**
 * Bookable arayüzü, rezervasyon yapılabilen
 * nesneler için ortak davranışları tanımlar.
 */
public interface Bookable {

    /**
     * Rezervasyon yapılıp yapılamayacağını kontrol eder.
     * 
     * @return true ise rezervasyon yapılabilir
     */
    boolean isAvailable();

    /**
     * Rezervasyon işlemini gerçekleştirir.
     */
    void book();
}

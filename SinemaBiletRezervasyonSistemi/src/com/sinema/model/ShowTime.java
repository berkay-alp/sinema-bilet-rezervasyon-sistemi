package com.sinema.model;

import java.util.ArrayList;
import java.util.List;

/**
 * ShowTime sınıfı bir filmin belirli bir saatteki
 * seansını temsil eder.
 */
public class ShowTime {

    private Movie film;
    private String seansSaati;
    private List<Seat> koltuklar;

    /**
     * Yeni bir seans oluşturur.
     *
     * @param film Gösterilecek film
     * @param seansSaati Seans saati
     * @param koltukSayisi Salondaki toplam koltuk sayısı
     */
    public ShowTime(Movie film, String seansSaati, int koltukSayisi) {
        this.film = film;
        this.seansSaati = seansSaati;
        this.koltuklar = new ArrayList<>();

        // Koltukları otomatik oluştur
        for (int i = 1; i <= koltukSayisi; i++) {
            koltuklar.add(new Seat(i));
        }
    }

    /**
     * Seanstaki tüm koltukları döndürür.
     */
    public List<Seat> getKoltuklar() {
        return koltuklar;
    }

    /**
     * Sadece boş koltukları döndürür.
     */
    public List<Seat> getMusaitKoltuklar() {
        List<Seat> musaitKoltuklar = new ArrayList<>();
        for (Seat seat : koltuklar) {
            if (seat.isAvailable()) {
                musaitKoltuklar.add(seat);
            }
        }
        return musaitKoltuklar;
    }

    /**
     * Koltuk numarasına göre koltuk döndürür.
     */
    public Seat koltukBul(int koltukNumarasi) {
        for (Seat seat : koltuklar) {
            if (seat.getKoltukNumarasi() == koltukNumarasi) {
                return seat;
            }
        }
        return null;
    }

    public Movie getFilm() {
        return film;
    }

    public String getSeansSaati() {
        return seansSaati;
    }
    
    public void koltuklariGoster() {

        System.out.println("\n🪑 KOLTUK HARİTASI");
        System.out.println("[X] = DOLU   [ ] = BOŞ\n");

        int kolon = 5; // 1 satırda kaç koltuk olacak

        for (int i = 0; i < koltuklar.size(); i++) {
            Seat seat = koltuklar.get(i);

            if (seat.isAvailable()) {
                System.out.printf("[ %2d ] ", seat.getKoltukNumarasi());
            } else {
                System.out.print("[  X ] ");
            }

            if ((i + 1) % kolon == 0) {
                System.out.println();
            }
        }
        System.out.println();
    }

    public Seat getSeat(int koltukNumarasi) {
        for (Seat seat : koltuklar) {
            if (seat.getKoltukNumarasi() == koltukNumarasi) {
                return seat;
            }
        }
        return null;
    }

    /**
     * Seanstaki boş koltuk sayısını döndürür.
     */
    public int bosKoltukSayisi() {
        int sayac = 0;
        for (Seat seat : koltuklar) {
            if (seat.isAvailable()) {
                sayac++;
            }
        }
        return sayac;
    }

    /**
     * Seans için geçerli bilet fiyatını döndürür.
     * İlk 3 bilettte %%20 indirim uygulanır.
     */
    public double biletFiyatiHesapla() {

        double normalFiyat = film.fiyatHesapla();

        if (satilanKoltukSayisi() < 3) {
            return normalFiyat * 0.8; // %20 indirim
        }

        return normalFiyat;
    }


    /**
     * Seanstaki satılmış koltuk sayısını döndürür.
     */
    public int satilanKoltukSayisi() {
        int sayac = 0;
        for (Seat seat : koltuklar) {
            if (!seat.isAvailable()) {
                sayac++;
            }
        }
        return sayac;
    }


}

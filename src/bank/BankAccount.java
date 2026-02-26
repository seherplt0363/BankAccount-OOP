package bank;

import java.util.ArrayList;

public abstract class BankAccount {

    private String hesapno;
    private String hesapsahibi;
    protected double bakiye;

    private ArrayList<Transcation> islemler = new ArrayList<>();

    public BankAccount(String hesapno, String hesapsahibi, double bakiye) {
        this.hesapno = hesapno;
        this.hesapsahibi = hesapsahibi;
        this.bakiye = bakiye;
    }

    public String getHesapno() {
        return hesapno;
    }

    public String getHesapsahibi() {
        return hesapsahibi;
    }

    public double getBakiye() {
        return bakiye;
    }

    public void setBakiye(double bakiye) {
        this.bakiye = bakiye;
    }

    public void setHesapno(String hesapno) {
        this.hesapno = hesapno;
    }

    public void setHesapsahibi(String hesapsahibi) {
        this.hesapsahibi = hesapsahibi;
    }

    public void parayatir(double miktar) {
        if (miktar > 0) {
            bakiye += miktar;
            System.out.println(miktar + " TL yatırıldı. Yeni Bakiye: " + bakiye);
            islemEkle("Para Yatırma", miktar, "Hesaba para yatırıldı");
        } else {
            System.out.println("Geçersiz miktar!");
        }
    }

    public void paraçek(double miktar) {
        if (miktar > bakiye) {
            System.out.println("Bakiye yetersiz! Bakiye: " + bakiye);
        } else if (miktar > 0) {
            bakiye -= miktar;
            System.out.println(miktar + " TL çekildi. Yeni Bakiye: " + bakiye);
            islemEkle("Para Çekme", miktar, "Hesaptan para çekildi");
        }
    }

    public void islemEkle(String tip, double miktar, String aciklama) {
        islemler.add(new Transcation(tip, miktar, aciklama));
    }

    public void islemleriGoster() {
        if (islemler.isEmpty()) {
            System.out.println("Bu hesapta hiç işlem yok.");
            return;
        }

        System.out.println("=== İşlem Geçmişi (" + hesapno + ") ===");
        for (Transcation t : islemler) {
            t.yazdir();
        }
    }

    public abstract String hesaptipi();
}


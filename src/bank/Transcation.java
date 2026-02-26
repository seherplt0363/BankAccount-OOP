package bank;

import java.time.LocalDateTime;

public class Transcation {
    private  String tip;
    private  double miktar;
    private LocalDateTime tarih;
    private  String açıklama;


    public Transcation(String tip,double miktar,String açıklama){
        this.tip=tip;
        this.miktar=miktar;
        this.tarih=LocalDateTime.now();
        this.açıklama=açıklama;

    }
    public void yazdir() {
        System.out.println(tarih + " | " + tip + " | " + miktar + " TL | " + açıklama);
    }
}

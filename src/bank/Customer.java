package bank;

import java.util.ArrayList;

public class Customer {
    private  String isim;
    private ArrayList<BankAccount>  hesaplar;

    public  Customer(String isim){
        this.isim=isim;
        this.hesaplar=new ArrayList<>();  //hesaplar boş bir liste olarak başlatılıyor //
    }

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }
    public  void hesapekle(BankAccount hesap){
        hesaplar.add(hesap);
        System.out.println(hesap.hesaptipi()+" eklendi "+hesap.getHesapno());
    }

    public  void  hesaplarılistele(){
        System.out.println(isim +" müsterinin hesapları ");
        for(BankAccount hesap : hesaplar){
            System.out.println("--"+hesap.hesaptipi()+"/ no : "+hesap.getHesapno()+" bakiye "+hesap.getBakiye());
        }}

        public BankAccount hesapBul(String hesapNo) {
            for(BankAccount hesap : hesaplar) {
                if(hesap.getHesapno().equals(hesapNo)) {
                    return hesap;
                }
            }
            return null;
        }
    public boolean hesapSil(String hesapNo) {
        for (BankAccount hesap : hesaplar) {
            if (hesap.getHesapno().equals(hesapNo)) {
                hesaplar.remove(hesap);
                System.out.println(hesapNo + " numaralı hesap silindi.");
                return true;
            }
        }
        System.out.println("Hesap bulunamadı.");
        return false;
    }


    }




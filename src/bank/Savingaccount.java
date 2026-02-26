package bank;

public class Savingaccount  extends  BankAccount{
    private  double faizoranı;
    public  Savingaccount(String hesapno, String hesapsahibi, double bakiye, double faizoranı){
        super(hesapno,hesapsahibi,bakiye);
        this.faizoranı=faizoranı;
    }
    public  void  faizekle(double miktar){
        bakiye=bakiye+ ((bakiye*faizoranı)/100);
        System.out.println("faiz eklendii yeni bakiyeniz : "+bakiye);
    }
    @Override
    public  String hesaptipi(){
        return "saving account";
    }

}

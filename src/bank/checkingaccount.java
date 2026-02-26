package bank;

public class checkingaccount extends  BankAccount{
    public  checkingaccount(String hesapno,String  hesapsahibi,double bakiye){
        super(hesapno,hesapsahibi,bakiye);
    }

    @Override
    public  String hesaptipi(){
        return  "chechk account";
    }

}

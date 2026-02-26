package bank;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== BANKA SISTEMI =====");
            System.out.println("1 - Müşteri Ekle");
            System.out.println("2 - Hesap Ekle");
            System.out.println("3 - Para Yatır");
            System.out.println("4 - Para Çek");
            System.out.println("5 - Havale Yap");
            System.out.println("6 - Müşterileri Listele");
            System.out.println("7 - hesap silme ");
            System.out.println("8 - Müşteri Sil");
            System.out.println("9 - işlem geçmişini göster");
            System.out.println("0 - Çıkış");
            System.out.print("Seçim: ");
            int secim = scanner.nextInt();
            scanner.nextLine(); // satır temizle

            if (secim == 0) {
                System.out.println("Çıkış yapıldı.");
                break;
            }
            switch (secim) {
                case 1: //müşteri ekleme
                    System.out.println("müşteri adı :");
                    String isim = scanner.nextLine();
                    bank.addCustomer(new Customer(isim));
                    break;
                case 2:
                    System.out.println("müşteri adı :");
                    String müşteriisim = scanner.nextLine();
                    Customer c = bank.findCustomer(müşteriisim);

                    if (c == null) {
                        System.out.println("müşteri bbulunamadı ");
                        break;
                    }
                    System.out.println("hesap  no ");
                    String hesapno = scanner.nextLine();

                    System.out.println("1 - Checking Account");
                    System.out.println("2 - Saving Account");
                    System.out.print("Hesap tipi: ");

                    int tip = scanner.nextInt();
                    if (tip == 1) {
                        System.out.println("bakiyeniz");
                        int bakiye=scanner.nextInt();
                        c.hesapekle(new checkingaccount(hesapno, müşteriisim, bakiye));
                    } else if (tip == 2) {
                        System.out.println("bakiyeniz : ");
                        int bakiye=scanner.nextInt();
                        System.out.println("faiz oranını giriniz:");
                        double faiz = scanner.nextDouble();
                        scanner.nextLine();

                        c.hesapekle(new Savingaccount(hesapno, müşteriisim, bakiye, faiz));
                    } else {
                        System.out.println("Geçersiz seçim!");
                    }
                    break;
                case 3:
                    System.out.println("müsteri adını giriniz ");
                    String musteriadi=scanner.nextLine();
                    Customer c1 = bank.findCustomer(musteriadi);

                    if(c1 == null){
                        System.out.println("Müşteri bulunamadı!");
                        break;
                    }

                    
                    if(c1==null){
                        System.out.println("müşteri bulunamadı ");
                        break;
                    }
                    System.out.print("Hesap No: ");
                    String yatirHesap = scanner.nextLine();
                    BankAccount h1 = c1.hesapBul(yatirHesap);

                    if (h1 == null) {
                        System.out.println("Hesap bulunamadı!");
                        break;
                    }

                    System.out.print("Yatırılacak miktar: ");
                    double miktarYatir = scanner.nextDouble();
                    scanner.nextLine();

                    h1.parayatir(miktarYatir);
                    break;


                case 4: // Para çek
                    System.out.print("Müşteri adı: ");
                    String cekMusteri = scanner.nextLine();
                    Customer c2 = bank.findCustomer(cekMusteri);

                    if (c2 == null) {
                        System.out.println("Müşteri bulunamadı!");
                        break;
                    }

                    System.out.print("Hesap No: ");
                    String cekHesap = scanner.nextLine();
                    BankAccount h2 = c2.hesapBul(cekHesap);

                    if (h2 == null) {
                        System.out.println("Hesap bulunamadı!");
                        break;
                    }

                    System.out.print("Çekilecek miktar: ");
                    double miktarCek = scanner.nextDouble();
                    scanner.nextLine();

                    h2.paraçek(miktarCek);
                    break;

                case 5: // HAVALE
                    System.out.print("Gönderen müşteri adı: ");
                    String gAdi = scanner.nextLine();

                    System.out.print("Gönderen hesap no: ");
                    String gHesap = scanner.nextLine();

                    System.out.print("Alıcı müşteri adı: ");
                    String aAdi = scanner.nextLine();

                    System.out.print("Alıcı hesap no: ");
                    String aHesap = scanner.nextLine();

                    System.out.print("Tutar: ");
                    double tutar = scanner.nextDouble();
                    scanner.nextLine();

                    bank.transfer(gAdi, gHesap, aAdi, aHesap, tutar);
                    break;
                case 6:
                    bank.listCustomers();
                    break;
                case 7:// Hesap sil
                    System.out.print("Müşteri adı: ");
                    String silMusteri = scanner.nextLine();
                    Customer cs = bank.findCustomer(silMusteri);

                    if (cs == null) {
                        System.out.println("Müşteri bulunamadı!");
                        break;
                    }

                    System.out.print("Silinecek hesap no: ");
                    String silHesap = scanner.nextLine();

                    cs.hesapSil(silHesap);
                    break;
                case 8:
                    System.out.println("silinecek müşteri adı :");
                    String isim1=scanner.nextLine();
                    bank.removeCustomer(isim1);
                    break;
                case 9:

                    System.out.print("Müşteri adı: ");
                    String isimIG = scanner.nextLine();
                    Customer custIG = bank.findCustomer(isimIG);

                    if(custIG == null){
                        System.out.println("Müşteri bulunamadı!");
                        break;
                    }

                    System.out.print("Hesap no: ");
                    String hesapIG = scanner.nextLine();

                    BankAccount accIG = custIG.hesapBul(hesapIG);
                    if(accIG == null){
                        System.out.println("Hesap bulunamadı!");
                        break;
                    }

                    System.out.println("İşlem geçmişi:");
                    accIG.islemleriGoster();
                    break;



                default:
                    System.out.println("Geçersiz seçim!");
            }
        }

        scanner.close();


            }
        }



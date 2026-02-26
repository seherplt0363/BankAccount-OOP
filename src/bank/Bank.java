package bank;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Bank {

    private final List<Customer> customers = new ArrayList<>();

    /* ======================
       CUSTOMER OPERATIONS
       ====================== */

    public void addCustomer(Customer customer) {
        customers.add(customer);
        System.out.println(customer.getIsim() + " eklendi");
    }

    public Customer findCustomer(String name) {
        for (Customer c : customers) {
            if (c.getIsim().equalsIgnoreCase(name.trim())) {
                return c;
            }
        }
        return null;
    }

    public boolean removeCustomer(String name) {
        Iterator<Customer> iterator = customers.iterator();

        while (iterator.hasNext()) {
            Customer c = iterator.next();
            if (c.getIsim().equalsIgnoreCase(name.trim())) {
                iterator.remove();
                System.out.println(name + " adlı müşteri silindi");
                return true;
            }
        }

        System.out.println("Müşteri bulunamadı");
        return false;
    }

    public void listCustomers() {
        System.out.println("=== BANKA MÜŞTERİLERİ ===");
        for (Customer c : customers) {
            System.out.println("- " + c.getIsim());
            c.hesaplarılistele();
        }
    }

    /* ======================
       MONEY OPERATIONS
       ====================== */

    public void transfer(
            String senderName, String senderAccountNo,
            String receiverName, String receiverAccountNo,
            double amount) {

        Customer sender = findCustomer(senderName);
        Customer receiver = findCustomer(receiverName);

        if (sender == null || receiver == null) {
            System.out.println("Gönderen veya alıcı müşteri bulunamadı!");
            return;
        }

        BankAccount senderAccount = sender.hesapBul(senderAccountNo);
        BankAccount receiverAccount = receiver.hesapBul(receiverAccountNo);

        if (senderAccount == null || receiverAccount == null) {
            System.out.println("Hesap bulunamadı!");
            return;
        }

        // Para çek / yatır → encapsulation korunur
        senderAccount.paraçek(amount);
        receiverAccount.parayatir(amount);

        senderAccount.islemEkle(
                "Havale (Gönderildi)",
                amount,
                receiverAccountNo + " hesabına gönderildi"
        );

        receiverAccount.islemEkle(
                "Havale (Alındı)",
                amount,
                senderAccountNo + " hesabından alındı"
        );

        System.out.println("Havale başarılı: " + amount + " TL");
    }
}

interface Payment {
    void pay(int amount);
}

class OldPayment {
    void makePayment(int amt) {
        System.out.println("Paid " + amt + " via old system");
    }
}

class PaymentAdapter implements Payment {
    OldPayment old = new OldPayment();
    
    public void pay(int amount) {
        old.makePayment(amount);
    }
}

class TestPay {
    public static void main(String[] a) {
        Payment p = new PaymentAdapter();
        p.pay(100);
    }
}
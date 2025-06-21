// Payment strategy
interface PayMethod {
    void pay(int amount);
}

// Credit card payment
class CreditCard implements PayMethod {
    public void pay(int amt) {
        System.out.println("Paid " + amt + " via credit card");
    }
}

// PayPal payment
class PayPal implements PayMethod {
    public void pay(int amt) {
        System.out.println("Paid " + amt + " via PayPal");
    }
}

// Payment processor
class Payment {
    PayMethod method;
    
    void setMethod(PayMethod m) {
        this.method = m;
    }
    
    void makePayment(int amt) {
        method.pay(amt);
    }
}

// Test
class TestPay {
    public static void main(String[] a) {
        Payment p = new Payment();
        p.setMethod(new CreditCard());
        p.makePayment(100);
        
        p.setMethod(new PayPal());
        p.makePayment(200);
    }
}
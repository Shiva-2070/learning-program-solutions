// Basic notifier
interface Notifier {
    void send(String msg);
}

// Email notifier
class EmailNotifier implements Notifier {
    public void send(String msg) {
        System.out.println("Email: " + msg);
    }
}

// SMS decorator
class SMSNotifier implements Notifier {
    Notifier notifier;
    
    SMSNotifier(Notifier n) {
        this.notifier = n;
    }
    
    public void send(String msg) {
        notifier.send(msg);
        System.out.println("SMS: " + msg);
    }
}

// Test
class TestNotify {
    public static void main(String[] a) {
        Notifier n = new SMSNotifier(new EmailNotifier());
        n.send("Hello!");
    }
}
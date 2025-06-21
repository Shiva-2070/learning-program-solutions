import java.util.*;
interface Observer {
    void update(String stock, double price);
}

class Stock {
    String name;
    double price;
    List<Observer> observers = new ArrayList<>();
    
    Stock(String n, double p) {
        this.name = n;
        this.price = p;
    }
    
    void addObserver(Observer o) {
        observers.add(o);
    }
    
    void setPrice(double p) {
        this.price = p;
        notifyAllObservers();
    }
    
    void notifyAllObservers() {
        for (Observer o : observers) {
            o.update(name, price);
        }
    }
}

class MobileApp implements Observer {
    public void update(String stock, double price) {
        System.out.println("Mobile: " + stock + " is now " + price);
    }
}

class TestObserver {
    public static void main(String[] a) {
        Stock apple = new Stock("AAPL", 150.0);
        apple.addObserver(new MobileApp());
        apple.setPrice(155.0);
    }
}
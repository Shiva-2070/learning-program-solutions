// Image interface
interface Image {
    void show();
}

// Real image
class RealImage implements Image {
    String filename;
    
    RealImage(String name) {
        this.filename = name;
        loadFromDisk();
    }
    
    void loadFromDisk() {
        System.out.println("Loading " + filename);
    }
    
    public void show() {
        System.out.println("Showing " + filename);
    }
}

// Proxy image
class ProxyImage implements Image {
    RealImage real;
    String filename;
    
    ProxyImage(String name) {
        this.filename = name;
    }
    
    public void show() {
        if (real == null) {
            real = new RealImage(filename);
        }
        real.show();
    }
}

// Test
class TestProxy {
    public static void main(String[] a) {
        Image img = new ProxyImage("test.jpg");
        img.show();
        img.show(); // loads only once
    }
}
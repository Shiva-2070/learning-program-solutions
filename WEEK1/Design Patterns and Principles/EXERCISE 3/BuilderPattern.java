
class Computer {
    String cpu;
    int ram;
    int hdd;

    private Computer() {}

    static class Builder {
        Computer comp = new Computer();
        
        Builder setCPU(String c) {
            comp.cpu = c;
            return this;
        }
        
        Builder setRAM(int r) {
            comp.ram = r;
            return this;
        }
        
        Builder setHDD(int h) {
            comp.hdd = h;
            return this;
        }
        
        Computer build() {
            return comp;
        }
    }
}

class TestComp {
    public static void main(String[] a) {
        Computer myPC = new Computer.Builder()
            .setCPU("Intel")
            .setRAM(16)
            .setHDD(512)
            .build();
        System.out.println(myPC.cpu);
    }
}
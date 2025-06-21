// Command interface
interface Command {
    void execute();
}

// Light class
class Light {
    void on() {
        System.out.println("Light on");
    }
    
    void off() {
        System.out.println("Light off");
    }
}

// Light commands
class LightOn implements Command {
    Light light;
    
    LightOn(Light l) {
        this.light = l;
    }
    
    public void execute() {
        light.on();
    }
}

class LightOff implements Command {
    Light light;
    
    LightOff(Light l) {
        this.light = l;
    }
    
    public void execute() {
        light.off();
    }
}

// Remote control
class Remote {
    Command cmd;
    
    void setCommand(Command c) {
        this.cmd = c;
    }
    
    void pressButton() {
        cmd.execute();
    }
}

// Test
class TestRemote {
    public static void main(String[] a) {
        Light l = new Light();
        Remote r = new Remote();
        
        r.setCommand(new LightOn(l));
        r.pressButton();
        
        r.setCommand(new LightOff(l));
        r.pressButton();
    }
}
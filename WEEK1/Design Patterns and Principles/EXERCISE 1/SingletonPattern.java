
class MyLogger {
    private static MyLogger log;
    
    private MyLogger() {}
    
    public static MyLogger getLog() {
        if (log == null) {
            log = new MyLogger();
        }
        return log;
    }
    
    void write(String msg) {
        System.out.println("Log: " + msg);
    }
}

class TestLog {
    public static void main(String[] a) {
        MyLogger l1 = MyLogger.getLog();
        MyLogger l2 = MyLogger.getLog();
        
        l1.write("hello");
        l2.write("world");
        
        System.out.println(l1 == l2);
    }
}
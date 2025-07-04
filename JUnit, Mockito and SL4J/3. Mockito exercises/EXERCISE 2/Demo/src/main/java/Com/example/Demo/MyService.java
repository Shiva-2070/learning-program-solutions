package Com.example.Demo;

public class MyService {
    private final ExternalApi api;
    
    public MyService(ExternalApi api) {
        this.api = api;
    }
    
    public String fetchData() {
        return api.getData();
    }
    
    public String fetchDataWithParam(String param) {
        return api.getDataWithParam(param);
    }
    
    public void storeData(String input) {
        if (input != null && !input.isEmpty()) {
            api.saveData(input.toUpperCase());
        }
    }
    
    public void batchProcess(String[] items) {
        if (items.length > 0) {
            api.process(items);
        }
    }
}
package Com.example.Demo;

public class MyService {
    private final ExternalApi api;
    
    public MyService(ExternalApi api) {
        this.api = api;
    }
    
    public String fetchData() {
        return api.getData();
    }
    
    public boolean isServiceAvailable() {
        try {
            api.connect();
            return api.getStatusCode("/health") == 200;
        } catch (ApiConnectionException e) {
            return false;
        }
    }
    
    public String processData() {
        String data = api.getData();
        return data != null ? data.toUpperCase() : "DEFAULT";
    }
}

package Com.example.Demo;

public interface ExternalApi {
    String getData();
    int getStatusCode(String endpoint);
    void connect() throws ApiConnectionException;
}
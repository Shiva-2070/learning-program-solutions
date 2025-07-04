package Com.example.Demo;


public interface ExternalApi {
    String getData();
    String getDataWithParam(String param);
    void saveData(String data);
    void process(String... items);
}
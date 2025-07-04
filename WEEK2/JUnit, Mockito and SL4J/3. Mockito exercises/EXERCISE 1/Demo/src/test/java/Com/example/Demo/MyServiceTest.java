package Com.example.Demo;


import org.junit.jupiter.api.Test;
import org.junit.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class MyServiceTest {
    private ExternalApi mockApi;
    private MyService myService;
    
    @Before
    public void setUp() {
        mockApi = mock(ExternalApi.class);
        myService = new MyService(mockApi);
    }
    
    @Test
    @DisplayName("Should return mocked data from external API")
    public void testFetchData() {
        // Arrange
        when(mockApi.getData()).thenReturn("Mock Data");
        
        // Act
        String result = myService.fetchData();
        
        // Assert
        assertEquals("Mock Data", result);
        verify(mockApi, times(1)).getData();
    }
    
    @Test
    @DisplayName("Should return true when API is available")
    public void testServiceAvailable() throws ApiConnectionException {
        // Arrange
        doNothing().when(mockApi).connect();
        when(mockApi.getStatusCode("/health")).thenReturn(200);
        
        // Act
        boolean available = myService.isServiceAvailable();
        
        // Assert
        assertTrue(available);
        verify(mockApi).connect();
        verify(mockApi).getStatusCode("/health");
    }
    
    @Test
    @DisplayName("Should return false when API connection fails")
    public void testServiceUnavailable() throws ApiConnectionException {
        // Arrange
        doThrow(new ApiConnectionException("Connection timeout"))
            .when(mockApi).connect();
        
        // Act
        boolean available = myService.isServiceAvailable();
        
        // Assert
        assertFalse(available);
        verify(mockApi).connect();
        verify(mockApi, never()).getStatusCode(anyString());
    }
    
    @Test
    @DisplayName("Should process data and return uppercase")
    public void testProcessData() {
        // Arrange
        when(mockApi.getData()).thenReturn("test data");
        
        // Act
        String result = myService.processData();
        
        // Assert
        assertEquals("TEST DATA", result);
    }
    
    @Test
    @DisplayName("Should return default when API returns null")
    public void testProcessDataWithNull() {
        // Arrange
        when(mockApi.getData()).thenReturn(null);
        
        // Act
        String result = myService.processData();
        
        // Assert
        assertEquals("DEFAULT", result);
    }
}

class ApiConnectionException extends Exception {
    private static final long serialVersionUID = 1L;

	public ApiConnectionException(String message) {
        super(message);
    }
}
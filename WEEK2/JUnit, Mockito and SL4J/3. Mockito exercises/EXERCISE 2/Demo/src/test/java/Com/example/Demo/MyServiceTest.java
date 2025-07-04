package Com.example.Demo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.*;

public class MyServiceTest {
    private ExternalApi mockApi;
    private MyService myService;
    
    @BeforeEach
    public void setUp() {
        mockApi = mock(ExternalApi.class);
        myService = new MyService(mockApi);
    }
    
    @Test
    public void verifySimpleInteraction() {
        // Arrange
        when(mockApi.getData()).thenReturn("test data");
        
        // Act
        myService.fetchData();
        
        // Assert
        verify(mockApi).getData();
    }
    
    @Test
    public void verifyInteractionWithExactArgument() {
        // Arrange
        String testParam = "specific-param";
        when(mockApi.getDataWithParam(anyString())).thenReturn("data");
        
        // Act
        myService.fetchDataWithParam(testParam);
        
        // Assert
        verify(mockApi).getDataWithParam(testParam);
        verify(mockApi, never()).getDataWithParam("wrong-param");
    }
    
    @Test
    public void verifyNumberOfInteractions() {
        // Act
        myService.fetchData();
        myService.fetchData();
        
        // Assert
        verify(mockApi, times(2)).getData();
        verify(mockApi, atLeastOnce()).getData();
        verify(mockApi, atMost(5)).getData();
    }
    
    @Test
    public void verifyArgumentCapturing() {
        // Arrange
        String testData = "original data";
        
        // Act
        myService.storeData(testData);
        
        // Assert
        verify(mockApi).saveData(argThat(arg -> 
            arg.equals("ORIGINAL DATA")));
    }
    
    @Test
    public void verifyNoInteractionForEmptyInput() {
        // Act
        myService.storeData("");
        myService.storeData(null);
        
        // Assert
        verify(mockApi, never()).saveData(anyString());
    }
    
    @Test
    public void verifyVarargsInteraction() {
        // Arrange
        String[] items = {"item1", "item2", "item3"};
        
        // Act
        myService.batchProcess(items);
        
        // Assert
        verify(mockApi).process(items);
        verify(mockApi).process(
            argThat(array -> array.length == 3 && 
                  array[0].equals("item1"))
        );
    }
    
    @Test
    public void verifyOrderOfInteractions() {
        // Arrange
        InOrder inOrder = inOrder(mockApi);
        
        // Act
        myService.fetchData();
        myService.storeData("test");
        
        // Assert
        inOrder.verify(mockApi).getData();
        inOrder.verify(mockApi).saveData(anyString());
    }
}
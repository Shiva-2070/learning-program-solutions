package Com.example.Demo;

import static org.junit.Assert.*;
import org.junit.Test;

public class AssersionsTest {
	
    
    @Test
    public void testVariousAssertions() {

        String nullString = null;
        String actualString = "JUnit";
        int[] numbers = {1, 2, 3};
      
        

        assertEquals("2 + 3 should equal 5", 5, 2 + 3);
        assertNotEquals("Should not equal 6", 6, 2 + 3);
        

        assertTrue("5 should be greater than 3", 5 > 3);
        assertFalse("3 should not be greater than 5", 3 > 5);
        

        assertNull("This object should be null", nullString);
        assertNotNull("This object shouldn't be null", actualString);

        assertArrayEquals("Arrays should be equal", 
                         new int[]{1, 2, 3}, 
                         numbers);
        

        Object obj1 = new Object();
        Object obj2 = obj1;
        assertSame("References should point to same object", obj1, obj2);
        assertNotSame("References should be different", obj1, new Object());
    }
    
    @Test(expected = ArithmeticException.class)
    public void testExceptionAssertion() {
        int result = 5 / 0;
    }
    
}

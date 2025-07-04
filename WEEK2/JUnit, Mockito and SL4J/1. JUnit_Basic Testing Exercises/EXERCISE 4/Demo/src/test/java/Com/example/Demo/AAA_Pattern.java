package Com.example.Demo;

import org.junit.*;
import static org.junit.Assert.*;

public class AAA_Pattern {
    private Calculator calculator;
    private int testValue1;
    private int testValue2;

    @BeforeClass
    public static void setUpClass() {
        System.out.println("Starting Calculator tests...");
    }

    @AfterClass
    public static void tearDownClass() {
        System.out.println("Calculator tests completed");
    }

    @Before
    public void setUp() {
        calculator = new Calculator();
        testValue1 = 10;
        testValue2 = 5;
        System.out.println("Initializing test...");
    }

    @After
    public void tearDown() {
        System.out.println("Test completed");
    }

    @Test
    public void testAddition() {
        // Arrange
        int expected = 15;
        
        // Act
        int actual = calculator.add(testValue1, testValue2);
        
        // Assert
        assertEquals("Addition should return sum of two numbers", 
                    expected, actual);
    }

    @Test
    public void testSubtraction() {
        assertEquals(5, calculator.subtract(testValue1, testValue2));
    }

    @Test
    public void testMultiplication() {
        assertTrue(calculator.multiply(testValue1, testValue2) == 50);
    }

    @Test
    public void testDivision() {
        assertNotNull("Division result should not be null",
                    calculator.divide(testValue1, testValue2));
        assertEquals(2, calculator.divide(testValue1, testValue2));
    }

    @Test(expected = ArithmeticException.class)
    public void testDivisionByZeroThrowsException() {
        calculator.divide(testValue1, 0);
    }

    @Test
    public void testAddWithNegativeNumbers() {
        assertEquals(-15, calculator.add(-10, -5));
    }

    @Test
    public void testSubtractResultingInNegative() {
        assertFalse(calculator.subtract(testValue2, testValue1) > 0);
    }
}
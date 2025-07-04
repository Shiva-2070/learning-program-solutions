package Com.example.Demo;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class Calculator_test {
    
    private static Calculator calculator;
    @Test
    public void testSubtraction() {
        System.out.println("Testing 5 - 2");
        assertEquals(3, calculator.subtract(5, 2));
    }

    @Test
    public void testMultiplication() {
        System.out.println("Testing 3 * 4");
        assertEquals(12, calculator.multiply(3, 4));
    }

    @Test(expected = ArithmeticException.class)
    public void testDivisionByZero() {
        System.out.println("Testing 5 / 0 (should throw exception)");
        calculator.divide(5, 0);
    }
}
package Com.example.Demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingDemo {
    private static final Logger logger = LoggerFactory.getLogger(LoggingDemo.class);
    
    public static void main(String[] args) {

        logger.error("This is an ERROR level message");
        logger.warn("This is a WARN level message");
        logger.info("This is an INFO level message");
        logger.debug("This is a DEBUG level message");
        logger.trace("This is a TRACE level message");
        
        String user = "john_doe";
        int attempt = 3;
        logger.warn("User {} failed to login (attempt {})", user, attempt);
  
        try {
            simulateError();
        } catch (RuntimeException e) {
            logger.error("An unexpected error occurred while processing request", e);
        }

        if (logger.isDebugEnabled()) {
            logger.debug("Performing expensive debug calculation: {}", expensiveOperation());
        }
    }
    
    private static void simulateError() {
        throw new RuntimeException("Simulated database connection failure");
    }
    
    private static String expensiveOperation() {

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return "Expensive result";
    }
}
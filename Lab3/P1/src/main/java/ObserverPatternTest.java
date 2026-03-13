public class ObserverPatternTest {
    /**
     * Main method to test the Observer pattern functionality.
     *
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        System.out.println("=== Observer Pattern Test ===\n");

        // Get the singleton logger instance
        Logger logger = Logger.getInstance();

        // Test 1: Logging without observers
        System.out.println("Test 1: Logging without observers");
        System.out.println("-----------------------------------");
        logger.log("No observers attached yet");
        System.out.println();

        // Test 2: Attach ConsoleObserver only
        System.out.println("Test 2: Attach ConsoleObserver");
        System.out.println("-------------------------------");
        logger.attach(new ConsoleObserver());
        logger.log("Console observer attached");
        System.out.println();

        // Test 3: Attach FileObserver
        System.out.println("Test 3: Attach FileObserver");
        System.out.println("----------------------------");
        logger.attach(new FileObserver());
        logger.log("File observer attached");// If write 2 here, you will get two write for each of equipment down there
        System.out.println();


        // Test 4: Multiple log messages with both observers
        System.out.println("Test 4: Multiple messages with both observers");
        System.out.println("----------------------------------------------");
        logger.log("Motion detected in living room");
        System.out.println();

        logger.log("Front door unlocked");
        System.out.println();

        logger.log("Thermostat set to 72F");
        System.out.println();

        logger.log("Security camera activated");
        System.out.println();

        logger.log("Window sensor triggered");
        System.out.println();

        logger.log("Garage door opened");
        System.out.println();

        // Test 5: Verify singleton behavior with observers
        System.out.println("Test 5: Verify singleton with observers");
        System.out.println("----------------------------------------");
        Logger logger2 = Logger.getInstance();
        System.out.println("Same instance? " + (logger == logger2));
        logger2.log("Message from second reference");
        System.out.println();

        System.out.println("=== Test Complete ===");
        System.out.println("\nSummary:");
        System.out.println("- Logger is a singleton (same instance throughout)");
        System.out.println("- Observers are notified for every log message");
        System.out.println("- Multiple observers can be attached and all receive notifications");
    }
}
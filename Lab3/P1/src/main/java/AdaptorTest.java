/**
 * Result: log function for instance or new objects have different behavior,
 * and oldlog can print out warning.
 * @author Tingyu Zhang
 * @version 1.0
 * @since 2025-11-06
 */





public class AdaptorTest {
    public static void main(String[] args) {
        System.out.println("=== Part A: Singleton Pattern Test ===\n");

        // Test singleton - get instance multiple times
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();

        // Log some messages
        logger1.log("Thermostat temperature changed to 72°F");
        logger2.log("Security camera detected motion");

        // Verify they're the same instance
        System.out.println("\nAre logger1 and logger2 the same instance? " + (logger1 == logger2));


        System.out.println("\n=== Part B: Adapter Pattern Test ===\n");

        // Create legacy system
        OldLogger legacySystem = new LegacyBuildingMonitor();

        // Test legacy system directly
        System.out.println("Testing legacy system directly:");
        legacySystem.writeLog("Everything is settled!", 0); // the one with different error massage
        legacySystem.writeLog("I will get hurt if you do so.", 1);
        legacySystem.writeLog("Broken, system broken!", 2);
        legacySystem.writeLog("Invalid input.",5);

        System.out.println("\nTesting through adapter:");
        // Adapt legacy system to new interface
        NewLogger adapter = new LoggerAdapter(legacySystem);

        // Use simple new interface (adapter translates to legacy format)
        adapter.log("Door opened");
        adapter.log("Thermostat adjusted");
        adapter.log("Security camera activated");


        System.out.println("\n=== Combined Usage ===\n");

        // Use both systems together
        Logger mainLogger = Logger.getInstance(); // the object with time
        mainLogger.log("Smart home system started");

        adapter.log("Legacy building system integrated");

        mainLogger.log("All systems operational");
    }
}

public class SingletonTest {
    public static void main(String[] args) {
        // Get the logger instance
        Logger logger = Logger.getInstance();

        // Log various smart home events
        logger.log("Thermostat temperature changed to 72F\n");
        logger.log("Security camera detected motion\n");
        logger.log("Front door unlocked");

        // Another component gets the SAME instance
        Logger anotherLogger = Logger.getInstance();
        anotherLogger.log("Back door locked");

        // Verify it's the same instance
        System.out.println(logger == anotherLogger); // true, since they are in the same address
    }
}

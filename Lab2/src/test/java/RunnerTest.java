/**
 * Test class for the Runner class.
 * Contains test cases to verify the functionality of Runner constructors, getters, and setters.
 *
 * @author Zhang Tingyu
 * @version 1.0
 */
public class RunnerTest {

    /**
     * Main method to run all tests.
     *
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        System.out.println("Starting Runner Tests...\n");

        testConstructorAndGetters();
        testSetters();
        testMultipleRunners();

        System.out.println("\nAll tests completed!");
    }

    /**
     * Tests the constructor and getter methods.
     */
    public static void testConstructorAndGetters() {
        System.out.println("Test 1: Constructor and Getters");

        Runner runner1 = new Runner(95.5, 22.3, "Half Marathon");

        System.out.println("Best 5K Time: " + runner1.getBest5KTime() + " minutes");
        System.out.println("Best Half Marathon Time: " + runner1.getBestHalfMarathonTime() + " minutes");
        System.out.println("Favorite Event: " + runner1.getFavoriteRunningEvent());

        // Verify values
        assert runner1.getBest5KTime() == 22.3 : "5K time should be 22.3";
        assert runner1.getBestHalfMarathonTime() == 95.5 : "Half marathon time should be 95.5";
        assert runner1.getFavoriteRunningEvent().equals("Half Marathon") : "Favorite event should be Half Marathon";

        System.out.println("Test 1 Passed\n");
    }

    /**
     * Tests the setter methods.
     */
    public static void testSetters() {
        System.out.println("Test 2: Setters");

        Runner runner2 = new Runner(100.0, 25.0, "5K");

        System.out.println("Initial values:");
        System.out.println("Best 5K Time: " + runner2.getBest5KTime());
        System.out.println("Best Half Marathon Time: " + runner2.getBestHalfMarathonTime());
        System.out.println("Favorite Event: " + runner2.getFavoriteRunningEvent());

        // Update values using setters
        runner2.setBest5KTime(23.5);
        runner2.setBestHalfMarathonTime(98.0);
        runner2.setFavoriteRunningEvent("Marathon");

        System.out.println("\nUpdated values:");
        System.out.println("Best 5K Time: " + runner2.getBest5KTime());
        System.out.println("Best Half Marathon Time: " + runner2.getBestHalfMarathonTime());
        System.out.println("Favorite Event: " + runner2.getFavoriteRunningEvent());

        // Verify updated values
        assert runner2.getBest5KTime() == 23.5 : "Updated 5K time should be 23.5";
        assert runner2.getBestHalfMarathonTime() == 98.0 : "Updated half marathon time should be 98.0";
        assert runner2.getFavoriteRunningEvent().equals("Marathon") : "Updated favorite event should be Marathon";

        System.out.println("✓ Test 2 Passed\n");
    }

    /**
     * Tests creating and managing multiple Runner objects.
     */
    public static void testMultipleRunners() {
        System.out.println("Test 3: Multiple Runners");

        Runner runner1 = new Runner(90.0, 20.0, "5K");
        Runner runner2 = new Runner(110.0, 28.0, "10K");
        Runner runner3 = new Runner(85.0, 19.5, "Half Marathon");

        System.out.println("Runner 1 - Favorite: " + runner1.getFavoriteRunningEvent() +
                ", Best 5K: " + runner1.getBest5KTime());
        System.out.println("Runner 2 - Favorite: " + runner2.getFavoriteRunningEvent() +
                ", Best 5K: " + runner2.getBest5KTime());
        System.out.println("Runner 3 - Favorite: " + runner3.getFavoriteRunningEvent() +
                ", Best 5K: " + runner3.getBest5KTime());

        // Find fastest 5K runner
        Runner fastest = runner1;
        if (runner2.getBest5KTime() < fastest.getBest5KTime()) {
            fastest = runner2;
        }
        if (runner3.getBest5KTime() < fastest.getBest5KTime()) {
            fastest = runner3;
        }

        System.out.println("\nFastest 5K runner has time: " + fastest.getBest5KTime() + " minutes");
        System.out.println("Test 3 Passed");
    }
}
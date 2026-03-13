/**
 * Test class for the BaseballPlayer class.
 * Contains test cases to verify the functionality of BaseballPlayer constructors, getters, and setters.
 *
 * @author Zhang Tingyu
 * @version 1.0
 */
public class BaseballPlayerTest {

    /**
     * Main method to run all tests.
     *
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        System.out.println("Starting BaseballPlayer Tests...\n");

        testConstructorAndGetters();
        testSetters();
        testMultiplePlayers();
        testStatisticsComparison();

        System.out.println("\nAll tests completed!");
    }

    /**
     * Tests the constructor and getter methods.
     */
    public static void testConstructorAndGetters() {
        System.out.println("Test 1: Constructor and Getters");

        BaseballPlayer player1 = new BaseballPlayer("Yankees", 0.325, 42);

        System.out.println("Team: " + player1.getTeam());
        System.out.println("Batting Average: " + player1.getAverageBatting());
        System.out.println("Season Home Runs: " + player1.getSeasonHomeRuns());

        // Verify values
        assert player1.getTeam().equals("Yankees") : "Team should be Yankees";
        assert player1.getAverageBatting() == 0.325 : "Batting average should be 0.325";
        assert player1.getSeasonHomeRuns() == 42 : "Season home runs should be 42";

        System.out.println("Test 1 Passed\n");
    }

    /**
     * Tests the setter methods.
     */
    public static void testSetters() {
        System.out.println("Test 2: Setters");

        BaseballPlayer player2 = new BaseballPlayer("Red Sox", 0.280, 25);

        System.out.println("Initial values:");
        System.out.println("Team: " + player2.getTeam());
        System.out.println("Batting Average: " + player2.getAverageBatting());
        System.out.println("Season Home Runs: " + player2.getSeasonHomeRuns());

        // Update values using setters
        player2.setTeam("Dodgers");
        player2.setAverageBatting(0.315);
        player2.setSeasonHomeRuns(38);

        System.out.println("\nUpdated values:");
        System.out.println("Team: " + player2.getTeam());
        System.out.println("Batting Average: " + player2.getAverageBatting());
        System.out.println("Season Home Runs: " + player2.getSeasonHomeRuns());

        // Verify updated values
        assert player2.getTeam().equals("Dodgers") : "Updated team should be Dodgers";
        assert player2.getAverageBatting() == 0.315 : "Updated batting average should be 0.315";
        assert player2.getSeasonHomeRuns() == 38 : "Updated season home runs should be 38";

        System.out.println("Test 2 Passed\n");
    }

    /**
     * Tests creating and managing multiple BaseballPlayer objects.
     */
    public static void testMultiplePlayers() {
        System.out.println("Test 3: Multiple Players");

        BaseballPlayer player1 = new BaseballPlayer("Yankees", 0.325, 42);
        BaseballPlayer player2 = new BaseballPlayer("Red Sox", 0.310, 35);
        BaseballPlayer player3 = new BaseballPlayer("Dodgers", 0.298, 38);

        System.out.println("Player 1 - Team: " + player1.getTeam() +
                ", Avg: " + player1.getAverageBatting() +
                ", HRs: " + player1.getSeasonHomeRuns());
        System.out.println("Player 2 - Team: " + player2.getTeam() +
                ", Avg: " + player2.getAverageBatting() +
                ", HRs: " + player2.getSeasonHomeRuns());
        System.out.println("Player 3 - Team: " + player3.getTeam() +
                ", Avg: " + player3.getAverageBatting() +
                ", HRs: " + player3.getSeasonHomeRuns());

        System.out.println("Test 3 Passed\n");
    }

    /**
     * Tests comparison of player statistics.
     */
    public static void testStatisticsComparison() {
        System.out.println("Test 4: Statistics Comparison");

        BaseballPlayer player1 = new BaseballPlayer("Yankees", 0.325, 42);
        BaseballPlayer player2 = new BaseballPlayer("Red Sox", 0.310, 45);
        BaseballPlayer player3 = new BaseballPlayer("Dodgers", 0.298, 38);

        // Find player with highest batting average
        BaseballPlayer bestAverage = player1;
        if (player2.getAverageBatting() > bestAverage.getAverageBatting()) {
            bestAverage = player2;
        }
        if (player3.getAverageBatting() > bestAverage.getAverageBatting()) {
            bestAverage = player3;
        }

        System.out.println("Highest batting average: " + bestAverage.getAverageBatting() +
                " (" + bestAverage.getTeam() + ")");

        // Find player with most home runs
        BaseballPlayer mostHomeRuns = player1;
        if (player2.getSeasonHomeRuns() > mostHomeRuns.getSeasonHomeRuns()) {
            mostHomeRuns = player2;
        }
        if (player3.getSeasonHomeRuns() > mostHomeRuns.getSeasonHomeRuns()) {
            mostHomeRuns = player3;
        }

        System.out.println("Most home runs: " + mostHomeRuns.getSeasonHomeRuns() +
                " (" + mostHomeRuns.getTeam() + ")");

        // Calculate team average statistics
        double avgBattingAverage = (player1.getAverageBatting() +
                player2.getAverageBatting() +
                player3.getAverageBatting()) / 3.0;
        double avgHomeRuns = (player1.getSeasonHomeRuns() +
                player2.getSeasonHomeRuns() +
                player3.getSeasonHomeRuns()) / 3.0;

        System.out.println("\nAverage batting average across all players: " +
                String.format("%.3f", avgBattingAverage));
        System.out.println("Average home runs across all players: " +
                String.format("%.1f", avgHomeRuns));

        System.out.println("Test 4 Passed");
    }
}
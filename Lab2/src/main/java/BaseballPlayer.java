/**
 * Represents a baseball player with their team affiliation and performance statistics.
 * This class stores information about a player's batting performance and home run count.
 *
 * @author Zhang Tingyu
 * @version 1.0
 */
public class BaseballPlayer {
    private String Team;
    private double AverageBatting;
    private int seasonHomeRuns;

    /**
     * Constructs a BaseballPlayer with specified team and performance statistics.
     *
     * @param team the name of the player's team
     * @param averageBatting the player's batting average (typically between 0.000 and 1.000)
     * @param seasonHomeRuns the number of home runs hit in the current season
     */

    public BaseballPlayer(String team, double averageBatting, int seasonHomeRuns) {
        this.Team = team;
        this.AverageBatting = averageBatting;
        this.seasonHomeRuns = seasonHomeRuns;
    }

    public String getTeam() {
        return Team;
    }

    public void setTeam(String team) {
        Team = team;
    }

    public double getAverageBatting() {
        return AverageBatting;
    }

    public void setAverageBatting(double averageBatting) {
        AverageBatting = averageBatting;
    }

    public int getSeasonHomeRuns() {
        return seasonHomeRuns;
    }

    public void setSeasonHomeRuns(int seasonHomeRuns) {
        this.seasonHomeRuns = seasonHomeRuns;
    }
}

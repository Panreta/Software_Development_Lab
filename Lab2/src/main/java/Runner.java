/**
 * Represents a runner with their personal best times and favorite running event.
 * This class stores information about a runner's performance in different race distances.
 *
 * @author Zhang Tingyu
 * @version 1.0
 */

public class Runner {
    private double best5KTime;
    private double bestHalfMarathonTime;
    private String FavoriteRunningEvent;

    /**
     * Constructs a Runner with specified best times and favorite event.
     *
     * @param bestHalfMarathonTime the runner's best half marathon time in minutes
     * @param best5KTime the runner's best 5K time in minutes
     * @param favoriteRunningEvent the runner's favorite running event (e.g., "5K", "Marathon")
     */

    public Runner(double bestHalfMarathonTime, double best5KTime, String favoriteRunningEvent) {
        this.bestHalfMarathonTime = bestHalfMarathonTime;
        this.best5KTime = best5KTime;
        FavoriteRunningEvent = favoriteRunningEvent;
    }

    public double getBest5KTime() {
        return best5KTime;
    }

    public void setBest5KTime(double best5KTime) {
        this.best5KTime = best5KTime;
    }

    public String getFavoriteRunningEvent() {
        return FavoriteRunningEvent;
    }

    public void setFavoriteRunningEvent(String favoriteRunningEvent) {
        FavoriteRunningEvent = favoriteRunningEvent;
    }

    public double getBestHalfMarathonTime() {
        return bestHalfMarathonTime;
    }

    public void setBestHalfMarathonTime(double bestHalfMarathonTime) {
        this.bestHalfMarathonTime = bestHalfMarathonTime;
    }
}

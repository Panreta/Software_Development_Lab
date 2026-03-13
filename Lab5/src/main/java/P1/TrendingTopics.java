package P1;

import java.util.*;
import java.util.stream.Collectors;

public class TrendingTopics {

    /**
     * Counts the occurrences of each topic in the input list using functional programming.
     *
     * @param topics List of topic strings
     * @return Map with each unique topic as key and its occurrence count as value
     */
    public Map<String, Long> countTopics(List<String> topics) {
        return topics.stream()
                .collect(Collectors.groupingBy(
                        topic -> topic, // "Take each topic and return that same topic unchanged"
                        Collectors.counting()
                ));
    }

    // Main method for testing
    public static void main(String[] args) {
        TrendingTopics tt = new TrendingTopics();

        // Test with the example data
        List<String> topics = Arrays.asList(
                "Seattle", "wildfires", "DEFCON26", "NEU", "NEU",
                "Seattle", "Seattle", "NEU", "DEFCON26", "wildfires"
        );

        Map<String, Long> topicCounts = tt.countTopics(topics);

        // Display results
        System.out.println("Topic Counts:");
        topicCounts.forEach((topic, count) ->
                System.out.println("- " + topic + " is " + count)
        );
    }
}
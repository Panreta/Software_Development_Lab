/**
 * HealthBarObserver - Displays health bar when character health changes
 * Implements Observer Pattern
 */
public class HealthBarObserver implements CharacterObserver {

    @Override
    public void update(Character character) {
        int current = character.getCurrentHealth();
        int max = character.getHealth();

        // Calculate percentage
        double percentage = (double) current / max * 100;

        // Create visual health bar
        int barLength = 20;
        int filled = (int) (barLength * current / max);

        StringBuilder bar = new StringBuilder("[");
        for (int i = 0; i < barLength; i++) {
            if (i < filled) {
                bar.append("=");
            } else {
                bar.append(" ");
            }
        }
        bar.append("]");

        // Print health status
        System.out.println("HEALTH: " + current + "/" + max + " " +
                bar.toString() + " " +
                String.format("%.0f%%", percentage));
    }
}
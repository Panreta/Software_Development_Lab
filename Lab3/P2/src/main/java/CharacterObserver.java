/**
 * CharacterObserver Interface - Observer Pattern
 *
 * Any class that wants to be notified when a Character changes
 * must implement this interface.
 */
public interface CharacterObserver {

    /**
     * Called when the observed Character's state changes
     *
     * @param character The character that changed
     */
    void update(Character character);
}
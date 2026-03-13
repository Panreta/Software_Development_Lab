import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * CharacterRegistry - Implements the Prototype Pattern
 *
 * This class stores character prototypes and creates clones on demand.
 * Benefits:
 * - Fast character creation (cloning vs building from scratch)
 * - Centralized template management
 * - Each clone is independent (changes don't affect the prototype)
 */
public class CharacterRegistry {

    // Store prototypes by type name
    private Map<String, Character> prototypes;

    /**
     * Constructor initializes the registry
     */
    public CharacterRegistry() {
        this.prototypes = new HashMap<>();
    }

    /**
     * Register a character prototype
     *
     * @param type The type/name to identify this prototype (e.g., "warrior", "mage")
     * @param prototype The character template to store
     */
    public void registerCharacter(String type, Character prototype) {
        if (type == null || type.trim().isEmpty()) {
            throw new IllegalArgumentException("Type cannot be null or empty");
        }
        if (prototype == null) {
            throw new IllegalArgumentException("Prototype cannot be null");
        }

        // Store the prototype
        prototypes.put(type.toLowerCase(), prototype);
        System.out.println("OKKK Registered prototype: " + type);
    }

    /**
     * Create a character by cloning a registered prototype
     *
     * @param type The type of character to create
     * @return A cloned character (independent copy)
     * @throws IllegalArgumentException if the type doesn't exist
     */
    public Character createCharacter(String type) {
        if (type == null || type.trim().isEmpty()) {
            throw new IllegalArgumentException("Type cannot be null or empty");
        }

        Character prototype = prototypes.get(type.toLowerCase());

        if (prototype == null) {
            throw new IllegalArgumentException(
                    "No prototype registered for type: " + type +
                            ". Available types: " + getAvailableTypes()
            );
        }

        // Clone and return
        return prototype.clone();
    }

    /**
     * Get all available prototype types
     *
     * @return Set of registered type names
     */
    public Set<String> getAvailableTypes() {
        return prototypes.keySet();
    }

    /**
     * Get the number of registered prototypes
     *
     * @return Count of prototypes
     */
    public int getPrototypeCount() {
        return prototypes.size();
    }

    /**
     * Clear all prototypes from the registry
     */
    public void clear() {
        prototypes.clear();
        System.out.println("OKKK Registry cleared");
    }

}
/**
 * GameCharacterFacade - Implements the Facade Pattern
 *
 * This class provides a simplified interface for character creation,
 * hiding the complexity of:
 * - Builder pattern syntax
 * - Registry management
 * - Attribute combinations
 * - Class-specific defaults
 *
 * Benefits:
 * - Simple API for new players
 * - Encapsulates complex subsystems
 * - Ensures consistent character creation
 * - Easy to maintain and modify
 */
public class GameCharacterFacade {

    private CharacterRegistry registry;

    /**
     * Constructor - initializes the facade with a registry
     */
    public GameCharacterFacade() {
        this.registry = new CharacterRegistry();
        initializeTemplates();
    }

    /**
     * Constructor with existing registry
     */
    public GameCharacterFacade(CharacterRegistry registry) {
        this.registry = registry;
        initializeTemplates();
    }

    /**
     * Initialize default class templates in the registry
     * This is called automatically - users don't need to worry about it!
     */
    private void initializeTemplates() {
        // Register warrior template
        Character warriorTemplate = new Character.Builder("Warrior")
                .health(150)
                .mana(30)
                .strength(20)
                .agility(10)
                .weapon("Sword")
                .armor("Plate Mail")
                .build();
        registry.registerCharacter("warrior", warriorTemplate);

        // Register mage template
        Character mageTemplate = new Character.Builder("Mage")
                .health(80)
                .mana(200)
                .strength(5)
                .agility(12)
                .weapon("Staff")
                .armor("Robes")
                .build();
        registry.registerCharacter("mage", mageTemplate);

        // Register rogue template
        Character rogueTemplate = new Character.Builder("Rogue")
                .health(100)
                .mana(50)
                .strength(15)
                .agility(30)
                .weapon("Daggers")
                .armor("Leather")
                .build();
        registry.registerCharacter("rogue", rogueTemplate);

        // Register tank template
        Character tankTemplate = new Character.Builder("Tank")
                .health(250)
                .mana(20)
                .strength(18)
                .agility(8)
                .weapon("Shield")
                .armor("Heavy Plate")
                .build();
        registry.registerCharacter("tank", tankTemplate);

        // Register archer template
        Character archerTemplate = new Character.Builder("Archer")
                .health(110)
                .mana(60)
                .strength(12)
                .agility(25)
                .weapon("Bow")
                .armor("Studded Leather")
                .build();
        registry.registerCharacter("archer", archerTemplate);
    }

    /**
     * Simple API: Create a warrior with just a name
     * All warrior attributes are handled automatically
     *
     * @param name The warrior's name
     * @return A fully configured warrior character
     */
    public Character createWarrior(String name) {
        return new Character.Builder(name)
                .health(150)
                .mana(30)
                .strength(20)
                .agility(10)
                .weapon("Sword")
                .armor("Plate Mail")
                .build();
    }

    /**
     * Simple API: Create a mage with just a name
     * All mage attributes are handled automatically
     *
     * @param name The mage's name
     * @return A fully configured mage character
     */
    public Character createMage(String name) {
        return new Character.Builder(name)
                .health(80)
                .mana(200)
                .strength(5)
                .agility(12)
                .weapon("Staff")
                .armor("Robes")
                .build();
    }

    /**
     * Simple API: Create a rogue with just a name
     *
     * @param name The rogue's name
     * @return A fully configured rogue character
     */
    public Character createRogue(String name) {
        return new Character.Builder(name)
                .health(100)
                .mana(50)
                .strength(15)
                .agility(30)
                .weapon("Daggers")
                .armor("Leather")
                .build();
    }

    /**
     * Simple API: Create a tank with just a name
     *
     * @param name The tank's name
     * @return A fully configured tank character
     */
    public Character createTank(String name) {
        return new Character.Builder(name)
                .health(250)
                .mana(20)
                .strength(18)
                .agility(8)
                .weapon("Shield")
                .armor("Heavy Plate")
                .build();
    }



    /**
     * Create a character from a registered template
     * Uses the prototype pattern under the hood
     *
     * @param type The character class type (warrior, mage, etc.)
     * @param name The character's name
     * @return A cloned character with the custom name
     */
    public Character createFromTemplate(String type, String name) {
        // Clone from registry
        Character template = registry.createCharacter(type);

        // Since Character is immutable, we need to rebuild with new name
        // This is a limitation - in a real system, you might want to make
        // Character mutable or add a rename method
        return new Character.Builder(name)
                .health(template.getHealth())
                .mana(template.getMana())
                .strength(template.getStrength())
                .agility(template.getAgility())
                .weapon(template.getWeapon())
                .armor(template.getArmor())
                .build();
    }

    /**
     * Advanced: Create a character with custom modifications
     * Still simpler than using Builder directly
     *
     * @param type Base character type
     * @param name Character name
     * @param healthBonus Additional health
     * @param strengthBonus Additional strength
     * @return Customized character
     */
    public Character createCustomCharacter(String type, String name,
                                           int healthBonus, int strengthBonus) {
        Character base = registry.createCharacter(type);

        return new Character.Builder(name)
                .health(base.getHealth() + healthBonus)
                .mana(base.getMana())
                .strength(base.getStrength() + strengthBonus)
                .agility(base.getAgility())
                .weapon(base.getWeapon())
                .armor(base.getArmor())
                .build();
    }

    /**
     * Quick random character creation
     * Perfect for NPCs or testing
     *
     * @return A random character
     */
    public Character createRandomCharacter() {
        String[] types = {"warrior", "mage", "rogue", "tank", "archer"};
        String randomType = types[(int)(Math.random() * types.length)];
        String randomName = randomType + "_" + (int)(Math.random() * 1000);

        return createFromTemplate(randomType, randomName);
    }

    /**
     * Get list of available character types
     *
     * @return Array of available types
     */
    public String[] getAvailableTypes() {
        return new String[]{"warrior", "mage", "rogue", "tank", "archer"};
    }

    /**
     * Display information about a character type
     *
     * @param type The character type
     */
    public void displayTypeInfo(String type) {
        Character template = registry.createCharacter(type.toLowerCase());
        System.out.println("=== " + type.toUpperCase() + " ===");
        System.out.println("Health:   " + template.getHealth());
        System.out.println("Mana:     " + template.getMana());
        System.out.println("Strength: " + template.getStrength());
        System.out.println("Agility:  " + template.getAgility());
        System.out.println("Weapon:   " + template.getWeapon());
        System.out.println("Armor:    " + template.getArmor());
    }

    /**
     * Get the underlying registry (for advanced users)
     *
     * @return The character registry
     */
    public CharacterRegistry getRegistry() {
        return registry;
    }
}
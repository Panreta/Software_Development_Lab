/**
 * CompleteGameSystem - Demonstrates using Builder + Prototype patterns together
 * This is how you'd actually use these patterns in a real game
 */
public class PrototypeTest {

    public static void main(String[] args) {
        System.out.println("=== Complete Character Creation System ===\n");

        // Initialize the game's character registry
        CharacterRegistry gameRegistry = new CharacterRegistry();

        // Step 1: Game initialization - register all class prototypes
        System.out.println("GAME STARTUP: Initializing character classes...");
        initializeCharacterClasses(gameRegistry);
        System.out.println();

        // Step 2: Player 1 creates a character
        System.out.println("--- PLAYER 1: Character Creation ---");
        Character player1Char = createPlayerCharacter(
                gameRegistry,
                "warrior",
                "Thorin Oakenshield"
        );
        System.out.println("Created: " + player1Char);
        System.out.println();

        // Step 3: Player 2 creates a character
        System.out.println("--- PLAYER 2: Character Creation ---");
        Character player2Char = createPlayerCharacter(
                gameRegistry,
                "mage",
                "Gandalf the Grey"
        );
        System.out.println("Created: " + player2Char);
        System.out.println();

        // Step 4: Player 3 uses quick-start
        System.out.println("--- PLAYER 3: Quick Start (No Customization) ---");
        Character player3Char = gameRegistry.createCharacter("rogue");
        System.out.println("Created: " + player3Char);
        System.out.println();

        // Step 5: Spawn NPCs (Non-Player Characters) quickly
        System.out.println("--- GAME: Spawning Enemy NPCs ---");
        spawnEnemies(gameRegistry, 3);
        System.out.println();

        // Step 6: Create a custom boss (Builder + Prototype)
        System.out.println("--- GAME: Creating Custom Boss ---");
        Character boss = createCustomBoss(gameRegistry);
        System.out.println("Boss created: " + boss);
        System.out.println();

        // Step 7: Show the complete party
        System.out.println("--- GAME STATE: Current Party ---");
        displayParty(new Character[]{player1Char, player2Char, player3Char});

        System.out.println("\n=== System Benefits ===");
        System.out.println("OKKK Builder: Flexible character customization");
        System.out.println("OKKK Prototype: Fast character spawning");
        System.out.println("OKKK Templates: Quick-start for new players");
        System.out.println("OKKK Registry: Centralized character management");
        System.out.println("OKKK Scalable: Easy to add new character types");
    }

    /**
     * Initialize all character class prototypes
     * This runs once at game startup
     */
    private static void initializeCharacterClasses(CharacterRegistry registry) {
        // Register warrior class
        Character warriorProto = new Character.Builder("Warrior")
                .health(150)
                .mana(30)
                .strength(25)
                .agility(10)
                .weapon("Longsword")
                .armor("Plate Mail")
                .build();
        registry.registerCharacter("warrior", warriorProto);

        // Register mage class
        Character mageProto = new Character.Builder("Mage")
                .health(80)
                .mana(200)
                .strength(8)
                .agility(12)
                .weapon("Staff")
                .armor("Robes")
                .build();
        registry.registerCharacter("mage", mageProto);

        // Register rogue class
        Character rogueProto = new Character.Builder("Rogue")
                .health(100)
                .mana(50)
                .strength(15)
                .agility(30)
                .weapon("Daggers")
                .armor("Leather")
                .build();
        registry.registerCharacter("rogue", rogueProto);

        // Register tank class
        Character tankProto = new Character.Builder("Tank")
                .health(250)
                .mana(20)
                .strength(20)
                .agility(8)
                .weapon("Shield")
                .armor("Heavy Plate")
                .build();
        registry.registerCharacter("tank", tankProto);

        System.out.println("OKKK Registered " + registry.getPrototypeCount() + " character classes");
        System.out.println("Available: " + registry.getAvailableTypes());
    }

    /**
     * Simulate player character creation
     * Players start with a prototype and customize it
     */
    private static Character createPlayerCharacter(
            CharacterRegistry registry,
            String classType,
            String playerName) {

        System.out.println("Player selected class: " + classType);
        System.out.println("Player entered name: " + playerName);

        // Clone the prototype
        Character character = registry.createCharacter(classType);

        // In a real game, you'd use the Builder to customize
        // But since Character is immutable, we'd need to rebuild
        // For now, we'll show the concept
        System.out.println("Base stats loaded from prototype");

        // Note: In a production system, you might want to make Character
        // mutable after creation, or use the Builder pattern on the clone
        // For this demo, we're using the prototype as-is

        return character;
    }

    /**
     * Quickly spawn enemy NPCs using prototypes
     */
    private static void spawnEnemies(CharacterRegistry registry, int count) {
        System.out.println("Spawning " + count + " enemy warriors...");

        for (int i = 1; i <= count; i++) {
            Character enemy = registry.createCharacter("warrior");
            System.out.println("  Enemy #" + i + " spawned: " + enemy.getName() +
                    " (HP: " + enemy.getHealth() + ", STR: " + enemy.getStrength() + ")");
        }

        System.out.println("OKKK " + count + " enemies ready for battle!");
    }

    /**
     * Create a custom boss by starting from a prototype
     */
    private static Character createCustomBoss(CharacterRegistry registry) {
        // Start with warrior prototype, but make it much stronger
        Character baseWarrior = registry.createCharacter("warrior");

        // In a real system, you'd modify the clone
        // For now, we'll create a new one using Builder
        Character boss = new Character.Builder("Dragon Lord")
                .health(500)  // Much higher than normal
                .mana(100)
                .strength(40)  // Much stronger
                .agility(15)
                .weapon("Flaming Greatsword")
                .armor("Dragon Scale Armor")
                .build();

        return boss;
    }

    /**
     * Display the current party
     */
    private static void displayParty(Character[] party) { // like a toString method
        System.out.println("Party size: " + party.length);
        for (int i = 0; i < party.length; i++) {
            Character c = party[i];
            System.out.println("  [" + (i+1) + "] " + c.getName() +
                    " - HP:" + c.getHealth() +
                    " MP:" + c.getMana() +
                    " STR:" + c.getStrength() +
                    " AGI:" + c.getAgility());
        }
    }
}
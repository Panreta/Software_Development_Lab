/**
 * Demonstration of all three patterns working together:
 * - Builder Pattern: Flexible object construction
 * - Prototype Pattern: Fast cloning
 * - Facade Pattern: Simple interface
 *
 * This shows how design patterns complement each other!
 */
public class FacadePatternTest {

    public static void main(String[] args) {
        System.out.println("========================================================");
        System.out.println("    THREE DESIGN PATTERNS WORKING TOGETHER");
        System.out.println("  Builder + Prototype + Facade = Powerful System");
        System.out.println("========================================================");
        System.out.println();

        realWorldGameScenario();
        showPatternBenefits();
    }



    /**
     * Real-world game scenario using all patterns
     */
    private static void realWorldGameScenario() {
        System.out.println("=== Real-World Game Scenario ===\n");

        GameCharacterFacade game = new GameCharacterFacade();

        // Scenario 1: Player creates their character
        System.out.println("STEP 1: Player Character Creation");
        System.out.println("----------------------------------------");
        System.out.println("Player chooses: Warrior");
        System.out.println("Player enters name: Conan");

        Character player = game.createWarrior("Conan");
        System.out.println("+ Character created: " + player);
        System.out.println("[Used: FACADE -> BUILDER]");
        System.out.println();

        // Scenario 2: Create a party of AI companions
        System.out.println("STEP 2: AI Companion Creation");
        System.out.println("----------------------------------------");
        System.out.println("Creating party members...");

        Character healer = game.createMage("Elara");
        Character scout = game.createRogue("Shadow");
        Character defender = game.createTank("Boulder");

        System.out.println("+ Party formed:");
        System.out.println("  - " + player.getName() + " (Player)");
        System.out.println("  - " + healer.getName() + " (Healer)");
        System.out.println("  - " + scout.getName() + " (Scout)");
        System.out.println("  - " + defender.getName() + " (Defender)");
        System.out.println("[Used: FACADE -> BUILDER]");
        System.out.println();

        // Scenario 3: Spawn 20 enemy goblins quickly
        System.out.println("STEP 3: Enemy Spawning");
        System.out.println("----------------------------------------");
        System.out.println("Spawning 20 goblin enemies...");

        for (int i = 1; i <= 20; i++) {
            Character goblin = game.createFromTemplate("rogue", "Goblin_" + i);
            if (i <= 3 || i > 17) { // Show first 3 and last 3
                System.out.println("  + " + goblin.getName() + " spawned");
            } else if (i == 4) {
                System.out.println("  ... (14 more goblins) ...");
            }
        }

        System.out.println("+ 20 enemies ready for battle!");
        System.out.println("[Used: FACADE -> PROTOTYPE -> BUILDER]");
        System.out.println();

        // Scenario 4: Boss creation with custom stats
        System.out.println("STEP 4: Boss Creation");
        System.out.println("----------------------------------------");
        System.out.println("Creating boss with enhanced stats...");

        Character boss = game.createCustomCharacter(
                "warrior",
                "Goblin King",
                200,  // +200 health
                30    // +30 strength
        );

        System.out.println("+ Boss created: " + boss);
        System.out.println("[Used: FACADE -> PROTOTYPE -> BUILDER]");
        System.out.println();

        // Scenario 5: Quick NPC generation
        System.out.println("STEP 5: Random NPCs for Town");
        System.out.println("----------------------------------------");
        System.out.println("Populating town with NPCs...");

        for (int i = 1; i <= 5; i++) {
            Character npc = game.createRandomCharacter();
            System.out.println("  + " + npc.getName() + " (Town NPC)");
        }

        System.out.println("[Used: FACADE -> PROTOTYPE -> BUILDER]");
        System.out.println();
    }

    /**
     * Show the benefits of combining patterns
     */
    private static void showPatternBenefits() {
        System.out.println("========================================================");
        System.out.println("              COMBINED PATTERN BENEFITS");
        System.out.println("========================================================");
        System.out.println();

        System.out.println("BUILDER PATTERN Benefits:");
        System.out.println("   + Flexible object construction");
        System.out.println("   + Readable, self-documenting code");
        System.out.println("   + Optional parameters with defaults");
        System.out.println("   + Immutable objects (thread-safe)");
        System.out.println();

        System.out.println("PROTOTYPE PATTERN Benefits:");
        System.out.println("   + Fast object creation (cloning)");
        System.out.println("   + Avoid repetitive construction");
        System.out.println("   + Easy to create variations");
        System.out.println("   + Perfect for mass spawning");
        System.out.println();

        System.out.println("FACADE PATTERN Benefits:");
        System.out.println("   + Simple, easy-to-use interface");
        System.out.println("   + Hides complex subsystems");
        System.out.println("   + Beginner-friendly API");
        System.out.println("   + Reduces learning curve");
        System.out.println();

        System.out.println("COMBINED Benefits:");
        System.out.println("   + Power + Simplicity");
        System.out.println("   + Flexibility + Ease of use");
        System.out.println("   + Advanced features available when needed");
        System.out.println("   + Scalable system architecture");
        System.out.println();

        System.out.println("========================================================");
        System.out.println("                  USER EXPERIENCE");
        System.out.println("========================================================");
        System.out.println();

        System.out.println("BEGINNER:");
        System.out.println("   Uses: Facade Pattern");
        System.out.println("   Code: game.createWarrior(\"Bob\")");
        System.out.println("   Experience: Simple and easy!");
        System.out.println();

        System.out.println("INTERMEDIATE:");
        System.out.println("   Uses: Facade + Prototype");
        System.out.println("   Code: game.createFromTemplate(\"warrior\", \"Custom\")");
        System.out.println("   Experience: More control, still simple!");
        System.out.println();

        System.out.println("ADVANCED:");
        System.out.println("   Uses: Builder directly");
        System.out.println("   Code: new Character.Builder(...).health(999)...");
        System.out.println("   Experience: Full customization power!");
        System.out.println();

        System.out.println("GAME DEVELOPER:");
        System.out.println("   Uses: All patterns together");
        System.out.println("   Code: Combines Facade, Prototype, Builder as needed");
        System.out.println("   Experience: Maximum flexibility and efficiency!");
        System.out.println();

        System.out.println("========================================================");
        System.out.println("             *** DESIGN PATTERNS WIN! ***");
        System.out.println("========================================================");
    }
}
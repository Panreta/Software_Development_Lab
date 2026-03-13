/**
 * Demonstration of all 4 design patterns working together:
 * Builder + Prototype + Facade + Observer
 */
public class ObserverPattern {

    public static void main(String[] args) {
        System.out.println("========================================");
        System.out.println("  ALL 4 DESIGN PATTERNS IN ACTION");
        System.out.println("========================================\n");

        // FACADE: Simple character creation
        GameCharacterFacade game = new GameCharacterFacade();
        Character hero = game.createWarrior("Aragorn");

        System.out.println("Created: " + hero.getName());
        System.out.println("Max HP: " + hero.getHealth() + "\n");

        // OBSERVER: Attach multiple observers
        System.out.println("Attaching observers...");
        hero.attach(new HealthBarObserver());

        System.out.println();

        // Simulate combat
        System.out.println("=== BATTLE SCENARIO ===\n");

        System.out.println("[1] Goblin attacks!");
        hero.takeDamage(30);
        System.out.println();

        System.out.println("[2] Orc attacks!");
        hero.takeDamage(50);
        System.out.println();

        System.out.println("[3] Dragon breathes fire!");
        hero.takeDamage(55);
        System.out.println();

        System.out.println("[4] Used health potion!");
        hero.heal(40);
        System.out.println();

        System.out.println("[5] Troll smash!");
        hero.takeDamage(70);
        System.out.println();

        // Show how PROTOTYPE can create multiple characters quickly
        System.out.println("=== SPAWNING PARTY MEMBERS ===\n");
        Character mage = game.createMage("Gandalf");
        Character rogue = game.createRogue("Bilbo");

        mage.attach(new HealthBarObserver());
        rogue.attach(new HealthBarObserver());

        System.out.println("Party member 1: " + mage.getName());
        mage.takeDamage(20);
        System.out.println();

        System.out.println("Party member 2: " + rogue.getName());
        rogue.takeDamage(15);
        System.out.println();

        System.out.println("========================================");
        System.out.println("       PATTERNS DEMONSTRATED");
        System.out.println("========================================");
        System.out.println("[1] BUILDER: Flexible character creation");
        System.out.println("[2] PROTOTYPE: Fast cloning (via Facade)");
        System.out.println("[3] FACADE: Simple interface for users");
        System.out.println("[4] OBSERVER: Health change notifications");
        System.out.println("========================================");
    }
}
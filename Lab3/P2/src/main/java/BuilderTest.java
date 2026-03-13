/**
 * CharacterTemplates - Factory class providing quick-start character presets
 *
 * This demonstrates one of the key benefits of the Builder pattern:
 * Easy creation of template methods that return pre-configured builders
 * Players can use these as-is or customize them further!
 */
public class BuilderTest {

    /**
     * Warrior preset - high strength and health, heavy armor
     */
    public static Character.Builder warrior(String name) {
        return new Character.Builder(name)
                .health(150)
                .mana(30)
                .strength(25)
                .agility(10)
                .weapon("Longsword")
                .armor("Plate Mail");
    }

    /**
     * Mage preset - high mana and intelligence, light armor
     */
    public static Character.Builder mage(String name) {
        return new Character.Builder(name)
                .health(80)
                .mana(200)
                .strength(8)
                .agility(12)
                .weapon("Staff of Power")
                .armor("Enchanted Robes");
    }

    /**
     * Rogue preset - high agility, moderate damage, light armor
     */
    public static Character.Builder rogue(String name) {
        return new Character.Builder(name)
                .health(100)
                .mana(50)
                .strength(15)
                .agility(30)
                .weapon("Twin Daggers")
                .armor("Leather Armor");
    }

    /**
     * Tank preset - extremely high health, moderate strength
     */
    public static Character.Builder tank(String name) {
        return new Character.Builder(name)
                .health(250)
                .mana(20)
                .strength(20)
                .agility(8)
                .weapon("Shield and Mace")
                .armor("Heavy Plate");
    }

    /**
     * Ranger preset - balanced stats, favors agility
     */
    public static Character.Builder ranger(String name) {
        return new Character.Builder(name)
                .health(120)
                .mana(70)
                .strength(15)
                .agility(22)
                .weapon("Composite Bow")
                .armor("Studded Leather");
    }

    /**
     * Paladin preset - balanced holy warrior
     */
    public static Character.Builder paladin(String name) {
        return new Character.Builder(name)
                .health(160)
                .mana(100)
                .strength(20)
                .agility(12)
                .weapon("Holy Sword")
                .armor("Blessed Armor");
    }

    /**
     * Demo showing the power of templates
     */
    public static void main(String[] args) {
        System.out.println("=== Character Template System ===\n");

        // Example 1: Use template as-is
        System.out.println("1. Quick-start warrior (no customization):");
        Character basicWarrior = BuilderTest.warrior("Conan").build();// All Conan have some default equal value
        System.out.println(basicWarrior);// Actually System.out.println(basicWarrior.toString());
        System.out.println();

        // Example 2: Use template but customize it!
        System.out.println("2. Customized warrior (started from template):");
        Character customWarrior = BuilderTest.warrior("Xena")
                .strength(30)  // Override template's strength
                .weapon("Chakram")  // Override template's weapon
                .build();
        System.out.println(customWarrior);
        System.out.println();

        // Example 3: Multiple quick characters
        System.out.println("3. Creating a party quickly:");
        Character hero1 = BuilderTest.mage("Merlin").build();
        Character hero2 = BuilderTest.rogue("Shadow").build();
        Character hero3 = BuilderTest.tank("Brick").build();
        Character hero4 = BuilderTest.ranger("Arrow").build();

        System.out.println(hero1);
        System.out.println(hero2);
        System.out.println(hero3);
        System.out.println(hero4);
        System.out.println();

        // Example 4: Mix and match approach
        System.out.println("4. Hybrid character (mage base, customized):");
        Character battleMage = BuilderTest.mage("Elminster")
                .strength(15)  // More strength than typical mage
                .health(120)  // More health than typical mage
                .weapon("Sword and Staff")
                .build();
        System.out.println(battleMage);
        System.out.println();

    }
}
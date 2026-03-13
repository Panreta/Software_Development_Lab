import java.util.ArrayList;
import java.util.List;

/**
 * Character class using Builder, Prototype, and Observer patterns
 */
public class Character implements Cloneable {
    // Character attributes
    private final String name;
    private final int health;
    private final int mana;
    private final int strength;
    private final int agility;
    private final String weapon;
    private final String armor;

    // Observer pattern support
    private List<CharacterObserver> observers;
    private int currentHealth;

    /**
     * Private constructor - called by Builder
     */
    private Character(Builder builder) {
        this.name = builder.name;
        this.health = builder.health;
        this.currentHealth = builder.health; // Initialize current health
        this.mana = builder.mana;
        this.strength = builder.strength;
        this.agility = builder.agility;
        this.weapon = builder.weapon;
        this.armor = builder.armor;
        this.observers = new ArrayList<>();
    }

    /**
     * Copy constructor for cloning
     */
    private Character(Character original) {
        this.name = original.name;
        this.health = original.health;
        this.currentHealth = original.currentHealth;
        this.mana = original.mana;
        this.strength = original.strength;
        this.agility = original.agility;
        this.weapon = original.weapon;
        this.armor = original.armor;
        this.observers = new ArrayList<>(); // New observers list for clone
    }

    /**
     * Builder class
     */
    public static class Builder {
        private final String name;
        private int health = 100;
        private int mana = 50;
        private int strength = 10;
        private int agility = 10;
        private String weapon = "Fists";
        private String armor = "Cloth";

        public Builder(String name) {
            if (name == null || name.trim().isEmpty()) {
                throw new IllegalArgumentException("Name cannot be null or empty");
            }
            this.name = name;
        }

        public Builder health(int health) {
            if (health < 0) {
                throw new IllegalArgumentException("Health cannot be negative");
            }
            this.health = health;
            return this;
        }

        public Builder mana(int mana) {
            if (mana < 0) {
                throw new IllegalArgumentException("Mana cannot be negative");
            }
            this.mana = mana;
            return this;
        }

        public Builder strength(int strength) {
            if (strength < 0) {
                throw new IllegalArgumentException("Strength cannot be negative");
            }
            this.strength = strength;
            return this;
        }

        public Builder agility(int agility) {
            if (agility < 0) {
                throw new IllegalArgumentException("Agility cannot be negative");
            }
            this.agility = agility;
            return this;
        }

        public Builder weapon(String weapon) {
            if (weapon == null || weapon.trim().isEmpty()) {
                throw new IllegalArgumentException("Weapon cannot be null or empty");
            }
            this.weapon = weapon;
            return this;
        }

        public Builder armor(String armor) {
            if (armor == null || armor.trim().isEmpty()) {
                throw new IllegalArgumentException("Armor cannot be null or empty");
            }
            this.armor = armor;
            return this;
        }

        public Character build() {
            return new Character(this);
        }
    }

    // Getters
    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getCurrentHealth() {
        return currentHealth;
    }

    public int getMana() {
        return mana;
    }

    public int getStrength() {
        return strength;
    }

    public int getAgility() {
        return agility;
    }

    public String getWeapon() {
        return weapon;
    }

    public String getArmor() {
        return armor;
    }

    // Observer Pattern Methods

    /**
     * Attach an observer
     */
    public void attach(CharacterObserver observer) {
        if (observer != null && !observers.contains(observer)) {
            observers.add(observer);
        }
    }

    /**
     * Detach an observer
     */
    public void detach(CharacterObserver observer) {
        observers.remove(observer);
    }

    /**
     * Notify all observers
     */
    private void notifyObservers() {
        for (CharacterObserver observer : observers) {
            observer.update(this);
        }
    }

    /**
     * Character takes damage
     */
    public void takeDamage(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Damage cannot be negative");
        }
        currentHealth = Math.max(0, currentHealth - amount);
        System.out.println(name + " takes " + amount + " damage!");
        notifyObservers();
    }

    /**
     * Character heals
     */
    public void heal(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Heal amount cannot be negative");
        }
        int oldHealth = currentHealth;
        currentHealth = Math.min(health, currentHealth + amount);
        int actualHeal = currentHealth - oldHealth;
        System.out.println(name + " heals " + actualHeal + " HP!");
        notifyObservers();
    }

    // Prototype Pattern

    @Override
    public Character clone() {
        try {
            return new Character(this);
        } catch (Exception e) {
            throw new RuntimeException("Failed to clone character", e);
        }
    }

    @Override
    public String toString() {
        return String.format(
                "Character{name='%s', health=%d/%d, mana=%d, strength=%d, agility=%d, weapon='%s', armor='%s'}",
                name, currentHealth, health, mana, strength, agility, weapon, armor
        );
    }
}
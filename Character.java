import java.util.ArrayList;
import static java.lang.System.out;

public class Character {
    //region Private Members
    private String name;
    private int gold;
    private int level;
    private int maxHP;

    private ArrayList<String> inventory;
    private ArrayList<String> features;
    //endregion

    //region Constructors
    public Character(String nameIn) {
        name = nameIn;
        gold = 0;
        level = 1;
        maxHP = 12;
        
        inventory = new ArrayList<>();
        features = new ArrayList<>() {{
            add(Features.featuresList.get((1)));
        }};
    }
    //endregion

    //region Public Methods

    //region Get Methods
    public String getName() {
        return name;
    }

    public int getGold() {
        return gold;
    }

    public int getLevel() {
        return level;
    }

    public int getMaxHP() {
        return maxHP;
    }

    public void getInventory() {
        out.println(name + "'s Inventory:");

        for (String item : inventory) {
            out.println("- " + item);
        }
    }

    public void getFeatures() {
        out.println(name + "'s Features:");

        for (String feature : features) {
            out.println("- " + feature);
        }
    }
    //endregion

    //region Gold
    public void addGold(int amount) {
        addGold(amount, true);
    }
    
    public void addGold(int amount, boolean suppressOutput) {
        gold += amount;

        if (!suppressOutput) {
            out.println(name + " received " + amount + " gold. Total gold: " + gold);
        }
    }

    public void removeGold(int amount) {
        removeGold(amount, true);
    }

    public void removeGold(int amount, boolean suppressOutput) {
        if (gold >= amount) {
            gold -= amount;

            if (!suppressOutput) {
                out.println(name + " spent " + amount + " gold. Total gold: " + gold);
            }
        }
        else if (!suppressOutput) {
            out.println(name + " doesn't have enough gold.");
        }
    }
    //endregion
    
    //region Items
    public void addItem(String item) {
        addItem(item, true);
    }

    public void addItem(String item, boolean suppressOutput) {
        inventory.add(item);

        if (!suppressOutput) {
            out.println(item + " added to " + name + "'s inventory.");
        }
    }

    public void addItems(ArrayList<String> items) {
        addItems(items, true);
    }

    public void addItems(ArrayList<String> items, boolean suppressOutput) {
        if (!suppressOutput) {
            out.println("Items added to " + name + "'s inventory:");
        }
        
        for (String item : items) {
            inventory.add(item);
            
            if (!suppressOutput) {
                out.println("- " + item);
            }
        }
    }

    public void removeItem(String item) {
        removeItem(item, true);
    }

    public void removeItem(String item, boolean suppressOutput) {
        if (inventory.contains(item)) {
            inventory.remove(item);

            if (!suppressOutput) {
                out.println(item + " removed from " + name + "'s inventory.");
            }
        }
        else if (!suppressOutput) {
            out.println(item + " not found in " + name + "'s inventory.");
        }
    }
    //endregion

    //region Levels
    public void levelUp() {
        if (level == 20) {
            out.println("Max level reached (20)");
            return;
        }

        level += 1;
        maxHP += 7;
        features.add(Features.featuresList.get(level));
        out.println("Character's level is now " + level);
        out.println("Character's max HP is now " + maxHP);
    }

    public void levelDown() {
        if (level == 1) {
            out.println("Min level reached (1)");
            return;
        }

        level -= 1;
        maxHP -= 7;
        features.remove(features.size() - 1);
        out.println("Character's level is now " + level);
        out.println("Character's max HP is now " + maxHP);
    }
    //endregion
    
    //endregion
}

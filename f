public class Character {
    private String name;
    private int gold;
    private ArrayList<String> features;

    public Character(String name, int gold) {
        this.name = name;
        this.gold = gold;
        this.features = new ArrayList<>();
    }

    public void addFeature(String feature) {
        features.add(feature);
        System.out.println(feature + " added to " + name + "'s inventory.");
    }

    public void removeFeature(String feature) {
        if (features.contains(feature)) {
            inventory.remove(feature);
            System.out.println(feature + " removed from " + name + "'s inventory.");
        } else {
            System.out.println(feature + " not found in " + name + "'s inventory.");
        }
    }
    public void addGold(int amount) {
        gold += amount;
        System.out.println(name + " received " + amount + " gold. Total gold: " + gold);
    }
      public void removeGold(int amount) {
        if (gold >= amount) {
            gold -= amount;
            System.out.println(name + " spent " + amount + " gold. Total gold: " + gold);
        } else {
            System.out.println(name + " doesn't have enough gold.");
        }
    }

 public void showInventory() {
        System.out.println(name + "'s Inventory:");
        for (String item :features) {
          System.out.println(feature);
        }
        System.out.println("Gold: " + gold);
    }
     public static void main(String[] args) {
        Character player1 = new Character("Player 1", 0);
        Character player2 = new Character("Player 2", 0);

        player1.addGold(50);
        player1.addItem("Sword");
        player1.addItem("Potion");
        player1.showInventory();

        player2.addGold(100);
        player2.addItem("Shield");
        player2.showInventory();

        player1.removeItem("Potion");
        player1.removeGold(30);
        player1.showInventory();
    }
}


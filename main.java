import java.util.ArrayList;

public class main {
    public static void main(String[] args) {
        String party = createParty();
        String characterName = createCharacterName(party);
        String characterRace = createCharacterRace(characterName);
        int characterAbilityScore = createAbilityScore(characterName);
        int characterArmorClass = createArmorClass(characterName);
        int characterMaxHealth = createMaxHealth(characterName);
        int characterProficiencyBonus = createProficiencyBonus(characterName);
        int characterLevel = createCharacterLevel(characterName);
        String characterClass = createCharacterClass(characterName);
        ArrayList<String> characterInventory = createInventory(characterName);
        ArrayList<String> characterFeatures = createFeatures(characterName);

        displayCharacterInformation(party, characterName, characterRace, characterAbilityScore, characterArmorClass, characterMaxHealth, characterProficiencyBonus, characterLevel, characterClass, characterInventory, characterFeatures);
    }

    private static String createParty() {
        return "Test Party";
    }

    private static String createCharacterName(String characterName) {
        return "Test Name";
    }

    private static String createCharacterRace(String characterName) {
        return "Test Race";
    }

    private static int createAbilityScore(String characterName) {
        return 18;
    }

    private static int createArmorClass(String characterName) {
        return 15;
    }

    private static int createMaxHealth(String characterName) {
        return 50;
    }

    private static int createProficiencyBonus(String characterName) {
        return 2;
    }

    private static int createCharacterLevel(String characterName) {
        return 5;
    }

    private static String createCharacterClass(String characterName) {
        return "Test Class";
    }

    private static ArrayList<String> createInventory(String characterName) {
        ArrayList<String> inventory = new ArrayList<>();
        inventory.add("Item 1");
        inventory.add("Item 2");
        inventory.add("Item 3");
        return inventory;
    }

    private static ArrayList<String> createFeatures(String characterName) {
        ArrayList<String> features = new ArrayList<>();
        features.add("Feature 1");
        features.add("Feature 2");
        return features;
    }

    private static void displayCharacterInformation(String party, String characterName, String characterRace, int characterAbilityScore, int characterArmorClass, int characterMaxHealth, int characterProficiencyBonus, int characterLevel, String characterClass, ArrayList<String> characterInventory, ArrayList<String> characterFeatures) {
        System.out.println("Party: " + party);
        System.out.println("Character Name: " + characterName);
        System.out.println("Character Race: " + characterRace);
        System.out.println("Ability Score: " + characterAbilityScore);
        System.out.println("Armor Class: " + characterArmorClass);
        System.out.println("Max Health: " + characterMaxHealth);
        System.out.println("Proficiency Bonus: " + characterProficiencyBonus);
        System.out.println("Character Level: " + characterLevel);
        System.out.println("Character Class: " + characterClass);

        System.out.println("Inventory:");
        for (String item : characterInventory) {
            System.out.println(" - " + item);
        }

        System.out.println("Features:");
        for (String feature : characterFeatures) {
            System.out.println(" - " + feature);
        }
    }
}

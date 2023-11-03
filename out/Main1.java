import java.util.Scanner;
import java.util.ArrayList;

public class Main1 {
    public static void main(String[] args) {
        String party;
        String characterName;
        String characterRace;
        int characterAbilityScore;
        int characterArmorClass;
        int characterMaxHealth;
        int characterProficiencyBonus;
        int characterLevel;
        String characterClass;
        ArrayList<String> characterInventory;
        ArrayList<String> characterFeatures;

        Scanner keyboard = new Scanner(System.in);
        party = getStringInput(keyboard, "Enter party name");
        characterName = getStringInput(keyboard, party + " create a character name");
        characterRace = getStringInput(keyboard, "Enter a race for " + characterName);
        characterClass = getStringInput(keyboard, "Enter the class for " + characterName);

        characterAbilityScore = integerValidation(keyboard, "Ability Score", characterName);
        characterArmorClass = integerValidation(keyboard, "Armor Class", characterName);
        characterMaxHealth = integerValidation(keyboard, "Max Health", characterName);
        characterProficiencyBonus = integerValidation(keyboard, "Proficiency Bonus", characterName);
        characterLevel = integerValidation(keyboard, "Character Level", characterName);

        characterInventory = getInventoryInput(characterClass, characterName);
        characterFeatures = getFeaturesInput(characterClass, characterName);

        consoleOutput(party, characterName, characterRace, characterAbilityScore, characterArmorClass, characterMaxHealth, characterProficiencyBonus, characterLevel, characterClass, characterInventory, characterFeatures);
    }

    private static String getStringInput(Scanner keyboard, String prompt) {
        System.out.println(prompt);
        return keyboard.nextLine();
    }

    private static int integerValidation(Scanner keyboard, String inputName, String characterName) {
        int inputValue = 0;
        boolean validInput = false;

        System.out.println("Enter the " + inputName + " for " + characterName + ":");
        while (!validInput) {
            String input = keyboard.nextLine();
            try {
                inputValue = Integer.parseInt(input);
                validInput = true;
            } catch (NumberFormatException e) {
                System.out.println("Enter a valid " + inputName + " for " + characterName + ":");
            }
        }
        return inputValue;
    }

    private static ArrayList<String> getInventoryInput(String characterClass, String characterName)  {
        ArrayList<String> inventory = new ArrayList<>();
        System.out.println("inventory for " + characterName);
        if(characterClass.equalsIgnoreCase("barbarian")){
            inventory.add("Great Axe " + "Two Handed Axes " + "Explorer's Pack " + "4 Javelins");
        }

        if(characterClass.equalsIgnoreCase("bard")){
            inventory.add("Rapier " + "Dagger" + "Lute " + "Diplomat's Pack " + "Leather Armor");}
        return inventory; }

    private static ArrayList<String> getFeaturesInput(String characterClass, String characterName) {
        ArrayList<String> features = new ArrayList<>();
        System.out.println("Enter the features for " + characterName + " (type 'done' when finished):");

        return features;
    }

    private static void consoleOutput(String party, String characterName, String characterRace, int characterAbilityScore, int characterArmorClass, int characterMaxHealth, int characterProficiencyBonus, int characterLevel, String characterClass, ArrayList<String> characterInventory, ArrayList<String> characterFeatures) {
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
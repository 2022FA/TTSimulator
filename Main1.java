import java.util.Scanner;
import java.util.ArrayList;

public class Main1 {
    public static void main(String[] args) {
        String party;
        String characterName;
        String characterRace;
        int characterAbilityScore;
        int characterArmorClass;
        int characterProficiencyBonus;
        int characterLevel;
        int characterBaseHealth = 0;
        String characterClass;
        ArrayList<String> characterInventory;
        ArrayList<String> characterFeatures;

        Scanner keyboard = new Scanner(System.in);

        party = getStringInput(keyboard, "Enter party name");
        characterName = getStringInput(keyboard, party + " create a character name");
        characterRace = getStringInput(keyboard, "Enter a race for " + characterName);
        characterClass = getStringInput(keyboard, "Enter the class for " + characterName);

        characterBaseHealth = characterBaseHPBasedOnClass(characterClass, keyboard, characterBaseHealth, characterName);

        characterAbilityScore = integerValidation(keyboard, "Ability Score", characterName);
        characterArmorClass = integerValidation(keyboard, "Armor Class", characterName);
        characterProficiencyBonus = integerValidation(keyboard, "Proficiency Bonus", characterName);
        characterLevel = integerValidation(keyboard, "Character Level", characterName);

        characterInventory = getInventoryInput(keyboard, characterName);
        characterFeatures = getFeaturesInput(keyboard, characterName);

        consoleOutput(party, characterName, characterRace, characterBaseHealth, characterAbilityScore, characterArmorClass, characterProficiencyBonus, characterLevel, characterClass, characterInventory, characterFeatures);

        keyboard.close();
    }

    private static int characterBaseHPBasedOnClass(String characterClass, Scanner keyboard, int characterBaseHealth, String characterName) {
        if (characterClass.equalsIgnoreCase("barbarian")) {
            characterBaseHealth = 12;
        }
        return characterBaseHealth;
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

    private static ArrayList<String> getInventoryInput(Scanner keyboard, String characterName) {
        ArrayList<String> inventory = new ArrayList<>();
        System.out.println("Enter the inventory for " + characterName + " (type 'done' when finished):");
        while (true) {
            String input = keyboard.nextLine();
            if (input.equalsIgnoreCase("done")) {
                break;
            }
            inventory.add(input);
        }
        return inventory;
    }

    private static ArrayList<String> getFeaturesInput(Scanner keyboard, String characterName) {
        ArrayList<String> features = new ArrayList<>();
        System.out.println("Enter the features for " + characterName + " (type 'done' when finished):");
        while (true) {
            String input = keyboard.nextLine();
            if (input.equalsIgnoreCase("done")) {
                break;
            }
            features.add(input);
        }
        return features;
    }

    private static void consoleOutput(String party, String characterName, String characterRace, int characterBaseHealth, int characterAbilityScore, int characterArmorClass, int characterProficiencyBonus, int characterLevel, String characterClass, ArrayList<String> characterInventory, ArrayList<String> characterFeatures) {
        System.out.println("Party: " + party);
        System.out.println("Character Name: " + characterName);
        System.out.println("Character Race: " + characterRace);
        System.out.println("Ability Score: " + characterAbilityScore);
        System.out.println("Armor Class: " + characterArmorClass);
        System.out.println("Base Health: " + characterBaseHealth);
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
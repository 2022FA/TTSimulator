import java.util.Scanner;
import java.util.ArrayList;

public class Main1 {
    public static void main(String[] args) {
        // Declare variables to store character and party information
        String party;
        String characterName;
        String characterRace;
        int characterAbilityScore;
        int characterArmorClass;
        int characterProficiencyBonus = 2;
        int characterLevel = 1;
        int characterBaseHealth = 0; // Initialize characterBaseHealth
        String characterClass;
        ArrayList<String> characterInventory;
        ArrayList<String> characterFeatures;

        // Create a Scanner object to read user input
        Scanner keyboard = new Scanner(System.in);

        // Prompt the user for various character and party details
        party = getStringInput(keyboard, "Enter party name");
        characterName = getStringInput(keyboard, party + " create a character name");
        characterRace = characterRaceValidation(keyboard, characterName);

        characterClass = getStringInput(keyboard, "Enter the class for " + characterName);

        // Calculate character's base health based on class
        characterBaseHealth = characterBaseHPBasedOnClass(characterClass, characterBaseHealth);

        // Prompt for and validate other character attributes
        characterAbilityScore = integerValidation(keyboard, "Ability Score", characterName);
        characterArmorClass = integerValidation(keyboard, "Armor Class", characterName);

        // Gather character inventory and features
        characterInventory = getInventoryInput(keyboard, characterName);
        characterFeatures = getFeaturesInput(keyboard, characterName);

        // Display the collected character information
        consoleOutput(party, characterName, characterRace, characterBaseHealth, characterAbilityScore, characterArmorClass, characterProficiencyBonus, characterLevel, characterClass, characterInventory, characterFeatures);

        boolean continuePlaying = true;

        while (continuePlaying) {
            // Collect initial character information (same as before)

            characterLevel = changeCharacterInfo(keyboard, characterLevel);

            // Calculate the proficiency bonus based on the character's class and level
            characterProficiencyBonus = characterProficiencyBonus(characterClass, characterLevel);

            // Display the updated character information
            consoleOutput(party, characterName, characterRace, characterBaseHealth, characterAbilityScore, characterArmorClass, characterProficiencyBonus, characterLevel, characterClass, characterInventory, characterFeatures);

            // Ask if the user wants to continue
            System.out.print("Do you want to make more changes (y/n)? ");
            String continueChoice = keyboard.nextLine().toLowerCase();
            if (!continueChoice.equals("y")) {
                continuePlaying = false;
            }
        }

        // Close the Scanner to release resources
        keyboard.close();
    }

    private static int characterProficiencyBonus(String characterClass, int characterLevel) {
        int proficiencyBonus = 0;
        if (characterClass.equalsIgnoreCase("barbarian")) {
            proficiencyBonus = barbarianProficiencyBonusBasedOnLevel(characterLevel, proficiencyBonus);
        }
        return proficiencyBonus;
    }

    private static int changeCharacterInfo(Scanner keyboard, int characterLevel) {
        System.out.print("Do you want to change the level (y/n)? ");
        String levelChangeChoice = keyboard.nextLine().toLowerCase();
        if (levelChangeChoice.equals("y")) {
            System.out.print("Level up (up) or level down (d)? ");
            String levelChange = keyboard.nextLine().toLowerCase();
            if (levelChange.equals("up")) {
                characterLevel++;
            } else if (levelChange.equals("d")) {
                characterLevel--;
            }
        }
        return characterLevel;
    }
    //Calculate's the character's base health based on class
    private static int characterBaseHPBasedOnClass(String characterClass, int characterBaseHealth) {
        if (characterClass.equalsIgnoreCase("barbarian")) {
            characterBaseHealth = 12;
        }
        return characterBaseHealth;
    }

    //For class barbarian that assigns a proficiencyBonus based on the character level 2+1/2
    private static int barbarianProficiencyBonusBasedOnLevel(int characterLevel, int proficiencyBonus) {
        proficiencyBonus = 2 + ((int) (double) (characterLevel - 1) /4);
        return proficiencyBonus;
    }

    // Validation loop for character Race.
    private static String characterRaceValidation(Scanner keyboard, String characterName) {
        String characterRace;
        do {
            characterRace = getStringInput(keyboard, "Choose a race for " + characterName);
            if (characterRace.equalsIgnoreCase("dragonborn") || characterRace.equalsIgnoreCase("dwarf") || characterRace.equalsIgnoreCase("elf") ||
                    characterRace.equalsIgnoreCase("gnome") || characterRace.equalsIgnoreCase("half-elf") || characterRace.equalsIgnoreCase("half-orc") ||
                    characterRace.equalsIgnoreCase("halfling") || characterRace.equalsIgnoreCase("human") || characterRace.equalsIgnoreCase("tiefling")) {
                break;
            } else {
                System.out.println("Enter a valid race. Please choose from dragonborn, dwarf, elf, gnome, half-elf, half-orc, halfling, human, or tiefling.");
            }
        } while (true);

        return characterRace;
    }

    //Gets string input from the user
    private static String getStringInput(Scanner keyboard, String prompt) {
        System.out.println(prompt);
        return keyboard.nextLine();
    }

    //Validates and get an integer input from the user
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

    //Collect character inventory
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

    //Collect character features
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

    //Displays character information
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
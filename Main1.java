import java.util.*;

public class Main1 {
    private static int characterProficiencyBonus = 2;
    private static int characterLevel = 1;
    private static final Map<String, Integer> classBaseHealthMap = new HashMap<>();
    private static final Map<String, List<String>> startingItemsMap = new HashMap<>();

    // Defines features
    private static final Hashtable<Integer, String> featuresList = new Hashtable<>() {{
        put(1, "Rage, Unarmored Defense");
        put(2, "Reckless Attack, Danger Sense");
        put(3, "Primal Path, Primal Knowledge");
        put(4, "Ability Score Improvement");
        put(5, "Extra Attack, Fast Movement");
        put(6, "Path feature");
        put(7, "Feral Instinct, Instinctive Pounce");
        put(8, "Ability Score");
        put(9, "Brutal Critical");
        put(10, "Path feature, Primal knowledge");
        put(11, "Relentless Rage");
        put(12, "Ability Score Improvement");
        put(13, "Brutal Critical");
        put(14, "Path feature");
        put(15, "Persistent Rage");
        put(16, "Ability Score Improvement");
        put(17, "Brutal Critical");
        put(18, "Indomitable Might");
        put(19, "Ability Score Improvement");
        put(20, "Primal Champion");
    }};

    private static final List<String> backgroundsList = Arrays.asList(
            "charlatan", "acolyte", "criminal", "entertainer", "folk hero", "guild artisan", "hermit", "noble", "outlander", "sailor", "sage", "soldier", "urchin"
    );
    // Validation loop for character Background.
    private static String characterBackgroundValidation(Scanner keyboard, String characterName) {
        String characterBackground;
        do {
            characterBackground = getStringInput(keyboard, "Choose a Background for " + characterName);
            if (backgroundsList.contains(characterBackground)) {
                break;
            } else {
                System.out.println("""
                        Enter a valid Background. Please choose from the this list: charlatan, acolyte, criminal, entertainer, folk hero, guild artisan, hermit, noble, outlander, sailor, sage, soldier, urchin""");
            }
        } while (true);

        return characterBackground;
    }

    public static void main(String[] args) {
        // Create a Scanner object to read user input
        Scanner keyboard = new Scanner(System.in);

        // Prompt the user for various character and party details
        String party = getStringInput(keyboard, "Enter party name");
        String characterName = getStringInput(keyboard, party + " create a character name");
        String characterRace = characterRaceValidation(keyboard, characterName);
        String characterClass = characterClassValidation(keyboard, characterName);
        String characterBackground = characterBackgroundValidation(keyboard, characterName);


        // Calculate character's base health based on class
        int characterBaseHealth = characterBaseHPBasedOnClass(characterClass);

        // Prompt for and validate other character attributes
        int characterAbilityScore = integerValidation(keyboard, "Ability Score", characterName);
        int characterArmorClass = integerValidation(keyboard, "Armor Class", characterName);

        // Gather character inventory and features
        List<String> characterInventory = startingItemsBasedOnClass(characterClass);
        ArrayList<String> characterFeatures = getFeaturesInput(characterLevel);

        // Display the collected character information
        consoleOutput(party, characterName, characterRace, characterBaseHealth, characterAbilityScore, characterArmorClass, characterProficiencyBonus, characterLevel, characterClass, characterInventory, characterFeatures, characterBackground);

        boolean continuePlaying = true;

        while (continuePlaying) {
            // Collect initial character information

            characterLevel = changeCharacterInfo(keyboard, characterLevel);

            // Calculate the proficiency bonus based on the character's class and level
            characterProficiencyBonus = characterProficiencyBonus(characterLevel);

            // Update the character features based on the new level
            characterFeatures = getFeaturesInput(characterLevel);

            // Display the updated character information
            consoleOutput(party, characterName, characterRace, characterBaseHealth, characterAbilityScore, characterArmorClass, characterProficiencyBonus, characterLevel, characterClass, characterInventory, characterFeatures, characterBackground);

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

    private static ArrayList<String> getFeaturesInput(int characterLevel) {
        ArrayList<String> features = new ArrayList<>();
        for (int level = 1; level <= characterLevel; level++) {
            if (featuresList.containsKey(level)) {
                features.add(featuresList.get(level));
            }
        }
        return features;
    }
    //Calculates the bonus based on character level
    private static int characterProficiencyBonus(int characterLevel) {
        int proficiencyBonus;
        proficiencyBonus = 2 + ((int) (double) (characterLevel - 1) / 4);
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

    static {
        // Initialize the map with class and base health values
        classBaseHealthMap.put("barbarian", 12);
        classBaseHealthMap.put("artificer", 8);
        classBaseHealthMap.put("bard", 8);
        classBaseHealthMap.put("cleric", 8);
        classBaseHealthMap.put("druid", 8);
        classBaseHealthMap.put("fighter", 10);
        classBaseHealthMap.put("monk", 8);
        classBaseHealthMap.put("paladin", 10);
        classBaseHealthMap.put("ranger", 10);
        classBaseHealthMap.put("rogue", 8);
        classBaseHealthMap.put("sorcerer", 6);
        classBaseHealthMap.put("warlock", 8);
        classBaseHealthMap.put("wizard", 6);
    }

    // Character's base health based on class
    private static int characterBaseHPBasedOnClass(String characterClass) {
        return classBaseHealthMap.getOrDefault(characterClass.toLowerCase(), 0);
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
    // Validation loop for character Class.
    private static String characterClassValidation(Scanner keyboard, String characterName) {
        String characterRace;
        do {
            characterRace = getStringInput(keyboard, "Choose a Class for " + characterName);
            if (characterRace.equalsIgnoreCase("bard") || characterRace.equalsIgnoreCase("druid") || characterRace.equalsIgnoreCase("paladin") ||
                    characterRace.equalsIgnoreCase("barbarian") || characterRace.equalsIgnoreCase("fighter") || characterRace.equalsIgnoreCase("ranger") ||
                    characterRace.equalsIgnoreCase("cleric") || characterRace.equalsIgnoreCase("monk") || characterRace.equalsIgnoreCase("rogue")
                    || characterRace.equalsIgnoreCase("sorcerer") || characterRace.equalsIgnoreCase("warlock") || characterRace.equalsIgnoreCase("wizard")) {
                break;
            } else {
                System.out.println("Enter a valid Class. Please choose from bard, barbarian, cleric, sorcerer, druid, fighter, monk, warlock, paladin, ranger, rogue, wizard.");
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

    static {
        // Starting items for each class
        startingItemsMap.put("barbarian", Arrays.asList("Great Axe", "Two Handed Axes", "Explorer's Pack", "4 Javelins"));
        startingItemsMap.put("bard", Arrays.asList("Rapier", "Dagger", "Lute", "Diplomat's Pack", "Leather Armor"));
        startingItemsMap.put("cleric", Arrays.asList("Mace", "Scale Mail", "Light Crossbow", "20 Bolts", "Priest's Pack", "Shield", "Holy Symbol"));
        startingItemsMap.put("druid", Arrays.asList("Wooden Shield", "Scimitar", "Leather Armor", "Explorer's Pack", "Druidic Focus"));
        startingItemsMap.put("fighter", Arrays.asList("Chain Mail", "Martial Weapon", "Shield", "Light Crossbow", "20 Bolts", "Dungeoneer's Pack"));
        startingItemsMap.put("monk", Arrays.asList("Shortsword", "Dungeoneer's Pack", "10 Darts"));
        startingItemsMap.put("wizard", Arrays.asList("Quarterstaff", "Component Pouch", "Scholar's Pack", "Spellbook"));
        startingItemsMap.put("warlock", Arrays.asList("Light Crossbow", "20 Bolts", "Component Pouch", "Dungeoneer's Pack"));
        startingItemsMap.put("sorcerer", Arrays.asList("Light Crossbow", "20 Bolts", "Component Pouch", "Dungeoneer's Pack", "Two Daggers"));
        startingItemsMap.put("warrior", Arrays.asList("Light Crossbow", "20 Bolts", "Scholar's Pack", "Leather Armor", "Simple Weapon", "Two Daggers"));
        startingItemsMap.put("ranger", Arrays.asList("Scale Mail", "Two Shortswords", "Dungeoneer's Pack", "Longbow", "20 Arrows"));
        startingItemsMap.put("paladin", Arrays.asList("Martial Weapon", "Shield", "Five Javelins", "Priest's Pack", "Chain Mail", "Holy Symbol"));
    }

    private static List<String> startingItemsBasedOnClass(String characterClass) {
        return startingItemsMap.getOrDefault(characterClass.toLowerCase(), Collections.emptyList());
    }

    //Displays character information
    private static void consoleOutput(String party, String characterName, String characterRace, int characterBaseHealth, int characterAbilityScore, int characterArmorClass, int characterProficiencyBonus, int characterLevel, String characterClass, List<String> characterInventory, ArrayList<String> characterFeatures, String characterBackground) {
        System.out.println("Party: " + party);
        System.out.println("Character Name: " + characterName);
        System.out.println("Character Race: " + characterRace);
        System.out.println("Character Background: " + characterBackground);
        System.out.println("Ability Score: " + characterAbilityScore);
        System.out.println("Armor Class: " + characterArmorClass);
        System.out.println("Base Health: " + characterBaseHealth);
        System.out.println("Proficiency Bonus: " + characterProficiencyBonus);
        System.out.println("Character Level: " + characterLevel);
        System.out.println("Character Class: " + characterClass);

        System.out.println("Inventory:");
        for (String item : characterInventory) {
            String[] items = item.split(" ");
            for (String it : items) {
                System.out.println(it);
            }
        }

        System.out.println("Features:");
        for (String feature : characterFeatures) {
            System.out.println(" - " + feature);
        }
    }
}
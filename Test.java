import java.util.ArrayList;
import static java.lang.System.out;

public class Test {
    public static void main(String[] args) {
        String party = createParty();
        String characterRace = createCharacterRace();
        int characterAbilityScore = createAbilityScore();
        int characterArmorClass = createArmorClass();
        int characterProficiencyBonus = createProficiencyBonus();
        String characterClass = createCharacterClass();

        ArrayList<String> items = new ArrayList<String>() {{
            add("Item 1");
            add("Item 2");
            add("Item 3");
        }};

        Character character = new Character("Test Name");
        character.addGold(20);
        character.addItems(items);

        displayCharacterInformation(party, characterRace, characterAbilityScore, characterArmorClass, 
                                    characterProficiencyBonus, characterClass, character);
    }

    private static String createParty() {
        return "Test Party";
    }

    private static String createCharacterRace() {
        return "Test Race";
    }

    private static int createAbilityScore() {
        return 18;
    }

    private static int createArmorClass() {
        return 15;
    }

    private static int createProficiencyBonus() {
        return 2;
    }

    private static String createCharacterClass() {
        return "Test Class";
    }

    private static void displayCharacterInformation(String party, String characterRace, int characterAbilityScore, int characterArmorClass, int characterProficiencyBonus, String characterClass, Character character) {
        out.println();
        out.println("Party: " + party);
        out.println("Character Name: " + character.getName());
        out.println("Character Race: " + characterRace);
        out.println("Ability Score: " + characterAbilityScore);
        out.println("Armor Class: " + characterArmorClass);
        out.println("Max Health: " + character.getMaxHP());
        out.println("Proficiency Bonus: " + characterProficiencyBonus);
        out.println("Character Level: " + character.getLevel());
        out.println("Character Class: " + characterClass);

        out.println();
        character.getInventory();
        character.getFeatures();
        
        out.println();
        character.levelUp();
        character.levelUp();
        character.levelUp();
        character.levelUp();
        character.levelUp();

        character.getLevel();
        character.getFeatures();

        out.println();
        character.levelDown();
        character.levelDown();
        character.levelDown();

        character.getLevel();
        character.getFeatures();
    }
}
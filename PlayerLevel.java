import java.util.Scanner;

class LevelUp
{
    private String name;
    private String level;
    private int HP;
    public void Character(String name, int level, int HP){
        this.name = name;
        this.HP = 12;
    }
    public void increaseLevel (String level){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter Level");

        level =input.nextLine();
    System.out.println("Character's Level is now " + level);
    HP = HP + 7;
    System.out.println("Character's HP is now " + HP);
    }


    public void decreaseLevel(){
        System.out.println("Enter Level");
    Scanner input = new Scanner(System.in);
    level =input.nextLine();
        System.out.println("Character's Level is now " + level);
        HP = HP - 7;
        System.out.println("Character's HP is now " +HP);}
}



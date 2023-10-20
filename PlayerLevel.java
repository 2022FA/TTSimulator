import java.util.Scanner;

class LevelUp
{
    private String name;
    private int level;
    private int HP;
    public void Character(String name, int level, int HP){
        this.name = name;
        this.HP = 12;
    }
    public void increaseLevel (int level){
        if (level > 20){
            level = 20;
            System.out.println("level cannot go above 20.");}
        else{
        level = level + 1;
    System.out.println("Character's Level is now " + level);
    HP = HP + 7;
    System.out.println("Character's HP is now " + HP);}
    }


    public void decreaseLevel( int level){
        if (level < 1){
                level = 1;
                System.out.println("level cannot go below 1.");}
        else{
            level = level - 1;
        System.out.println("Character's Level is now " + level);
        HP = HP - 7;
        System.out.println("Character's HP is now " + HP);}
    }
}



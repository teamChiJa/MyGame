
package mygame;

import java.util.concurrent.ThreadLocalRandom;


public class Slime extends Monster{
     private String name;
    private int HP;
    private int MP;
    private int Attack;
    private int Defence;
    private String monsterName;
    
     public Slime(String name) {
        super(name);
        HP = ThreadLocalRandom.current().nextInt(10, 15);
        MP = ThreadLocalRandom.current().nextInt(1, 5);
        Attack = 5;
        Defence = 5;
        monsterName = "スライム";
    }
     
     
      public String getName() {
        return name;
    }

    public int getHP() {
        return HP;
    }

    public int getMP() {
        return MP;
    }

    public int getAttack() {
        return Attack;
    }

    public int getDefence() {
        return Defence;
    }
}

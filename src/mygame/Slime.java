
package mygame;

import java.util.concurrent.ThreadLocalRandom;


public class Slime {
     private String name;
    private int HP;
    private int MP;
    private int Attack;
    private int Defence;
    
     public Slime(String name) {
        this.name = name;
        HP = ThreadLocalRandom.current().nextInt(10, 15);
        MP = ThreadLocalRandom.current().nextInt(1, 5);
        Attack = 5;
        Defence = 5;
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


package mygame;

import java.util.concurrent.ThreadLocalRandom;


public class Chimera {
     private String name;
    private int HP;
    private int MP;
    private int Attack;
    private int Defence;
    
     public Chimera(String name) {
        this.name = name;
        HP = ThreadLocalRandom.current().nextInt(15, 30);
        MP = ThreadLocalRandom.current().nextInt(10, 15);
        Attack = 15;
        Defence = 10;
    }
     
      public String getName() {
        return name;//
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

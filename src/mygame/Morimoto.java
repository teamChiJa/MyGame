
package mygame;

import java.util.concurrent.ThreadLocalRandom;


public class Morimoto {
     private String name;
    private int HP;
    private int MP;
    private int Attack;
    private int Defence;
    
     public Morimoto(String name) {
        this.name = name;
        HP = ThreadLocalRandom.current().nextInt(60, 100);
        MP = ThreadLocalRandom.current().nextInt(45, 50);
        Attack = 40;
        Defence = 35;
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

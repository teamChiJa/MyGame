
package mygame;

import java.util.concurrent.ThreadLocalRandom;


public class Morimoto extends Monster{
     private String name;
    private int HP;
    private int MP;
    private int Attack;
    private int Defence;
    private String monsterName;
    
     public Morimoto(String name) {
        super(name);
        HP = ThreadLocalRandom.current().nextInt(60, 100);
        MP = ThreadLocalRandom.current().nextInt(45, 50);
        Attack = ThreadLocalRandom.current().nextInt(10, 150);
        Defence = 35;
        monsterName="morimoto";
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

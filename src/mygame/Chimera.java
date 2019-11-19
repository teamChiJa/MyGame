
package mygame;

import java.util.concurrent.ThreadLocalRandom;


public class Chimera extends Monster{
     private String name;
    private int HP;
    private int MP;
    private int Attack;
    private int Defence;
    private String monsterName;
    
     public Chimera(String name) {
        super(name);
        HP = ThreadLocalRandom.current().nextInt(15, 30);
        MP = ThreadLocalRandom.current().nextInt(10, 15);
        Attack = 15;
        Defence = 10;
        monsterName="キメラ";
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


package mygame;

import java.util.concurrent.ThreadLocalRandom;


public class Slime extends Monster{
     private String name;
    private int hp;
    private int mp;
    private int attack;
    private int defence;
    private final String MonsterName = "Slime";
    
     public Slime(String name) {
        super(name);
        hp = ThreadLocalRandom.current().nextInt(10, 15);
        mp = ThreadLocalRandom.current().nextInt(1, 5);
        attack = 5;
        defence = 5;
    }

    public void attack(Job jb){
        int damage = this.getAttack() - jb.getDefence();
        if(damage<0){
            damage = 1;
        }
        if(this.getHp()>0){
            jb.setHp(jb.getHp()-damage);           
        }
    }
     
     public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getMp() {
        return mp;
    }

    public void setMp(int mp) {
        this.mp = mp;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefence() {
        return defence;
    }

    public void setDefence(int defence) {
        this.defence = defence;
    }

    public String getMonsterName() {
        return MonsterName;
    }
     
    
}

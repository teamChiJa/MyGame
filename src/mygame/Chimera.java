
package mygame;

import java.util.concurrent.ThreadLocalRandom;


public class Chimera extends Monster{
     private String name;
    private int hp;
    private int mp;
    private int attack;
    private int defence;
    private final String MonsterName = "Chimera";
    
     public Chimera(String name) {
        super(name);
        hp = ThreadLocalRandom.current().nextInt(15, 30);
        mp = ThreadLocalRandom.current().nextInt(10, 15);
        attack = 15;
        defence = 10;
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

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public void setDefence(int defence) {
        this.defence = defence;
    }

    public String getMonsterName() {
        return MonsterName;
    }

    public String getName() {
        return name;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefence() {
        return defence;
    }
}

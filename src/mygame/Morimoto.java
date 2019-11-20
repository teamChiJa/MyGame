
package mygame;

import java.util.concurrent.ThreadLocalRandom;


public class Morimoto extends Monster{
     private String name;
    private int hp;
    private int mp;
    private int attack;
    private int defence;
    private final String MonsterName = "Morimoto";
    
     public Morimoto(String name) {
        super(name);
        hp = ThreadLocalRandom.current().nextInt(15,25);
        mp = ThreadLocalRandom.current().nextInt(45, 50);
        attack = ThreadLocalRandom.current().nextInt(10, 150);
        defence = 5;
       
    }

   public void attack(Job jb){
        int damage = this.getAttack() - jb.getDefence();
        if(damage<0){
            damage = 1;
        }
        if(this.getHp()>0){
            System.out.println(this.name + "の攻撃");
            System.out.println(jb.getName() + "に" + damage +"ダメージ");
            jb.setHp(jb.getHp()-damage);
            System.out.println(jb.getName() + " のHP： " +jb.getHp());
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

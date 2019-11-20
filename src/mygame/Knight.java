package mygame;

import java.util.concurrent.ThreadLocalRandom;

public class Knight extends Job {

    private String name;
    private int hp;
    private int mp;
    private int attack;
    private int defence;
    private final String jobName = "Knight";

    public Knight(String name) {
        super(name);
        hp = ThreadLocalRandom.current().nextInt(35, 45);
        mp = ThreadLocalRandom.current().nextInt(5, 15);
        attack = 15;
        defence = 30;
    }
    
    public void attack(Monster ms){
        int damage = this.getAttack() - (int)(ms.getDefence() * 0.8);
        if(damage<0){
            damage = 1;
        }
        if(this.hp>0){
            ms.setHp(ms.getHp()-damage);           
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

    public String getJobName() {
        return jobName;
    }

}

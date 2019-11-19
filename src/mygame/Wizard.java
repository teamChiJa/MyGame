package mygame;

import java.util.concurrent.ThreadLocalRandom;

public class Wizard extends Job {

    private String name;
    private int hp;
    private int mp;
    private int attack;
    private int defence;
    private final String JobName = "Wizard";

    public Wizard(String name) {
        super(name);
        hp = ThreadLocalRandom.current().nextInt(20, 30);
        mp = ThreadLocalRandom.current().nextInt(20, 30);
        attack = 5;
        defence = 5;
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
        return JobName;
    }

}

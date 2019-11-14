package mygame;

import java.util.concurrent.ThreadLocalRandom;

public class Hero {

    private String name;
    private int HP;
    private int MP;
    private int Attack;
    private int Defence;

    public Hero(String name) {
        this.name = name;
        HP = ThreadLocalRandom.current().nextInt(30, 40);
        MP = ThreadLocalRandom.current().nextInt(10, 20);
        Attack = 20;
        Defence = 20;
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

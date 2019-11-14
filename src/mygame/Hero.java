package mygame;

import java.util.concurrent.ThreadLocalRandom;

public class Hero extends Job {

    private String name;
    private int hp;
    private int mp;
    private int attack;
    private int defence;

    public Hero(String name, int hp, int mp, int attack, int defence) {
        super(name, hp, mp, attack, defence);
    }

}

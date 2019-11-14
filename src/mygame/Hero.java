package mygame;



public class Hero extends Job {

    private String name;
    private int hp;
    private int mp;
    final int attack = 20;
    final int defence = 20;

    public Hero(String name, int hp, int mp) {
        super(name, hp, mp);
    }

}

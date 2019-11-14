package mygame;

public class Fighter extends Job {

    private String name;
    private int hp;
    final int mp = 0;
    private int attack;
    final int defence = 10;

    public Fighter(String name, int hp,int attack) {
        super(name, hp,attack);
    }

}

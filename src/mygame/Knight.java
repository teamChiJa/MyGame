
package mygame;


public class Knight extends Job{
    private String name;
    private int hp;
    private int mp;
    final int attack = 15;
    final int defence = 30;

    public Knight(String name, int hp, int mp, int attack, int defence) {
        super(name, hp, mp, attack, defence);
    }
}

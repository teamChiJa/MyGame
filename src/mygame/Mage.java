
package mygame;


public class Mage extends Job{
    private String name;
    private int hp;
    private int mp;
    final int attack = 5;
    final int defence = 5;

    public Mage(String name, int hp, int mp, int attack, int defence) {
        super(name, hp, mp, attack, defence);
    
}
}

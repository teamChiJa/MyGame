
package mygame;




public class Wizard extends Job{
      private String name;
    private int hp;
    private int mp;
    final int attack = 5;
    final int defence = 5;

    public Wizard(String name, int hp, int mp) {
        super(name, hp, mp,"Wizard");
    }
}

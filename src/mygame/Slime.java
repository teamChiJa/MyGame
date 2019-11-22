package mygame;

import java.util.concurrent.ThreadLocalRandom;
import static mygame.Command.pl;

public class Slime extends Monster {

    private String name;
    private int hp;
    private final int MAX_HP;
    private int mp;
    private final int MAX_MP;
    private int attack;
    private int defence;
    private final String MonsterName = "Slime";
    private String enemyNo ="敵";

    public Slime(String name) {
        this.name = name;
        hp = ThreadLocalRandom.current().nextInt(11, 16);
        MAX_HP=hp;
        mp = ThreadLocalRandom.current().nextInt(2, 6);
        MAX_MP=mp;
        attack = 5;
        defence = 5;
    }

    public void attack(Job jb) {
        int damage = this.getAttack() - jb.getDefence();
        if (damage <= 0) {
            damage = 1;
        }
        if (this.getHp() > 0) {
            System.out.println(this.name + "の攻撃");
            System.out.println(jb.getName() + "に" + damage + "ダメージ");
            jb.setHp(jb.getHp() - damage);
            if (jb.getHp() <= 0) {
                jb.setHp(0);
                pl(jb.getName() + "は倒れた");
            }
            System.out.println(jb.getName() + " のHP： " + jb.getHp()+"/"+jb.getMAX_HP());
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

    public String getEnemyNo() {
        return enemyNo;
    }

    public void setEnemyNo(String enemyNo) {
        this.enemyNo = enemyNo;
    }

    /**
     * @return the MAX_HP
     */
    public int getMAX_HP() {
        return MAX_HP;
    }

    /**
     * @return the MAX_MP
     */
    public int getMAX_MP() {
        return MAX_MP;
    }

}

package mygame;

import java.util.concurrent.ThreadLocalRandom;
import static mygame.Command.pl;

public class Fighter extends Job {

    private String name;
    private int hp;
    private final int MAX_HP;
    private int mp;
    private final int MAX_MP;
    private int attack;
    private int defence;
    private final String jobName = "Fighter";
    private boolean magicList = false;
    private boolean spMoveList = false;
    private final int D_ATTACK;
    private final int D_DEFENCE;
    
    public Fighter(String name) {
        this.name = name;
        hp = ThreadLocalRandom.current().nextInt(31, 41);
        MAX_HP = hp;
        mp = 0;
        MAX_MP = mp;
        attack = ThreadLocalRandom.current().nextInt(41, 51);
        defence = 10;
        D_ATTACK = attack;
        D_DEFENCE = defence;
    }

    public int getD_ATTACK() {
        return D_ATTACK;
    }

    public int getD_DEFENCE() {
        return D_DEFENCE;
    }

    public void attack(Monster ms) {
        int w = this.getAttack();
        if (hp > 20 && hp <= 30) {
            w *= 1.2;
        }
        if (hp > 10 && hp <= 20) {
            w *= 1.5;
        }
        if (hp > 3 && hp <= 10) {
            w *= 2;
        }
        if (hp > 0 && hp <= 3) {
            w *= 5;
        }

        int damage = w - ms.getDefence() ;
        if (damage <= 0) {
            damage = 1;
        }
        if (this.hp > 0) {
            System.out.println(this.getName() + " の攻撃");
            System.out.println(ms.getName() + "に" + damage + "ダメージ");//
            ms.setHp(ms.getHp() - damage);
            if (ms.getHp() <= 0) {
                ms.setHp(0);
                pl(this.name + "は、"  + ms.getName() + "を倒した");
            }
            System.out.println(ms.getName() + "のHP： " + ms.getHp() + "/" + ms.getMAX_HP());
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
    
    public boolean isMagicList() {
        return magicList;
    }

    public boolean isSpMoveList() {
        return spMoveList;
    }

}

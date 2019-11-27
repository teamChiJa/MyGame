package mygame;

import java.util.concurrent.ThreadLocalRandom;
import static mygame.Command.jobAttack;
import static mygame.Command.pl;
import static mygame.Command.target;
import static mygame.Insert.insertNumber;

public class Hero extends Job {

    private String name;
    private int hp;
    private final int MAX_HP;
    private int mp;
    private final int MAX_MP;
    private int attack;
    private int defence;
    private final String jobName = "Hero";
    private boolean magicList = false;
    private boolean spMoveList = true;
    private final int D_ATTACK;
    private final int D_DEFENCE;

    public Hero(String name) {
        this.name = name;
        hp = ThreadLocalRandom.current().nextInt(31, 41);
        MAX_HP = hp;
        mp = ThreadLocalRandom.current().nextInt(11, 21);
        MAX_MP = mp;
        attack = 20;
        defence = 20;
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
        int acount;
        int damage = (int) ((this.getAttack() - ms.getDefence()) * ThreadLocalRandom.current().nextDouble(0.8, 1.2));
        if (damage <= 0) {
            damage = 1;
        }
        if (this.hp > 0) {
            acount = ThreadLocalRandom.current().nextInt(0, 101);
            if (0 <= acount && 70 > acount) {
                System.out.println(this.getName() + " の攻撃");
                System.out.println(ms.getName() + "に" + damage + "ダメージ");
                ms.setHp(ms.getHp() - damage);
                if (ms.getHp() <= 0) {
                    ms.setHp(0);
                    pl(this.name + "は、" + ms.getName() + "を倒した");
                }
                addAtack(ms, damage);
                System.out.println(ms.getName() + "のHP： " + ms.getHp() + "/" + ms.getMAX_HP());
            } else if (70 <= acount && 75 > acount) {
                System.out.println(this.getName() + " の会心の一撃");
                System.out.println(ms.getName() + "に" + damage * 3 + "ダメージ");
                ms.setHp(ms.getHp() - damage * 3);
                if (ms.getHp() <= 0) {
                    ms.setHp(0);
                    pl(this.name + "は、" + ms.getName() + "を倒した");
                }
                addAtack(ms, damage);
                System.out.println(ms.getName() + "のHP： " + ms.getHp() + "/" + ms.getMAX_HP());
            } else if (75 <= acount && 90 > acount) {
                System.out.println(this.getName() + " の攻撃");
                System.out.println(ms.getName() + "に" + damage + "ダメージ");
                ms.setHp(ms.getHp() - damage);
                if (ms.getHp() <= 0) {
                    ms.setHp(0);
                    pl(this.name + "は、" + ms.getName() + "を倒した");
                }
                addAtack(ms, damage);
                addAtack(ms, damage);
                System.out.println(ms.getName() + "のHP： " + ms.getHp() + "/" + ms.getMAX_HP());
            } else if (90 <= acount && 97 > acount) {
                System.out.println(this.getName() + " の攻撃");
                System.out.println(ms.getName() + "に" + damage + "ダメージ");
                ms.setHp(ms.getHp() - damage);
                if (ms.getHp() <= 0) {
                    ms.setHp(0);
                    pl(this.name + "は、" + ms.getName() + "を倒した");
                }
                addAtack(ms, damage);
                addAtack(ms, damage);
                addAtack(ms, damage);
                System.out.println(ms.getName() + "のHP： " + ms.getHp() + "/" + ms.getMAX_HP());
                System.out.println(this.getName() + " の攻撃");
            } else if (97 <= acount && 101 > acount) {
                System.out.println(ms.getName() + "に" + damage + "ダメージ");
                ms.setHp(ms.getHp() - damage);
                if (ms.getHp() <= 0) {
                    ms.setHp(0);
                    pl(this.name + "は、" + ms.getName() + "を倒した");
                }
                addAtack(ms, damage);
                addAtack(ms, damage);
                addAtack(ms, damage);
                addAtack(ms, damage);
                System.out.println(ms.getName() + "のHP： " + ms.getHp() + "/" + ms.getMAX_HP());
            }

        }

    }

    public void addAtack(Monster ms, int damage) {
        if (ms.getHp() > 0) {
            System.out.println(this.getName() + " の追加攻撃");
            damage = (int) ((this.getAttack() - ms.getDefence()) * ThreadLocalRandom.current().nextDouble(0.8, 1.0));
            System.out.println(ms.getName() + "に" + damage + "ダメージ");//
            ms.setHp(ms.getHp() - damage);
            if (ms.getHp() <= 0) {
                ms.setHp(0);
                pl(this.name + "は、" + ms.getName() + "を倒した");
            }

        }
    }

    public void gAttack() {
        int smp = 10;
        Monster ms = target();
        int damage = (int) (((this.getAttack() * 2.5) - ms.getDefence()) * ThreadLocalRandom.current().nextDouble(0.8, 1.2));
        this.mp -= 10;
        ms.setMp(ms.getHp() - damage);
        System.out.println(ms.getName() + "に" + damage + "ダメージ");
        if (ms.getHp() <= 0) {
            ms.setHp(0);
            pl(this.getName() + "は" + ms.getName() + "を倒した");
        }
        System.out.println(ms.getName() + "のHP： " + ms.getHp() + "/" + ms.getMAX_HP());
    }
    public void spMoveList(){
        int mj;
        for (;;) {
            mj = insertNumber("1.ギガスラッシュ >");
            if (mj > 0 && mj < 2) {
                break;
            }
        }
        switch (mj) {
            case 1:
                this.gAttack();
                break;
            
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

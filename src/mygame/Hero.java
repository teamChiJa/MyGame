package mygame;

import java.util.concurrent.ThreadLocalRandom;
import static mygame.Command.jobAttack;
import static mygame.Command.pl;
import static mygame.Command.target;
import static mygame.Insert.insertNumber;
import static mygame.Combat.*;
import static mygame.Insert.foolProof;

public class Hero extends Job {

    private String name;
    private int hp;
    private int MAX_HP;
    private int mp;
    private int MAX_MP;
    private int attack;
    private int defence;
    private final String jobName = "Hero";
    private boolean magicList = false;
    private boolean spMoveList = true;
    private int D_ATTACK;
    private int D_DEFENCE;
    private int level;
    private int exp;
    private int maxexp;

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
        level = 1;
        exp = 0;
        maxexp = 128;
    }

    public int getD_ATTACK() {
        return D_ATTACK;
    }

    public int getD_DEFENCE() {
        return D_DEFENCE;
    }

    public void setMAX_HP(int MAX_HP) {
        this.MAX_HP = MAX_HP;
    }

    public void setMAX_MP(int MAX_MP) {
        this.MAX_MP = MAX_MP;
    }

    public void setD_ATTACK(int D_ATTACK) {
        this.D_ATTACK = D_ATTACK;
    }

    public void setD_DEFENCE(int D_DEFENCE) {
        this.D_DEFENCE = D_DEFENCE;
    }
    
    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public int getMaxexp() {
        return maxexp;
    }

    public void setMaxexp(int maxexp) {
        this.maxexp = maxexp;
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
        pl(this.name + "の、ギガスラッシュ！");
        int smp = 10;
        this.mp -= smp;
        for (Monster ms : monsterParty) {
            int damage = (int) (((this.getAttack() * 2.5) - ms.getDefence()) * ThreadLocalRandom.current().nextDouble(0.8, 1.2));
            ms.setHp(ms.getHp() - damage);
            System.out.println(ms.getName() + "に" + damage + "ダメージ");
            if (ms.getHp() <= 0) {
                ms.setHp(0);
                pl(this.getName() + "は" + ms.getName() + "を倒した");
            }
            System.out.println(ms.getName() + "のHP： " + ms.getHp() + "/" + ms.getMAX_HP());
        }
    }

    public void specialToString() {
        int mj;
        for (;;) {
            mj = insertNumber("1.ギガスラッシュ[10MP]\r\n0.キャンセル >");
            if (mj >= 0 && mj < 2) {
                break;
            }
        }
        switch (mj) {
            case 0:
                next = false;
                break;
            case 1:
                if (this.mp < 10) {
                    pl("MPが足りません");
                    next = false;
                    break;
                }
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

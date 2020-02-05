package mygame;

import java.util.concurrent.ThreadLocalRandom;
import static mygame.Command.pl;

public class Fighter extends Job {

    private String name;
    private int hp;
    private int MAX_HP;
    private int mp;
    private int MAX_MP;
    private int attack;
    private int defence;
    private final String jobName = "Fighter";
    private boolean magicList = false;
    private boolean spMoveList = false;
    private int D_ATTACK;
    private int D_DEFENCE;
    private int level;
    private int exp;
    private int maxexp;
    private int id;

    public Fighter(String name,int ID) {
        this.name = name;
        hp = ThreadLocalRandom.current().nextInt(31, 41);
        MAX_HP = hp;
        mp = 0;
        MAX_MP = mp;
        attack = ThreadLocalRandom.current().nextInt(41, 51);
        defence = 10;
        D_ATTACK = attack;
        D_DEFENCE = defence;
        level = 1;
        exp = 0;
        maxexp = 128;
        id = ID;
    }

    public Fighter(String name, int hp, int MAX_HP, int mp, int MAX_MP, int attack, int defence, int D_ATTACK, int D_DEFENCE, int level, int exp, int maxexp,int id) {
        this.name = name;
        this.hp = hp;
        this.MAX_HP = MAX_HP;
        this.mp = mp;
        this.MAX_MP = MAX_MP;
        this.attack = attack;
        this.defence = defence;
        this.D_ATTACK = D_ATTACK;
        this.D_DEFENCE = D_DEFENCE;
        this.level = level;
        this.exp = exp;
        this.maxexp = maxexp;
        this.id = id;
    }
    
    public void setD_ATTACK(int D_ATTACK) {
        this.D_ATTACK = D_ATTACK;
    }

    public void setD_DEFENCE(int D_DEFENCE) {
        this.D_DEFENCE = D_DEFENCE;
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

        int damage = w - ms.getDefence();
        if (damage <= 0) {
            damage = 1;
        }
        if (this.hp > 0) {
            System.out.println(this.getName() + " の攻撃");
            System.out.println(ms.getName() + "に" + damage + "ダメージ");//
            ms.setHp(ms.getHp() - damage);
            if (ms.getHp() <= 0) {
                ms.setHp(0);
                pl(this.name + "は、" + ms.getName() + "を倒した");
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}

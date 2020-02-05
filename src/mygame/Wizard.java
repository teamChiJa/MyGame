package mygame;

import java.util.concurrent.ThreadLocalRandom;
import static mygame.Combat.*;
import static mygame.Command.*;
import static mygame.Insert.*;

public class Wizard extends Job {

    private String name;
    private int hp;
    private int MAX_HP;
    private int mp;
    private int MAX_MP;
    private int attack;
    private int defence;
    private final String JobName = "Wizard";
    private boolean magicList = true;
    private boolean spMoveList = false;
    private int D_ATTACK;
    private int D_DEFENCE;
    private int level;
    private int exp;
    private int maxexp;
private int id;
    public Wizard(String name,int ID) {
        this.name = name;
        hp = ThreadLocalRandom.current().nextInt(21, 31);
        MAX_HP = hp;
        mp = ThreadLocalRandom.current().nextInt(21, 31);
        MAX_MP = mp;
        attack = 5;
        defence = 5;
        D_ATTACK = attack;
        D_DEFENCE = defence;
        level = 1;
        exp = 0;
        maxexp = 128;
        id = ID;
    }

    public Wizard(String name, int hp, int MAX_HP, int mp, int MAX_MP, int attack, int defence, int D_ATTACK, int D_DEFENCE, int level, int exp, int maxexp,int id) {
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
    
    public int getD_ATTACK() {
        return D_ATTACK;
    }

    public int getD_DEFENCE() {
        return D_DEFENCE;
    }

    public void attack(Monster ms) {
        int damage = this.getAttack() - (int) (ms.getDefence() * 0.8);
        if (damage <= 0) {
            damage = 1;
        }
        int rmp = damage * 2;
        if (this.MAX_MP < (this.mp + rmp)) {
            rmp = this.MAX_MP - this.mp;
        }
        this.setMp(this.mp + rmp);
        if (this.hp > 0) {
            System.out.println(this.getName() + " の攻撃");
            System.out.println(ms.getName() + "に" + damage + "ダメージ");
            ms.setHp(ms.getHp() - damage);
            if (ms.getHp() <= 0) {
                ms.setHp(0);
                pl(this.name + "は、" + ms.getName() + "を倒した");
            }
            System.out.println(ms.getName() + "のHP： " + ms.getHp() + "/" + ms.getMAX_HP());
        }
    }

    public void recover() {
        if (this.mp >= 5) {
            int sjob;
            Job j;
            for (;;) {
                playerHpToString();
                sjob = insertNumber("回復する仲間を選んでください >");
                if (sjob > 0 && sjob <= combatParty.size()) {
                    if (combatParty.get(sjob).getHp() > 0) {
                        break;
                    }
                    pl("死んでいる仲間は回復できません");
                }
            }
            pl(combatParty.get(sjob).getName() + "のHP:" + combatParty.get(sjob).getHp());
            int smp;
            int srp;
            j = combatParty.get(sjob);
            for (;;) {
                srp = insertNumber("1. 2. 3.");
                if (srp == 1 && this.mp >= 5) {
                    pl("");
                    this.mp -= 5;
                    j.setHp(j.getHp() + 10);
                    if (j.getMAX_HP() <= j.getHp()) {
                        j.setHp(j.getMAX_HP());
                        pl(j.getName() + "のHPは満タンになった");
                    } else {
                        pl(j.getName() + "のHPは10ポイント回復した");
                    }

                    break;
                }
                if (srp == 2 && this.mp >= 10) {
                    this.mp -= 10;
                    j.setHp(j.getHp() + 20);
                    if (j.getMAX_HP() <= j.getHp()) {
                        j.setHp(j.getMAX_HP());
                        pl(j.getName() + "のHPは満タンになった");
                    } else {
                        pl(j.getName() + "のHPは20ポイント回復した");
                    }
                    break;
                }
                if (srp == 3 && this.mp >= 15) {
                    this.mp -= 15;
                    j.setHp(j.getHp() + 30);
                    if (j.getMAX_HP() <= j.getHp()) {
                        j.setHp(j.getMAX_HP());
                        pl(j.getName() + "のHPは満タンになった");
                    } else {
                        pl(j.getName() + "のHPは30ポイント回復した");
                    }
                    break;
                }
                pl("使えるMPを超えています");
            }
        }
    }

    public void fire() {
        int smp;
        int f;
        int mhp;
        int sel_mp;
        if (this.mp > 0 && this.hp > 0) {
            for (;;) {

                sel_mp = insertNumber("1.メラ　2.メラミ　3.メラゾーマ >");
                if (sel_mp == 1) {
                    smp = 5;
                    if ((this.mp - smp) >= 0) {
                        break;
                    }
                }
                if (sel_mp == 2) {
                    smp = 10;
                    if ((this.mp - smp) >= 0) {
                        break;
                    }
                }
                if (sel_mp == 3) {
                    smp = 20;
                    if ((this.mp - smp) >= 0) {
                        break;
                    }
                }

                pl("使えるMPを超えています");
            }
            if (smp == 5) {
                for (;;) {
                    if (this.mp < smp) {
                        pl("MPが足りません");
                        next = false;
                        break;
                    }
                    f = smp * 3;
                    for (Monster m : monsterParty) {
                        m.setHp(m.getHp() - f);
                        if (m.getHp() < 0) {
                            m.setHp(0);
                        }
                    }
                    pl(this.name + "はメラを唱えた");
                    this.mp -= smp;
                    pl("敵全体に" + f + "のダメージ");
                    break;
                }
            }

            if (smp == 10) {
                for (;;) {
                    if (this.mp < smp) {
                        pl("MPが足りません");
                        next = false;
                        break;
                    }
                    f = smp * 5;
                    for (Monster m : monsterParty) {
                        m.setHp(m.getHp() - f);
                        if (m.getHp() < 0) {
                            m.setHp(0);
                        }
                    }
                    pl(this.getName() + "はメラミを唱えた");
                    this.mp -= smp;
                    pl("敵全体に" + f + "のダメージ");
                    break;
                }
            }

            if (smp == 20) {
                for (;;) {
                    if (this.mp < smp) {
                        pl("MPが足りません");
                        next = false;
                        break;
                    }
                    f = smp * 8;
                    for (Monster m : monsterParty) {
                        m.setHp(m.getHp() - f);
                        if (m.getHp() < 0) {
                            m.setHp(0);
                        }
                    }
                    pl(this.name + "はメラゾーマを唱えた");

                    pl("敵全体に" + f + "のダメージ");

                    this.setMp(this.mp - smp);
                    break;
                }
            }
        }
    }

    public void magicToString() {
        int mj;
        for (;;) {
            mj = insertNumber("1.ホイミ[5MP 10MP 15MP]\r\n2.メラ[5MP 10MP 20MP]\r\n0.キャンセル>");
            if (mj >= 0 && mj < 3) {
                break;
            }
        }
        switch (mj) {
            case 0:
                next = false;
                break;
            case 1:
                if (this.mp < 5) {
                    pl("MPが足りません");
                    next = false;
                    break;
                }
                this.recover();
                break;
            case 2:
                if (this.mp < 5) {
                    pl("MPが足りません");
                    next = false;
                    break;
                }
                this.fire();
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
        return JobName;
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

package mygame;

import java.util.concurrent.ThreadLocalRandom;
import static mygame.Combat.combatParty;
import static mygame.Combat.next;
import static mygame.Command.pl;
import static mygame.Command.*;
import static mygame.Insert.insertNumber;

public class Knight extends Job {

    private String name;
    private int hp;
    private final int MAX_HP;
    private int mp;
    private final int MAX_MP;
    private int attack;
    private int defence;
    private final String jobName = "Knight";
    private boolean magicList = true;
    private boolean spMoveList = false;
    private final int D_ATTACK;
    private final int D_DEFENCE;

    public Knight(String name) {
        this.name = name;
        hp = ThreadLocalRandom.current().nextInt(36, 46);
        MAX_HP = hp;
        mp = ThreadLocalRandom.current().nextInt(6, 16);
        MAX_MP = mp;
        attack = 15;
        defence = 30;
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
        int damage = this.getAttack() - (int) (ms.getDefence() * 0.8);
        if (damage <= 0) {
            damage = 1;
        }
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
                srp = insertNumber("1. 2. ");
                if (srp == 1 && this.mp >= 5) {
                    pl("");
                    this.mp -= 5;
                    j.setHp(j.getHp() + 10);
                    if (j.getMAX_HP() < j.getHp()) {
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
                    if (j.getMAX_HP() < j.getHp()) {
                        j.setHp(j.getMAX_HP());
                        pl(j.getName() + "のHPは満タンになった");
                    } else {
                        pl(j.getName() + "のHPは20ポイント回復した");
                    }
                    break;
                }

                pl("使えるMPを超えています");
            }
        }
    }

    public void attackBoost() {
        int sjob;
        Job j;
        for (;;) {
            playerHpToString();
            sjob = insertNumber("対称の仲間を選んでください >");
            if (sjob > 0 && sjob <= combatParty.size()) {
                if (combatParty.get(sjob).getHp() > 0) {
                    break;
                }
                pl("死んでいる仲間は選択できません");
            }
        }
        int smp = 5;
        j = combatParty.get(sjob);
        combatParty.get(sjob).setAttack((int) (combatParty.get(sjob).getAttack() * 1.5));
        this.mp -= smp;
        pl(j.getName() + "のAttackが上昇した");
    }

    public void defenceBoost() {
        int sjob;
        Job j;
        for (;;) {
            playerHpToString();
            sjob = insertNumber("対称の仲間を選んでください >");
            if (sjob > 0 && sjob <= combatParty.size()) {
                if (combatParty.get(sjob).getHp() > 0) {
                    break;
                }
                pl("死んでいる仲間は選択できません");
            }
        }
        int smp;
        smp = 5;

        j = combatParty.get(sjob);
        combatParty.get(sjob).setDefence((int) (combatParty.get(sjob).getDefence() * 1.5));
        this.mp -= smp;
        pl(j.getName() + "のDefenceは上昇した");
    }

    public void magicToString() {
        int mj;//
        for (;;) {
            mj = insertNumber("1.ホイミ<5MP 10MP> 2.バイキルト<5MP> 3.スカラ<5MP>\r\n0.キャンセル >");
            if (mj >= 0 && mj < 4) {
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
                this.attackBoost();
                break;
            case 3:
                if (this.mp < 5) {
                    pl("MPが足りません");
                    next = false;
                    break;
                }
                this.defenceBoost();
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

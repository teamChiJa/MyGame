package mygame;

import java.util.concurrent.ThreadLocalRandom;
import static mygame.Combat.combatParty;
import static mygame.Command.pl;
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

    public Knight(String name) {
        this.name = name;
        hp = ThreadLocalRandom.current().nextInt(36, 46);
        MAX_HP = hp;
        mp = ThreadLocalRandom.current().nextInt(6, 16);
        MAX_MP = mp;
        attack = 15;
        defence = 30;
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
            if (ms.getHp() < 0) {
                ms.setHp(0);
            }
            System.out.println(ms.getName() + "のHP： " + ms.getHp() + "/" + ms.getMAX_HP());
        }
    }

    public void recover() {
        int sjob;
        Job j;
        for (;;) {
            sjob = insertNumber("回復する仲間を選んでください");
            if (sjob > 0 && sjob <= combatParty.size()) {
                if (combatParty.get(sjob).getHp() > 0) {
                    break;
                }
                pl("死んでいる仲間は回復できません");
            }
        }
        pl(combatParty.get(sjob).getName() + "のHP:" + combatParty.get(sjob).getHp());
        int smp;
        for (;;) {
            smp = insertNumber("消費するMPを入力してください（消費MP　1ポイント毎に、HP5ポイント回復）");
            if ((this.mp - smp) >= 0) {
                break;
            }
            pl("使えるMPを超えています");
        }
        j = combatParty.get(sjob);
        int rhp = smp * 5;
        int canrhp = combatParty.get(sjob).getMAX_HP() - combatParty.get(sjob).getHp();
        if (rhp > canrhp) {
            rhp = canrhp;
        }
        combatParty.get(sjob).setHp(combatParty.get(sjob).getHp() + rhp);
        pl(combatParty.get(sjob).getName() + "のHPは" + rhp + "ポイント回復しました");
        pl(j.getName() + "のHP：" + j.getHp() + "/" + j.getMAX_HP());
    }

    public void attackBoost() {
        int sjob;
        Job j;
        for (;;) {
            sjob = insertNumber("対称の仲間を選んでください");
            if (sjob > 0 && sjob <= combatParty.size()) {
                if (combatParty.get(sjob).getHp() > 0) {
                    break;
                }
                pl("死んでいる仲間は選択できません");
            }
        }
        int smp;
        for (;;) {
            smp = insertNumber("消費するMPを入力してください（消費MP　1ポイント毎に、Attack 2ポイント上昇）");
            if ((this.mp - smp) >= 0) {
                break;
            }
            pl("使えるMPを超えています");
        }
        j = combatParty.get(sjob);
        int bat = smp * 2;
        combatParty.get(sjob).setAttack(combatParty.get(sjob).getAttack() + bat);
        pl(combatParty.get(sjob).getName() + "のAttackは" + bat + "ポイント上昇しました");
        pl(j.getName() + "のAttack：" + j.getAttack());
    }

    public void defenceBoost() {
        int sjob;
        Job j;
        for (;;) {
            sjob = insertNumber("対称の仲間を選んでください");
            if (sjob > 0 && sjob <= combatParty.size()) {
                if (combatParty.get(sjob).getHp() > 0) {
                    break;
                }
                pl("死んでいる仲間は選択できません");
            }
        }
        int smp;
        for (;;) {
            smp = insertNumber("消費するMPを入力してください（消費MP　1ポイント毎に、Defence 2ポイント上昇）");
            if ((this.mp - smp) >= 0) {
                break;
            }
            pl("使えるMPを超えています");
        }
        j = combatParty.get(sjob);
        int bat = smp * 2;
        combatParty.get(sjob).setDefence(combatParty.get(sjob).getDefence() + bat);
        pl(combatParty.get(sjob).getName() + "のDefenceは" + bat + "ポイント上昇しました");
        pl(j.getName() + "のAttack：" + j.getDefence());
    }

    public void magicToString() {
        int mj;
        for (;;) {
            mj = insertNumber("1.Recocer 2.AttackBoost 3.DeffenceBoost");
            if (mj > 0 && mj < 4) {
                break;
            }
        }
        switch (mj) {
            case 1:
                this.recover();
                break;
            case 2:
                this.attackBoost();
                break;
            case 3:
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

}

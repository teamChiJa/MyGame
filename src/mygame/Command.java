package mygame;

import java.util.concurrent.ThreadLocalRandom;
import static mygame.Combat.*;
import static mygame.Insert.*;
import static mygame.MemberManager.*;

public class Command {

    public static void p(Object msg) {
        System.out.print(msg);
    }

    public static void pl(Object msg) {
        System.out.println(msg);
    }

    public static void monstersAttack() {
        int jbran;
        boolean l;
        for (int i = 0; i < monsterParty.size(); i++) {
            pl("");
            for (;;) {
                jbran = ThreadLocalRandom.current().nextInt(0, combatParty.size());
                if (!jobLive()) {
                    break;//みんなが死んでたら
                }
                if (combatParty.get(jbran).getHp() != 0) {
                    monsterParty.get(i).attack(combatParty.get(jbran));
                    break;
                }
            }

        }
    }

    public static void jobAttack(Job j) {
        if (j.getHp() > 0) {
            pl("");
            pl(j.getName() + "　の攻撃");
            pl("どのモンスターを攻撃しますか");
            j.attack(target());
        }
    }

    public static Monster target() {
        Monster ms;
        String mn = " ";
        for (int i = 0; i < monsterParty.size(); i++) {
            if (monsterParty.get(i).getHp() > 0) {
                mn += monsterParty.get(i).getEnemyNo();
                mn += ".";
                mn += monsterParty.get(i).getName();
                mn += "  ";
            }
        }
        mn += ">";
        int no;
        int targetNo = 0;
        for (;;) {
            if (!monsterLive()) {
                break;
            }
            no = insertNumber(mn);
            targetNo = no - 1;
            if (no > 0 && no <= monsterParty.size()) {
                if (monsterParty.get(targetNo).getHp() > 0) {
                    break;
                }
                pl("▽選択したモンスターは倒れています");
            }
        }

        ms = monsterParty.get(targetNo);
        return ms;
    }

    public static boolean jobLive() {
        boolean live = true;

        int count = 0;
        for (Job j : combatParty) {
            if (j.getHp() == 0) {
                count++;
            }
        }
        if (count == combatParty.size()) {
            live = false;
        }
        return live;//みんなが死んでたらFalse
    }

    public static boolean monsterLive() {
        boolean live = true;
        int count = 0;
        for (Monster m : monsterParty) {
            if (m.getHp() == 0) {
                count++;
            }
        }
        if (count == monsterParty.size()) {
            live = false;
        }
        return live;//みんなが死んでたらFalse
    }

    public static boolean monsterDeath() {
        boolean death = false;
        int count = 0;
        for (Monster m : monsterParty) {
            if (m.getHp() == 0) {
                count++;
            }
        }
        if (count > 0) {
            live = true;
        }
        return death;//一人でも死んでたらtrue
    }

    public static void full() { //全回復 HP & MP
        for (Job j : combatParty) {
            j.setHp(j.getMAX_HP());
            j.setMp(j.getMAX_MP());
        }
    }

    public static void monsterHpToString() { //モンスターリストとHPを表示
        String msg = "【敵】\r\n";
        for (Monster m : monsterParty) {
            if (m.getHp() != 0) {
                msg += m.getName();
                msg += " HP:";
                msg += m.getHp() + "/" + m.getMAX_HP();
                msg += "  ";
            }
        }
        pl(msg);
    }

    public static void playerDeathToString() {
        String msg;
        for (Job j : combatParty) {
            if (j.getHp() == 0) {
                pl("");
                p(combatParty.indexOf(j) + 1 + ":");
                p("【" + j.getJobName() + "】");
                pl(j.getName());
            }
        }
    }

    public static void playerHpToString() { //グループのメンバーリストとHPを表示
        pl("");
        String msg = "";
        msg += select_gName + "\r\n";
        for (Job j : combatParty) {
            if (j.getHp() != 0) {
                msg += j.getName() + "(Lv." + j.getLevel() + ")";
                msg += " HP:";
                msg += j.getHp() + "/" + j.getMAX_HP();
                msg += "  ";
            }
        }
        pl(msg);
    }

    public static void expset() {
        for (Job j : combatParty) {
            int getexp = ThreadLocalRandom.current().nextInt(10, 16) * monsterParty.size();
            pl(j.getName() + "は、" + getexp + "expを獲得した。");
            int exp_tmp = j.getExp() + getexp;
            if (exp_tmp < j.getmaxexp()) {
                j.setExp(exp_tmp);
                pl(j.getName() + ":EXP[ " + j.getExp() + "/" + j.getmaxexp() + " ]");
            } else {
                j.setExp(exp_tmp - j.getmaxexp());
                int lvup = j.getLevel() + 1;
                j.setLevel(lvup);
                j.setmaxexp(j.getmaxexp() + ThreadLocalRandom.current().nextInt(20, 31));
                pl("<" + j.getName() + ">");
                pl("*****LEVEL UP!*****");
                pl(j.getName() + "のレベルが" + j.getLevel() + "にアップしました。");
                pl(j.getLevel() - 1 + " → " + j.getLevel());
                pl(j.getName() + ":EXP[ " + j.getExp() + "/" + j.getmaxexp() + " ]");
                jobstup(j);
            }
        }
    }

    public static void jobstup(Job j) {
        pl("*****STATUS UP*****");
        int hptmp = j.getMAX_HP();
        int mptmp = j.getMAX_MP();
        int atktmp = j.getD_ATTACK();
        int deftmp = j.getD_DEFENCE();
        j.setAttack(j.getAttack() + 1);
        j.setDefence(j.getDefence() + 1);
        j.setHp(j.getHp() + 3);
        j.setMAX_HP(j.getMAX_HP() + 1);
        if (j.getJobName().equals("Hero")) {
            j.setAttack(j.getAttack() + 1);
            j.setDefence(j.getDefence() + 1);
            j.setMp(j.getMp() + 2);
            j.setMAX_MP(j.getMAX_MP() + 2);
        } else if (j.getJobName().equals("Wizard")) {
            j.setMp(j.getMp() + 4);
            j.setMAX_MP(j.getMAX_MP() + 4);
        } else if (j.getJobName().equals("Mage")) {
            j.setMp(j.getMp() + 4);
            j.setMAX_MP(j.getMAX_MP() + 4);
        } else if (j.getJobName().equals("Fighter")) {
            j.setAttack(j.getAttack() + 2);
        } else if (j.getJobName().equals("Knight")) {
            j.setAttack(j.getAttack() + 1);
            j.setDefence(j.getDefence() + 1);
            j.setHp(j.getHp() + 1);
            j.setMp(j.getMp() + 2);
            j.setMAX_HP(j.getMAX_HP() + 1);
            j.setMAX_MP(j.getMAX_MP() + 2);
        }
        j.setD_ATTACK(j.getAttack());
        j.setD_DEFENCE(j.getDefence());
        pl("HP:" + hptmp + "→" + j.getMAX_HP());
        pl("MP:" + mptmp + "→" + j.getMAX_MP());
        pl("ATK:" + atktmp + "→" + j.getD_ATTACK());
        pl("DEF:" + deftmp + "→" + j.getD_DEFENCE());
        pl("********************");
    }
}

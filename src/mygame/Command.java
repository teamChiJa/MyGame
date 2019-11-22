package mygame;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;
import static mygame.Combat.*;
import static mygame.Insert.*;
import static mygame.MemberManager.*;

public class Command {

    public static void p(String msg) {
        System.out.print(msg);
    }

    public static void pl(String msg) {
        System.out.println(msg);
    }

    public static void monstersAttack() {
        int jbran;
        boolean l;
        for (int i = 0; i < monsterParty.size(); i++) {
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
            pl(j.getName() + "　の攻撃");
            pl("どのモンスターを攻撃しますか");
            j.attack(target());
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
    public static void full(){ //全回復 HP & MP
        for(Job j:combatParty){
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

    public static void playerHpToString() { //グループのメンバーリストとHPを表示
        String msg = "";
        msg += select_gName + "\r\n";
        for (Job j : combatParty) {
            if (j.getHp() != 0) {
                msg += j.getName();
                msg += " HP:";
                msg += j.getHp() + "/" + j.getMAX_HP();
                msg += "  ";
            }
        }
        pl(msg);
    }
}

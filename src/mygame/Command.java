package mygame;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;
import static mygame.Combat.*;
import static mygame.Insert.*;

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

    public static void jobAttack() {
        System.out.println();
    }

    public static Monster target() {
        Monster ms;
        int targetNo;
        String mn = " ";
        for (int i = 0; i < monsterParty.size(); i++) {
            if (monsterParty.get(i).getHp() > 0) {
                mn += monsterParty.get(i).getEnemyNo();
                mn += ".";
                mn += monsterParty.get(i).getName();
            }
        }
        targetNo = insertNumber(mn) - 1;
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
}

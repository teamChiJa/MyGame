package mygame;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;
import static mygame.Combat.*;

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
                if( !live() ){
                    break;//みんなが死んでたら
                }
                if (combatParty.get(jbran).getHp() != 0) {
                     monsterParty.get(i).attack(combatParty.get(jbran));
                    break;
                }
            }
            
        }
    }

    public static boolean live() {
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
}

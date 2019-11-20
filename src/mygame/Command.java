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
        for (int i = 0; i < monsterParty.size(); i++) {
            int jbran = ThreadLocalRandom.current().nextInt(0, 3);
            monsterParty.get(i).attack(combatParty.get(jbran));
        }
    }
}

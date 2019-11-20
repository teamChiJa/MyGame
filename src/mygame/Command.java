package mygame;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;
import mygame.Combat.*;

public class Command {
    
    public static void p(String msg) {
        System.out.print(msg);
    }
    
    public static void pl(String msg) {
        System.out.println(msg);
    }
    
    public static void monstersAttack(ArrayList<Monster> alm, ArrayList<Job> alj) {
        for (int i = 0; i < alm.size(); i++) {
            int jbran = ThreadLocalRandom.current().nextInt(0, 3);
            alm.get(i).attack(alj.get(jbran));
        }
    }
}

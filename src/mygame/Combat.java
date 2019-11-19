/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;
import static mygame.Insert.*;

/**
 *
 * @author kbc19a21
 */
public class Combat {

    static ArrayList<Job> combatParty = new ArrayList<>();
    static ArrayList<Monster> monsterParty = new ArrayList<>();

    public static void combat() {
        monsterParty = respone();
    }

    public static ArrayList<Monster> respone() {
        int s = 1;
        int c = 1;
        int m = 1;
        ArrayList<Monster> enemy = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            int rd = ThreadLocalRandom.current().nextInt(1, 3);
            switch (rd) {
                case 1:
                    Slime slime = new Slime("スライム" + s);
                    enemy.add(slime);
                    s++;
                    break;
                case 2:
                    Chimera chimera = new Chimera("キメラ" + c);
                    enemy.add(chimera);
                    c++;
                    break;
                case 3:
                    Morimoto morimoto = new Morimoto("森本" + m);
                    enemy.add(morimoto);
                    m++;
                    break;
            }

        }
        return enemy;
    }
    public static void partySelect(ArrayList<Job> jp){
        combatParty = jp;
    }
}

package mygame;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;
import static mygame.Insert.*;
import static mygame.MemberManager.*;
import static mygame.Command.*;

public class Combat {

    static ArrayList<Job> combatParty = new ArrayList<>();
    static ArrayList<Monster> monsterParty = new ArrayList<>();

    public static void combat() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(
                System.in));
        System.out.println("このパーティーでゲームを開始します");
        partyToString(combatParty);
        System.out.println("ゲームを開始します");
        while (true) {
            reader.readLine();
            int rd = ThreadLocalRandom.current().nextInt(0, 2);
            if (rd == 0) {
                monsterParty = respone();
                int rdmsg = ThreadLocalRandom.current().nextInt(0, 2);
                if (monsterParty.size() == 1) {
                    if (rdmsg == 0) {
                        pl("モンスターが飛び出してきた！");
                    } else {
                        pl("モンスターがあらわれた！");
                    }
                } else {
                    if (rdmsg == 0) {
                        pl("モンスターの群れが飛び出してきた！");
                    } else {
                        pl("モンスターの群れがあらわれた！");
                    }
                }
                enemyToString(monsterParty);
            } else {
                pl("次に進む [ENTER]");
                reader.readLine();
            }
        }
    }

    public static ArrayList<Monster> respone() {
        int s = 1;
        int c = 1;
        int m = 1;
        ArrayList<Monster> enemy = new ArrayList<>();
        int rdRs = ThreadLocalRandom.current().nextInt(1, 4);
        for (int i = 0; i < rdRs; i++) {
            int rd = ThreadLocalRandom.current().nextInt(1, 4);
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

    public static void partySelect(ArrayList<Job> jp) {
        combatParty = jp;
    }

    public static void enemyToString(ArrayList<Monster> alm) {
        for (int i = 0; i < alm.size(); i++) {
            System.out.println("敵" + (i + 1) + " : " + alm.get(i).getName() + "  HP : " + alm.get(i).getHp());
        }
    }
}

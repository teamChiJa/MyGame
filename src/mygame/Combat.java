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
    static boolean live = true;
    public static void combat() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(
                System.in));
        System.out.println("このパーティーでゲームを開始します");
        partyToString(combatParty);
        System.out.print("ゲームを開始します [ENTER]>");
        reader.readLine();//エンター待ち
        EXIT:
        while (true) {
            int rd = ThreadLocalRandom.current().nextInt(0, 3);
            if (rd != 0) {
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
                QUIT:
                while (true) {
                    int ena = insertNumber("1.通常攻撃 2.逃げる>");
                    switch (ena) {
                        case 1:

                            break;
                        case 2:
                            int rdena = ThreadLocalRandom.current().nextInt(1, 5);
                            if (rdena == 3) {
                                p(select_gName + "はにげだした。しかし、まわりこまれてしまった。");
                                reader.readLine();
                                monstersAttack();
                                for(Job j:combatParty){
                                    if (j.getHp() == 0) {
                                        live = false;
                                    }
                                }
                                if(live == false){
                                    if (combatParty.size() == 1) {
                                       p(combatParty.get(0).getName() + "は しんでしまった！");
                                       reader.readLine();
                                    }else{
                                        p(combatParty.get(0).getName() + "たちは 全滅してしまった...");
                                        reader.readLine();
                                    }
                                    p("GAME OVER");
                                    reader.readLine();
                                    break EXIT;
                                }
                                break;
                            } else {
                                p("うまく逃げ切れた！");
                                reader.readLine();
                                break QUIT;
                            }
                        default:
                            System.out.println("1~2の中の数値を入力してください");
                            break;
                    }
                }
            } else {
                p("次に進む [ENTER]>");
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

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

    static boolean next = true;
    static ArrayList<Job> combatParty = new ArrayList<>();
    static ArrayList<Monster> monsterParty = new ArrayList<>();
    static boolean live = true;
    static int round = 1;

    public static void combat() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(
                System.in));
        System.out.println("このパーティーでゲームを開始します");
        partyToString(combatParty);
        System.out.print("ゲームを開始します \u001b[35m[ENTER]\u001b[37m>");
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
                pl("");
                pl("ラウンド【 " + round + " 】");
                enemyToString();
                QUIT:
                while (true) {
                    if (jobLive() == false) {
                        if (combatParty.size() == 1) {
                            p(combatParty.get(0).getName() + "は しんでしまった！ \u001b[35m[ENTER]\u001b[37m>");
                            reader.readLine();
                        } else {
                            p(combatParty.get(0).getName() + "たちは 全滅してしまった... \u001b[35m[ENTER]\u001b[37m>");
                            reader.readLine();
                        }
                        full();
                        p("GAME OVER [ENTER]>");
                        reader.readLine();
                        break EXIT;
                    }
                    if (monsterLive() == false) {
                        if (combatParty.size() == 1) {
                            p(combatParty.get(0).getName() + "は　戦闘に勝利した！\u001b[35m[ENTER]\u001b[37m>");
                            reader.readLine();
                        } else {
                            p(combatParty.get(0).getName() + "たちは　戦闘に勝利した！\u001b[35m[ENTER]\u001b[37m>");
                            reader.readLine();
                        }
                        round++;
                        break QUIT;
                    }
                    for (int i = 0; i < combatParty.size();) {
                        Job j = combatParty.get(i);
                        if (j.getHp() != 0) {
                            monsterHpToString();
                            playerHpToString();
                            pl("【" + j.getJobName() + "】 " + j.getName() + "の攻撃");
                            pl("HP : " + j.getHp() + "/" + j.getMAX_HP() + " MP : " + j.getMp() + "/" + j.getMAX_MP());
                            int ena = insertNumber("1.こうげき 2.とくぎ 3.じゅもん 4.にげる >");
                            switch (ena) {
                                case 1:
                                    jobAttack(combatParty.get(i));
                                    i++;
                                    if (jobLive() == false) {
                                        if (combatParty.size() == 1) {
                                            p(combatParty.get(0).getName() + "は しんでしまった！ \u001b[35m[ENTER]\u001b[37m>");
                                            reader.readLine();
                                        } else {
                                            p(combatParty.get(0).getName() + "たちは 全滅してしまった... \u001b[35m[ENTER]\u001b[37m>");
                                            reader.readLine();
                                        }
                                        full();
                                        p("GAME OVER [ENTER]>");
                                        reader.readLine();
                                        break EXIT;
                                    }
                                    if (monsterLive() == false) {
                                        if (combatParty.size() == 1) {
                                            p(combatParty.get(0).getName() + "は　戦闘に勝利した！\u001b[35m[ENTER]\u001b[37m>");
                                            reader.readLine();
                                        } else {
                                            p(combatParty.get(0).getName() + "たちは　戦闘に勝利した！\u001b[35m[ENTER]\u001b[37m>");
                                            reader.readLine();
                                        }
                                        combatFinish();
                                        round++;
                                        expset();
                                        break QUIT;
                                    }
                                    break;
                                case 2:
                                    if (combatParty.get(i).isSpMoveList() == false) {
                                        p(combatParty.get(i).getName() + "には とくぎがありません！ \u001b[35m[ENTER]\u001b[37m>");
                                        reader.readLine();
                                        break;
                                    } else {
                                        combatParty.get(i).specialToString();
                                        if (!next) {
                                            continue;
                                        }
                                        i++;
                                        if (jobLive() == false) {
                                            if (combatParty.size() == 1) {
                                                p("\u001b[31m" +combatParty.get(0).getName() + "は しんでしまった！ \u001b[35m[ENTER]\u001b[37m>");
                                                reader.readLine();
                                            } else {
                                                p("\u001b[31m" +combatParty.get(0).getName() + "たちは 全滅してしまった... \u001b[35m[ENTER]\u001b[37m>");
                                                reader.readLine();
                                            }
                                            full();
                                            p("GAME OVER [ENTER]>");
                                            reader.readLine();
                                            break EXIT;
                                        }
                                        if (monsterLive() == false) {
                                            if (combatParty.size() == 1) {
                                                p(combatParty.get(0).getName() + "は　戦闘に勝利した！\u001b[35m[ENTER]\u001b[37m>");
                                                reader.readLine();
                                            } else {
                                                p(combatParty.get(0).getName() + "たちは　戦闘に勝利した！\u001b[35m[ENTER]\u001b[37m>");
                                                reader.readLine();
                                            }
                                            combatFinish();
                                            round++;
                                            expset();
                                            break QUIT;
                                        }
                                        break;
                                    }
                                case 3:
                                    if (combatParty.get(i).isMagicList() == false) {
                                        p(combatParty.get(i).getName() + "には じゅもんはありません！ \u001b[35m[ENTER]\u001b[37m>");
                                        reader.readLine();
                                        break;
                                    } else {
                                        combatParty.get(i).magicToString();
                                        if (!next) {
                                            continue;
                                        }
                                        i++;
                                        if (jobLive() == false) {
                                            if (combatParty.size() == 1) {
                                                p("\u001b[31m" +combatParty.get(0).getName() + "は しんでしまった！ \u001b[35m[ENTER]\u001b[37m>");
                                                reader.readLine();
                                            } else {
                                                p("\u001b[31m" +combatParty.get(0).getName() + "たちは 全滅してしまった... \u001b[35m[ENTER]\u001b[37m>");
                                                reader.readLine();
                                            }
                                            full();
                                            p("GAME OVER [ENTER]>");
                                            reader.readLine();
                                            break EXIT;
                                        }
                                        if (monsterLive() == false) {
                                            if (combatParty.size() == 1) {
                                                p(combatParty.get(0).getName() + "は　戦闘に勝利した！\u001b[35m[ENTER]\u001b[37m>");
                                                reader.readLine();
                                            } else {
                                                p(combatParty.get(0).getName() + "たちは　戦闘に勝利した！\u001b[35m[ENTER]\u001b[37m>");
                                                reader.readLine();
                                            }
                                            combatFinish();
                                            expset();
                                            round++;
                                            break QUIT;
                                        }
                                        break;
                                    }
                                case 4:
                                    int rdena = ThreadLocalRandom.current().nextInt(1, 5);
                                    if (rdena == 3) {
                                        if (combatParty.size() == 1) {
                                            p("\u001b[31m" + combatParty.get(0).getName() + "はにげだした。しかし、まわりこまれてしまった。\u001b[35m[ENTER]\u001b[37m>");
                                            reader.readLine();
                                        } else {
                                            p("\u001b[31m" + combatParty.get(0).getName() + "たちはにげだした。しかし、まわりこまれてしまった。\u001b[35m[ENTER]\u001b[37m>");
                                            reader.readLine();
                                        }
                                        if (jobLive() == false) {
                                            if (combatParty.size() == 1) {
                                                p("\u001b[31m" +combatParty.get(0).getName() + "は しんでしまった！ \u001b[35m[ENTER]\u001b[37m>");
                                                reader.readLine();
                                            } else {
                                                p("\u001b[31m" +combatParty.get(0).getName() + "たちは 全滅してしまった... \u001b[35m[ENTER]\u001b[37m>");
                                                reader.readLine();
                                            }
                                            full();
                                            p("GAME OVER [ENTER]>");
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
                                    pl("");
                                    System.out.println("\u001b[31m※1~4の中の数値を入力してください\u001b[31m※");
                                    pl("");
                                    break;
                            }
                        } else {
                            i++;
                        }
                    }
                    monstersAttack();
                }
                while (true) {
                    p("次に進む [\u001b[35mENTER \u001b[37mor \u001b[36m!h(help)\u001b[37m]>");
                    String q = reader.readLine();
                    if (q.equals("!q")) {
                        save();
                        pl("終了します");
                        System.exit(0);
                    } else if (q.equalsIgnoreCase("!help") || q.equalsIgnoreCase("!h")) {
                        pl("\u001b[32m---help---");
                        pl("\u001b[36m!p - 保存");
                        pl("\u001b[36m!q - 強制終了");
                        pl("\u001b[32m----------\u001b[37m]");
                    } else if (q.equalsIgnoreCase("!p")) {
                        save();
                    } else {
                        break;
                    }
                }
            } else {
                while (true) {
                    p("次に進む [\u001b[35mENTER \u001b[37mor \u001b[36m!h(help)\u001b[37m]>");
                    String q = reader.readLine();
                    if (q.equals("!q")) {
                        save();
                        pl("終了します");
                        System.exit(0);
                    } else if (q.equalsIgnoreCase("!help") || q.equalsIgnoreCase("!h")) {
                        pl("\u001b[32m---help---");
                        pl("\u001b[36m!p - 保存");
                        pl("\u001b[36m!q - 強制終了");
                        pl("\u001b[32m----------\u001b[37m]");
                    } else if (q.equalsIgnoreCase("!p")) {
                        save();
                    } else {
                        break;
                    }
                }
            }
        }
    }

    public static ArrayList<Monster> respone() {
        int s = 1;
        int c = 1;
        int m = 1;
        ArrayList<Monster> enemy = new ArrayList<>();
        if (round % 10 == 0) {
            Kajita kajita = new Kajita();
            enemy.add(kajita);
            kajita.setEnemyNo(kajita.getEnemyNo() + enemy.size());
            int rdRs = ThreadLocalRandom.current().nextInt(1, 3);
            for (int i = 0; i < rdRs; i++) {
                int rd = ThreadLocalRandom.current().nextInt(1, 11);
                switch (rd) {
                    case 1:
                    case 4:
                    case 8:
                    case 9:
                        Slime slime = new Slime("スライム" + s);
                        enemy.add(slime);
                        s++;
                        slime.setEnemyNo(slime.getEnemyNo() + enemy.size());
                        break;
                    case 2:
                    case 5:
                    case 7:
                    case 10:
                        Chimera chimera = new Chimera("キメラ" + c);
                        enemy.add(chimera);
                        c++;
                        chimera.setEnemyNo(chimera.getEnemyNo() + enemy.size());
                        break;
                    case 6:
                    case 3:
                        Morimoto morimoto = new Morimoto("森本" + m);
                        enemy.add(morimoto);
                        m++;
                        morimoto.setEnemyNo(morimoto.getEnemyNo() + enemy.size());
                        break;
                }
            }
        } else {
            int rdRs = ThreadLocalRandom.current().nextInt(1, 4);
            for (int i = 0; i < rdRs; i++) {
                int rd = ThreadLocalRandom.current().nextInt(1, 11);
                switch (rd) {
                    case 1:
                    case 4:
                    case 8:
                    case 9:
                        Slime slime = new Slime("スライム" + s);
                        enemy.add(slime);
                        s++;
                        slime.setEnemyNo(slime.getEnemyNo() + enemy.size());
                        break;
                    case 2:
                    case 5:
                    case 7:
                    case 10:
                        Chimera chimera = new Chimera("キメラ" + c);
                        enemy.add(chimera);
                        c++;
                        chimera.setEnemyNo(chimera.getEnemyNo() + enemy.size());
                        break;
                    case 3:
                    case 6:
                        Morimoto morimoto = new Morimoto("森本" + m);
                        enemy.add(morimoto);
                        m++;
                        morimoto.setEnemyNo(morimoto.getEnemyNo() + enemy.size());
                        break;
                }
            }
        }
        return enemy;
    }

    public static void partySelect(ArrayList<Job> jp) {
        combatParty = jp;
    }

    public static void enemyToString() {
        for (int i = 0; i < monsterParty.size(); i++) {
            System.out.println(monsterParty.get(i).getEnemyNo() + " : " + monsterParty.get(i).getName() + "  HP : " + monsterParty.get(i).getHp());
        }
    }

    public static void combatFinish() {
        for (int i = 0; i < combatParty.size(); i++) {
            Job j = combatParty.get(i);
            j.setHp(j.getHp() + 10);
            if (j.getHp() > j.getMAX_HP()) {
                j.setHp(j.getMAX_HP());
            }
            j.setMp(j.getMp() + 5);
            if (j.getMp() > j.getMAX_MP()) {
                j.setMp(j.getMAX_MP());
            }
            j.setAttack(j.getD_DEFENCE());
            j.setDefence(j.getD_DEFENCE());
        }
    }
}

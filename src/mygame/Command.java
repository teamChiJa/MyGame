package mygame;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;
import static mygame.Combat.*;
import static mygame.Insert.*;
import static mygame.MemberManager.*;

public class Command {

    static ArrayList<Job> tmp_party = new ArrayList();
    static String GName_tmp = "";
    static String Job_tmp = "";
    static String name = "";
    static int HP = 0;
    static int MP = 0;
    static int MAXHP = 0;
    static int MAXMP = 0;
    static int ATK = 0;
    static int DEF = 0;
    static int MAXATK = 0;
    static int MAXDEF = 0;
    static int LEVEL = 0;
    static int EXP = 0;
    static int MAXEXP = 0;

    public static void p(Object msg) {
        System.out.print(msg);
    }

    public static void pl(Object msg) {
        System.out.println(msg);
    }

    public static void read() {
        try {
            // ファイルのパスを指定してオブジェクトを生成。
            File file = new File("c:\\work\\SAVEDATA.csv");
            if (checkBeforeReadfile(file)) {
                // 入力ストリームを生成。（ FileNotFoundException が発生 ）
                FileInputStream input = new FileInputStream(file);
                /* 入力ストリームの読み込み。 （ UnsupportedEncodingException が発生 ）
             * ここでCSVファイルの文字コードを設定しないと文字化けします。 */
                // 読み込むファイルの文字コード(SJIS)
                InputStreamReader stream = new InputStreamReader(input, "SJIS");
                // バッファに取り込み。
                BufferedReader buffer = new BufferedReader(stream);

                String line;
                line = buffer.readLine();
                /* readLine()でバッファの１行を取り出す作業を、読み込める行が無くなるまでwhile文で実行。
                * line = buffer.readline() でBufferedReaderが保持する一行を取出しているので、ループする毎に書き変わります。 */
                boolean flag = false;
                while ((line = buffer.readLine()) != null) {
                    // 取出した１行の文字セットを変換して新たに文字列を生成。
                    byte[] b = line.getBytes();
                    // String で UnsupportedEncodingException が発生 (変換したい文字コード:UTF-8)
                    line = new String(b, "UTF-8");
                    // 文字列をカンマ区切りで配列に分けて要素ごとに出力。
                    // 16行目、line.splitの第２引数に"-１"を指定しないと、" 3,test, " の行の配列は " 3,test " の２つになってしまい他の行と要素数が
                    // 違うため、出力結果の様にはなりません。
                    String[] columns = line.split(",", -1);
                    for (int j = 0; j < columns.length; j++) {
                        if (flag == false) {

                            GName_tmp = columns[0];
                            GName_tmp = GName_tmp.replaceAll("\"", "");
                            flag = true;
                        }
                        switch (j) {
                            case 0:
                                if (GName_tmp.equals(columns[j].replaceAll("\"", ""))) {
                                } else {
                                    hmmPut(GName_tmp, tmp_party.get(0), tmp_party.get(1), tmp_party.get(2));
                                    GName_tmp = columns[j];
                                    GName_tmp = GName_tmp.replaceAll("\"", "");
                                }
                                break;
                            case 1:
                                Job_tmp = columns[j];
                                Job_tmp = Job_tmp.replaceAll("\"", "");
                                break;
                            case 2:
                                name = columns[j];
                                name = name.replaceAll("\"", "");
                                break;
                            case 3:
                                HP = Integer.parseInt(columns[j]);
                                break;
                            case 4:
                                MP = Integer.parseInt(columns[j]);
                                break;
                            case 5:
                                MAXHP = Integer.parseInt(columns[j]);
                                break;
                            case 6:
                                MAXMP = Integer.parseInt(columns[j]);
                                break;
                            case 7:
                                ATK = Integer.parseInt(columns[j]);
                                break;
                            case 8:
                                DEF = Integer.parseInt(columns[j]);
                                break;
                            case 9:
                                MAXATK = Integer.parseInt(columns[j]);
                                break;
                            case 10:
                                MAXDEF = Integer.parseInt(columns[j]);
                            case 11:
                                LEVEL = Integer.parseInt(columns[j]);
                            case 12:
                                EXP = Integer.parseInt(columns[j]);
                            case 13:
                                MAXEXP = Integer.parseInt(columns[j]);
                                if (Job_tmp.equals("Hero")) {
                                    Hero h = new Hero(name, HP, MAXHP, MP, MAXMP, ATK, DEF, MAXATK, MAXDEF, LEVEL, EXP, MAXEXP);
                                    tmp_party.add(h);
                                } else if (Job_tmp.equals("Wizard")) {
                                    Wizard w = new Wizard(name, HP, MAXHP, MP, MAXMP, ATK, DEF, MAXATK, MAXDEF, LEVEL, EXP, MAXEXP);
                                    tmp_party.add(w);
                                } else if (Job_tmp.equals("Mage")) {
                                    Mage m = new Mage(name, HP, MAXHP, MP, MAXMP, ATK, DEF, MAXATK, MAXDEF, LEVEL, EXP, MAXEXP);
                                    tmp_party.add(m);
                                } else if (Job_tmp.equals("Fighter")) {
                                    Fighter f = new Fighter(name, HP, MAXHP, MP, MAXMP, ATK, DEF, MAXATK, MAXDEF, LEVEL, EXP, MAXEXP);
                                    tmp_party.add(f);
                                } else if (Job_tmp.equals("Knight")) {
                                    Knight k = new Knight(name, HP, MAXHP, MP, MAXMP, ATK, DEF, MAXATK, MAXDEF, LEVEL, EXP, MAXEXP);
                                    tmp_party.add(k);
                                }
                                break;
                        }
                    }
                }
                pl("セーブデータファイルの読み込みが完了しました。");
                hmmPut(GName_tmp, tmp_party.get(0), tmp_party.get(1), tmp_party.get(2));
                // 開いたストリームとバッファを閉じて関連するシステム・リソースを解放します。 （ IOException が発生 ）
                input.close();
                stream.close();
                buffer.close();
            } else {
                pl("※ファイルが存在しないか、ファイルが開けません");
                pl("データファイルを新規作成します");
            }
        } catch (UnsupportedEncodingException | FileNotFoundException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();

        }

    }

    public static void save() {
        try {
            // 出力ファイルの作成
            File f = new File("c:\\work\\SAVEDATA.csv");
            PrintWriter p = new PrintWriter(new BufferedWriter(new OutputStreamWriter(new FileOutputStream(f), "Shift_JIS")));
            // ヘッダーを指定する
            p.print("GROUP");
            p.print(",");
            p.print("JOB");
            p.print(",");
            p.print("NAME");
            p.print(",");
            p.print("HP");
            p.print(",");
            p.print("MP");
            p.print(",");
            p.print("ATTACK");
            p.print(",");
            p.print("DEFENCE");
            p.print(",");
            p.print("MAX_HP");
            p.print(",");
            p.print("MAX_MP");
            p.print(",");
            p.print("MAX_ATTACK");
            p.print(",");
            p.print("MAX_DEFENCE");
            p.print(",");
            p.print("LEVEL");
            p.print(",");
            p.print("EXP");
            p.print(",");
            p.print("MAXEXP");
            p.println();
            // 内容をセットする
            for (String group : hmm.keySet()) {
                for (int i = 0; i < hmm.get(group).size(); i++) {
                    p.print("\"" + group + "\"");
                    p.print(",");
                    p.print("\"" + hmm.get(group).get(i).getJobName() + "\"");
                    p.print(",");
                    p.print("\"" + hmm.get(group).get(i).getName() + "\"");
                    p.print(",");
                    p.print(hmm.get(group).get(i).getHp());
                    p.print(",");
                    p.print(hmm.get(group).get(i).getMp());
                    p.print(",");
                    p.print(hmm.get(group).get(i).getAttack());
                    p.print(",");
                    p.print(hmm.get(group).get(i).getDefence());
                    p.print(",");
                    p.print(hmm.get(group).get(i).getMAX_HP());
                    p.print(",");
                    p.print(hmm.get(group).get(i).getMAX_MP());
                    p.print(",");
                    p.print(hmm.get(group).get(i).getD_ATTACK());
                    p.print(",");
                    p.print(hmm.get(group).get(i).getD_DEFENCE());
                    p.print(",");
                    p.print(hmm.get(group).get(i).getLevel());
                    p.print(",");
                    p.print(hmm.get(group).get(i).getExp());
                    p.print(",");
                    p.print(hmm.get(group).get(i).getmaxexp());
                    p.println();// 改行
                }
            }
            // ファイルに書き出し閉じる
            p.close();

            System.out.println("セーブデータを保存しました。");

        } catch (IOException ex) {
            ex.printStackTrace();
        }

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

    private static boolean checkBeforeReadfile(File file) {
        if (file.exists()) {
            if (file.isFile() && file.canRead()) {
                return true;
            }
        }
        return false;
    }
}

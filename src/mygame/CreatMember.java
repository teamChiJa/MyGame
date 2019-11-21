package mygame;

import java.util.ArrayList;
import static mygame.Insert.*;
import static mygame.MemberManager.*;
import java.util.concurrent.ThreadLocalRandom;
import static mygame.Combat.*;

public class CreatMember {

    static ArrayList<Job> party = new ArrayList();

    public static void creat() {
        String yandn;
        String gName;
        System.out.print("グループ名を入力してください >");
        gName = "【" + insert() + "】";
        for (;;) {
            System.out.println("一人目のJobを選択してください");
            selectJob();
            System.out.println("パーティーを作成を終了しますか？");
            yandn = foolProof();
            if (yandn.equalsIgnoreCase("y")) {
                hmmPut(gName, party.get(0));
                party.clear();
                break;
            }
            System.out.println("二人目のJobを選択してください");
            selectJob();
            System.out.println("パーティーを作成を終了しますか？");
            yandn = foolProof();
            if (yandn.equalsIgnoreCase("y")) {
                hmmPut(gName, party.get(0), party.get(1));
                party.clear();
                break;
            }
            System.out.println("三人目のJobを選択してください");
            selectJob();
            System.out.println("パーティー作成を終了します");
            hmmPut(gName, party.get(0), party.get(1), party.get(2));
            party.clear();
            break;
        }
        hmmToString();
        partySelect(hmm.get(gName));
        select_gName = gName;

    }

    public static void selectJob() {
        BACK:
        while (true) {
            int tmp = insertNumber("1.Hero 2.Fighter 3.Wizard 4.Mage 5.Knight >");
            String name;
            switch (tmp) {
                case 0:
                    System.out.println("パーティー作成を終了します");
                    break;
                case 1:
                    System.out.print("名前を入力してください >");
                    name = insert();
                    Hero h = new Hero(name);
                    party.add(h);
                    break BACK;
                case 2:
                    System.out.print("名前を入力してください >");
                    name = insert();
                    Fighter f = new Fighter(name);
                    party.add(f);
                    break BACK;
                case 3:
                    System.out.print("名前を入力してください >");
                    name = insert();
                    Wizard w = new Wizard(name);
                    party.add(w);
                    break BACK;
                case 4:
                    System.out.print("名前を入力してください >");
                    name = insert();                 
                    Mage m = new Mage(name);
                    party.add(m);
                    break BACK;
                case 5:
                    System.out.print("名前を入力してください >");
                    name = insert();
                    Knight k = new Knight(name);
                    party.add(k);
                    break BACK;
                default:
                    System.out.println("1~5の中の数値を入力してください");
                    break;
            }
        }
    }
}

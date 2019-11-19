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
        System.out.print("グループ名を入力してください>");
        gName = insert();
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
        combatParty = hmm.get(gName);
        
    }

    public static void selectJob() {
        BACK:
        while (true) {
            int tmp = insertNumber("1.Hero 2.Fighter 3.Wizard 4.Mage 5.Knight >");
            String name;
            int i1;
            int i2;
            switch (tmp) {
                case 0:
                    System.out.println("パーティー作成を終了します");
                    break;
                case 1:
                    System.out.print("名前を入力してください>");
                    name = insert();
                    i1 = ThreadLocalRandom.current().nextInt(30, 40);
                    i2 = ThreadLocalRandom.current().nextInt(10, 20);
                    Hero h = new Hero(name, i1, i2);
                    party.add(h);
                    break BACK;
                case 2:
                    System.out.print("名前を入力してください>");
                    name = insert();
                    i1 = ThreadLocalRandom.current().nextInt(30, 40);
                    i2 = ThreadLocalRandom.current().nextInt(40, 50);
                    Fighter f = new Fighter(name, i1, i2);
                    party.add(f);
                    break BACK;
                case 3:
                    System.out.print("名前を入力してください>");
                    name = insert();
                    i1 = ThreadLocalRandom.current().nextInt(20, 30);
                    i2 = ThreadLocalRandom.current().nextInt(20, 30);
                    Wizard w = new Wizard(name, i1, i2);
                    party.add(w);
                    break BACK;
                case 4:
                    System.out.print("名前を入力してください>");
                    name = insert();
                    i1 = ThreadLocalRandom.current().nextInt(20, 30);
                    i2 = ThreadLocalRandom.current().nextInt(30, 40);
                    Mage m = new Mage(name, i1, i2);
                    party.add(m);
                    break BACK;
                case 5:
                    System.out.print("名前を入力してください>");
                    name = insert();
                    i1 = ThreadLocalRandom.current().nextInt(35, 45);
                    i2 = ThreadLocalRandom.current().nextInt(5, 15);
                    Knight k = new Knight(name, i1, i2);
                    party.add(k);
                    break;
                default:
                    System.out.println("0~5の中の数値を入力してください");
                    break;
            }
        }
    }
}

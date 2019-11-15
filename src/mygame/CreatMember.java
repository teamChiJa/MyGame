package mygame;

import java.util.ArrayList;
import static mygame.Insert.*;
import static mygame.MemberManager.*;
import java.util.concurrent.ThreadLocalRandom;

public class CreatMember {//

    static ArrayList<Job> party = new ArrayList();

    public static void creat() {
        System.out.println("一人目のJobを選択してください");
        selectJob();
        System.out.println("二人目のJobを選択してください");
        selectJob();//
        System.out.println("三人目のJobを選択してください");
        selectJob();
    }

    public static void selectJob() {
        System.out.print("1.Hero 2.Fighter 3.Wizard 4.Mage 5.Knight >");
        int tmp = insertNumber();
        String name;
        int i1;
        int i2;
        switch (tmp) {
            case 1:
                System.out.print("名前を入力してください>");
                name = insert();
                i1 = ThreadLocalRandom.current().nextInt(30, 40);
                i2 = ThreadLocalRandom.current().nextInt(10, 20);
                Hero h = new Hero(name, i1, i2);
                party.add(h);
                break;
            case 2:
                System.out.print("名前を入力してください>");
                name = insert();
                i1 = ThreadLocalRandom.current().nextInt(30, 40);
                i2 = ThreadLocalRandom.current().nextInt(40, 50);
                Fighter f = new Fighter(name, i1, i2);
                party.add(f);
                break;
            case 3:
                System.out.print("名前を入力してください>");
                name = insert();
                i1 = ThreadLocalRandom.current().nextInt(20, 30);
                i2 = ThreadLocalRandom.current().nextInt(20, 30);
                Wizard w = new Wizard(name, i1, i2);
                party.add(w);
                break;
            case 4:
                System.out.print("名前を入力してください>");
                name = insert();
                i1 = ThreadLocalRandom.current().nextInt(20, 30);
                i2 = ThreadLocalRandom.current().nextInt(30, 40);
                Mage m = new Mage(name, i1, i2);
                party.add(m);
                break;
            case 5:
                System.out.print("名前を入力してください>");
                name = insert();
                i1 = ThreadLocalRandom.current().nextInt(35, 45);
                i2 = ThreadLocalRandom.current().nextInt(5, 15);
                Knight k = new Knight(name, i1, i2);
                party.add(k);
                break;
        }
    }
}

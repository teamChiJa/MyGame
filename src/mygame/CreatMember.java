package mygame;

import java.util.ArrayList;
import static mygame.Insert.*;
import static mygame.MemberManager.*;

public class CreatMember {//

    static ArrayList<Job> party = new ArrayList();

    public static void creat() {
        System.out.println("一人目のJobを選択してください");
        selectJob();
    }

    public static void selectJob() {
        System.out.print("1.Hero 2.Fighter 3.Wizard 4.Mage 5.Knight >");
    }
}

package mygame;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import static mygame.CreatMember.*;

public class MemberManager {

    static Map<String, ArrayList<Job>> hmm = new HashMap<>();
    static ArrayList<String> groupNameList = new ArrayList<>();
    static String select_gName;

    public static void hmmPut(String groupName, Job job1, Job job2, Job job3) {
        hmm.computeIfAbsent(groupName, k -> new ArrayList<>()).add(job1);
        hmm.computeIfAbsent(groupName, k -> new ArrayList<>()).add(job2);
        hmm.computeIfAbsent(groupName, k -> new ArrayList<>()).add(job3);
        hmm.put(groupName, hmm.get(groupName));
        groupNameList.add(groupName);
        System.out.println("【" + groupName + "】グループをセーブデータに追加しました");
    }

    public static void hmmPut(String groupName, Job job1, Job job2) {
        hmm.computeIfAbsent(groupName, k -> new ArrayList<>()).add(job1);
        hmm.computeIfAbsent(groupName, k -> new ArrayList<>()).add(job2);
        hmm.put(groupName, hmm.get(groupName));
        groupNameList.add(groupName);
        System.out.println("【" + groupName + "】グループをセーブデータに追加しました");
    }

    public static void hmmPut(String groupName, Job job1) {
        hmm.computeIfAbsent(groupName, k -> new ArrayList<>()).add(job1);
        hmm.put(groupName, hmm.get(groupName));
        groupNameList.add(groupName);
        System.out.println("【" + groupName + "】グループをセーブデータに追加しました");
    }

    public static void hmmToString() {
        System.out.println();
        for (String group : hmm.keySet()) {
            System.out.println("グループ名 : " + group);
            for (int i = 0; i < hmm.get(group).size(); i++) {
                System.out.println("    勇者の名前 : " + hmm.get(group).get(i).getName() + " , " + "ジョブ名 : " + hmm.get(group).get(i).getJobName());
            }

        }
    }

    public static void partyToString(ArrayList<Job> alj) {
        System.out.println(select_gName);
        for (int i = 0; i < alj.size(); i++) {
            System.out.println("    勇者の名前 : " + alj.get(i).getName() + " , " + "ジョブ名 : " + alj.get(i).getJobName());
        }

    }

    public static ArrayList<Job> groupGet(int no) {
        ArrayList<Job> j = hmm.get(groupNameList.get(no - 1));
        return j;
    }

    public static String groupNameToString() {
        String gnm = 1 + ":" + groupNameList.get(0);
        for (int k = 1; k < groupNameList.size(); k++) {
            gnm += "\r\n" + (k + 1) + ":" + groupNameList.get(k);
        }
        gnm += "\r\n" + "グループを選択してください>";
        return gnm;
    }
}

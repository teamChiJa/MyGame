package mygame;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import static mygame.CreatMember.*;

public class MemberManager {
    
    static Map<String, ArrayList<Job>> hmm = new HashMap<>();
    static ArrayList<String> groupNameList = new ArrayList<>();
    static ArrayList<ArrayList<Job>> parties = new ArrayList<>();
    
    public static void hmmPut(String groupName, ArrayList<Job> party) {
        
        parties.get(parties.size()).add(party.get(0));
        if (party.size() > 1) {
            parties.get(parties.size()).add(party.get(1));
        }
        if (party.size() > 2) {
            parties.get(parties.size()).add(party.get(2));
        }
        hmm.put(groupName, parties.get(parties.size()));
        groupNameList.add(groupName);
        System.out.println("【" + groupName + "】グループをセーブデータに保存しました");//
    }
    
    public static void hmmPut(String groupName, Job job1, Job job2) {
        hmm.computeIfAbsent(groupName, k -> new ArrayList<>()).add(job1);
        hmm.computeIfAbsent(groupName, k -> new ArrayList<>()).add(job2);
        hmm.put(groupName, hmm.get(groupName));
        groupNameList.add(groupName);
        System.out.println("【" + groupName + "】グループをセーブデータに保存しました");
    }
    
    public static void hmmPut(String groupName, Job job1) {
        hmm.computeIfAbsent(groupName, k -> new ArrayList<>()).add(job1);
        hmm.put(groupName, hmm.get(groupName));
        groupNameList.add(groupName);
        System.out.println("【" + groupName + "】グループをセーブデータに保存しました");
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
    
    public static ArrayList<Job> groupGet(int no) {
        ArrayList<Job> j = hmm.get(groupNameList.get(no - 1));
        return j;
    }
    
    public static String groupNameToString() {
        String gnm = 1 + ":" + groupNameList.get(0);
        for (int k = 1; k < groupNameList.size(); k++) {
            gnm += "\r\n" + (k + 1) + ":" + groupNameList.get(k);
        }
        return gnm;
    }
}

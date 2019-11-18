package mygame;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import static mygame.CreatMember.*;

public class MemberManager {

    static Map<String, ArrayList<Job>> hmm = new HashMap<>();
    static ArrayList<String> groupNameList = new ArrayList<>();
    CreatMember cm = new CreatMember();

    public static void hmmPut(String groupName) {
        hmm.put(groupName, party);
        groupNameList.add(groupName);
        System.out.println("【" + groupName + "】グループをセーブデータに保存しました");
    }

    public static void hmmToString() {
        System.out.println();
        for (String group : hmm.keySet()) {
            System.out.println("グループ名 : " + group);
            for (int i = 0; i < party.size(); i++) {
                System.out.println("    勇者の名前 : " + party.get(i).getName() + " , " + "ジョブ名 : " + party.get(i).getJobName());
            }

        }
    }

    public static ArrayList<Job> groupGet(int no) {
        ArrayList<Job> j = hmm.get(groupNameList.get(no - 1));
        return j;
    }
    
    public static String groupNameToString(){
        String gnm = 1 + ":" + groupNameList.get(0) ;
        for(int k =1; k<groupNameList.size() ; k++){
            gnm += "\r\n"+(k+1) + ":" + groupNameList.get(k);
        }
       return gnm; 
    }
}

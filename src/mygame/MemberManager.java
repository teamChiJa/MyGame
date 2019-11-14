package mygame;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MemberManager {

    static Map<String, ArrayList<Job>> hmm = new HashMap<>();
    CreatMember cm = new CreatMember();

    public void hmmPut(String groupName, ArrayList<Job> al) {
        hmm.put(groupName, al);
        System.out.println(groupName + "　グループをセーブしました");
    }

    public void hmmToString() {
        System.out.println();
        for(String group : hmm.keySet()){
            System.out.println(  "グループ名 : " + group);
            
        }
    }
}

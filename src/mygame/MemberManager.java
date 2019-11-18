package mygame;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import static mygame.CreatMember.*;

public class MemberManager {

    static Map<String, ArrayList<Job>> hmm = new HashMap<>();
    CreatMember cm = new CreatMember();

    public static void hmmPut(String groupName) {
        hmm.put(groupName,party );
        System.out.println( "【" + groupName + "】グループをセーブデータに保存しました");
    }

    public static void hmmToString() {
        System.out.println();
        for(String group : hmm.keySet()){
            System.out.println(  "グループ名 : " + group);
            for(int i=0; i<party.size();i++){
                System.out.println("    勇者の名前 : " + party.get(i).getName() + " , " + "ジョブ名 : " + party.get(i).getJobName());
            }
            
        }
    }
}

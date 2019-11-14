
package mygame;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MemberManager {
    Map<String,ArrayList<Job>> hmm = new HashMap<>();
    
    public void hmmPut(String groupName,ArrayList<Job> al){
        hmm.put(groupName, al);
        System.out.println(groupName + "　グループをセーブしました");
    }
    
    public void hmmToString(){
        
    }
}

package mygame;

import static mygame.CreatMember.*;
import static mygame.Insert.*;
import static mygame.MemberManager.*;
import static mygame.Combat.*;

public class PlayGame {

    public static void game() {
        //hiromu();
        int partyNo;
        System.out.println("パーティー作成を開始します");
        String msg = "既存のデータを使いますか？";

        System.out.println(msg);
        String yn = foolProof();
        for (;;) {
            if (yn.equalsIgnoreCase("y")) {
                if (hmm.size() == 0) {
                    System.out.println("セーブデータが存在しません");
                    System.out.println("新規セーブデータを構築します");
                    yn = "n";
                } else {
                    for (;;) {
                        partyNo = insertNumber(groupNameToString());
                        if (partyNo > 0 && partyNo <= groupNameList.size()) {
                            partySelect(groupGet(partyNo));
                            select_gName = groupNameList.get(partyNo-1);
                            break;
                        }
                        System.out.println("▽入力エラー▽");
                        System.out.println();
                    }
                    break;
                }

            } else {
                creat();
                break;
            }
            
        }
        
    }
}

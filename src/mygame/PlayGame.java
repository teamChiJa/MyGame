
package mygame;

import static mygame.CreatMember.*;
import static mygame.Insert.*;

public class PlayGame {
    public static void game(){ 
    System.out.println("ゲームを開始します");
        String msg = "既存のデータを使いますか？";

        System.out.println(msg);
        String yn = foolProof();
        if (yn.equalsIgnoreCase("y")) {

        } else {
            creat();
        }
}
}
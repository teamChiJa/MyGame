package mygame;

import static mygame.CreatMember.*;
import static mygame.MemberManager.*;
import static mygame.Insert.*;
import static mygame.PlayGame.*;

public class MyGame {

    public static void main(String[] args) {
        for (;;) {
            game();
            System.out.println("continueしますか？");
            String ctn = foolProof();
            if(ctn.equalsIgnoreCase("n")){
                break;
            }
        }
    }

}

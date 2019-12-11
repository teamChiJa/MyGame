package mygame;

import java.io.IOException;
import static mygame.CreatMember.*;
import static mygame.MemberManager.*;
import static mygame.Insert.*;
import static mygame.PlayGame.*;
import static mygame.Combat.*;
import static mygame.Command.read;

public class MyGame {
    //
    public static void main(String[] args) throws IOException {
        for (;;) {
            read();
            game();
            combat();
            System.out.println("CONTINUEしますか?");
            String ctn = foolProof();
            if(ctn.equalsIgnoreCase("n")){
                break;
            }
        }
    }

}

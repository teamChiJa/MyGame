
package mygame;

import java.util.Scanner;

//文字入力
public class Insert {
    String str;
    Scanner scan = new Scanner(System.in);
    public String insert(){
        str = scan.next();
        return str;
        
    }
}

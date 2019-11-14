package mygame;

import java.util.Scanner;

//文字入力
public class Insert {

    static String str;
    static Scanner scan = new Scanner(System.in);

    public static String insert() {
        str = scan.next();
        return str;
    }

}

package mygame;

import java.util.Scanner;

//文字入力
public class Insert {

    static String str;
    static int nm;
    static Scanner scan = new Scanner(System.in);

    public static String insert() {
        str = scan.next();
        return str;
    }

    public static int insertNumber(String Msg) {
        for (;;) {

            try {
                System.out.print(Msg);
                str = scan.next();
                nm = Integer.parseInt(str);
            } catch (NumberFormatException e) {
                System.out.println("▲入力エラー：数値を入力してください▲");
                continue;
            }
            if (nm >= 100000) {
                System.out.println("▲入力エラー：数値が上限を超えています▲");//
                continue;
            }

            return nm;

        }
    }
     public static String foolProof() {
        String yn;
        for (;;) {
            System.out.print("Y/n >");
            yn = scan.next();
            if(yn.equalsIgnoreCase("y")||yn.equalsIgnoreCase("n")){
                break;
            }
            else{
                continue;
            }
        }  
        return yn;

    }


}

package com.interview;
import java.util.Scanner;

// 用户名的首字符必须是大写或者小写字母。
// 用户名只能包含大小写字母，数字。
//用户名需要包含至少一个字母和一个数字。
//如果用户名合法，请输出“Accept”，反之输出“Wrong”

/**
 * Character.isLetter
 * Character.isDigit
 */
public class T20200822_mt1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < num; i++) {
            String str = sc.nextLine();
            if(CheckName(str) == true){
                System.out.println("Accept");
            }
            else{
                System.out.println("Wrong");
            }
        }
//        System.out.println(CheckName("Ooook"));
    }

    private static boolean CheckName(String str) {
        if(str.length() > 20 || str.length() <= 1)
            return false;
        char[] array = str.toCharArray();
        if(!Character.isLetter(array[0])){
            return false;
        }
        int chr = 0;
        int num = 0;
        int i ;
        for (i = 1; i < array.length; i++) {
            if(Character.isLetter(array[i]))
                chr++;
            else if(Character.isDigit(array[i]))
                num++;
            else
                break;
        }
        if(num == 0 || chr == 0 || i < array.length)
            return false;
        return true;
    }


}

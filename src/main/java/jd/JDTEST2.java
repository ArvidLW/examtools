package jd;

import java.util.List;
import java.util.Scanner;

public class JDTEST2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String s=in.next();
            System.out.println(getKinds(s));
        }
    }
    //思路，转换问题后面的括号来选择一个前面的括号来消去
    public static int getKinds(String s){
        int kinds=1;
        int n=0;
        for(int i=0;i<s.length();++i){
            if(s.charAt(i)=='('){
                ++n;
            }
            else {
                kinds *=n;
                --n;
            }
        }
        return kinds;
    }
}

package jd;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JDTEST1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String s=in.next();
            int pos =getPos(s);
            System.out.println(s+s.substring(pos,s.length()));
        }
    }
    //思路，暴力比较
    public static int getPos(String s){
        int len=s.length();
        int pos=0;
        for(int i=1;i<=len;++i){
            if(s.substring(0,i).equals(s.substring(len-i,len))){
                pos=i;
            }
            else break;
        }
        return pos;
    }
}

package net;

import java.util.Scanner;

public class ConvertNum {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String s=in.next();
            char[] c=new char[s.length()];
            int j=0;
            for(int i=s.length()-1;i>=0;--i){
                c[j]=s.charAt(i);
                ++j;
            }
            System.out.println(Integer.valueOf(s)+Integer.valueOf(new String(c)));
        }
    }
}

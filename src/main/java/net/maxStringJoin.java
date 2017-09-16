package net;

import java.util.Scanner;

public class maxStringJoin {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String s=in.next();
            System.out.printf("%.2f",getAver(s));
        }

    }
    static float getAver(String s){
        int n=1;
        for(int i=0;i<s.length()-1;++i){
            if(s.charAt(i)!=s.charAt(i+1)){
                ++n;
            }
        }
        return (float) s.length() / (float) n;
    }
}

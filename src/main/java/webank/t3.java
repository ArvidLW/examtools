package webank;

import java.math.BigInteger;
import java.util.Scanner;

public class t3 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        while (in.hasNext()){
            String s=in.next();
            long a=Long.valueOf(s);
            System.out.println(nCycle(a));
        }
    }
    public static int nCycle(long a){
        int n=1;
        for(long i=1;i<=a;++i){
            if(i%2==0){
                continue;
            }
            String s = Long.toBinaryString(i);
            if(isCycle(s)){
                ++n;
            }
        }
        return n;
    }
    public static boolean isCycle2(String s){
        StringBuilder sb=new StringBuilder(s);
        String s1 = sb.reverse().toString();
        if(s.equals(s1)){return true;}
        return false;
    }
    public static boolean isCycle(String s){
        for(int i=0;i<(s.length()+1)/2;++i){
            if(s.charAt(i)!=s.charAt(s.length()-i-1)){
                return false;
            }
        }
        return true;
    }
}

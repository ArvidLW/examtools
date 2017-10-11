package webank;

import java.util.Scanner;

public class t1 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        while (in.hasNext()){
            int a=in.nextInt();
            int b=in.nextInt();
            int c=in.nextInt();
            System.out.println(n1(a,b,c));
        }
    }
    public static int n1(int a,int b,int c){
        return b-c+1;
    }
}

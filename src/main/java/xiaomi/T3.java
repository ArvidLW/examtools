package xiaomi;

import java.util.Scanner;

public class T3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int d=in.nextInt();
            int sum=kinds(d);
            System.out.println(sum);
        }
    }
    static int kinds(int d){
        if(d==0||d==1){
            return 1;
        }
        if(d==2){
            return 2;
        }
        int t1=kinds(d-1);
        int t2=kinds(d-2);
        return t1+t2;
    }
}

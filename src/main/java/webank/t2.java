package webank;

import java.util.Scanner;

public class t2 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        while (in.hasNext()){
            int a=in.nextInt();
            System.out.println(maxP(a));
        }
    }
    public static int maxP(int a){
        int e=a/2 +1;
        int total=0;
        for(int i=2;i<=e;++i){
            int tmp=0;
            int val=a;
            while (val>0){
                tmp+=val%i;
                val=val/i;
            }
            if(total<tmp){
                total=tmp;
            }
        }
        return total;
    }
}

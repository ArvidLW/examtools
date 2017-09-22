package ctrip;

import java.util.Scanner;

public class convertNum {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int num=in.nextInt();
            int scale=in.nextInt();
            transform(num,scale);
        }
    }

    static void transform(int num,int n){
        //参数num为输入的十进制数，参数n为要转换的进制
        int re[]=new int[100];
        int m=0;
        while(num!=0){//当输入的数不为0时循环执行求余和赋值
            int remainder=num%n;
            num=num/n;
            re[m]=remainder;//将结果加入到数组中去
            m++;
        }
        show(re,m-1);

    }
    static void show(int[] re,int n){
        for(int i=n;i>=0;i--){
            if(re[i]>9){
                System.out.print((char)(re[i]+55));
            }
            else
                System.out.print(re[i]+"");
        }
    }
}

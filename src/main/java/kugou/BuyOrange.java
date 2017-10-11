package kugou;

import java.util.Scanner;

public class BuyOrange {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            System.out.println(cal(in.nextInt()));
        }
    }
    static int cal(int n){
        int d=0;
        while(n>=24){
            n=n-24;
            d+=3;
        }
        while(n>=22){
            n=n-22;
            d+=3;
        }
        while (n>=20){
            n=n-20;
            d+=3;
        }
        if(n%8==0){
            d+=n/8;
            return d;
        }
        if(n%6==0){
            d+=n/6;
            return d;
        }
        return -1;
    }
}

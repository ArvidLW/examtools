package ctrip;

import java.util.Scanner;

public class convertLog {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int num = in.nextInt();
            System.out.println(getPNSum(num));
        }
    }
    //判断是否是质数
    static boolean isPrimeNumber(int num) {
        if (num == 2) return true;//2特殊处理
        if (num < 2 || num % 2 == 0) return false;//识别小于2的数和偶数
        for (int i = 3; i <= Math.sqrt(num); i += 2) {
            if (num % i == 0) {//识别被奇数整除
                return false;
            }
        }
        return true;
    }

    //获取质数和的个数
    static int getPNSum(int num) {
        int sum = 0;
        //单独考虑2
        if (isPrimeNumber(num - 2)) {
            ++sum;
        }
        for (int i = 3; i <= (num / 2); i += 2) {
            if (isPrimeNumber(i) && isPrimeNumber(num - i)) {
                ++sum;
            }
        }
        return sum;
    }
}

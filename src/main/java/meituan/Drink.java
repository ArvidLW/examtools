package meituan;

import java.util.Scanner;

public class Drink {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int num = in.nextInt();
            int unit = in.nextInt();
            int bottle = in.nextInt();
            System.out.println(change(num, unit));
            System.out.println(change2(num, unit, bottle));
            System.out.println(drink(5,5));
        }
    }

    static int change(int num, int unit) {
        int total = 0;
        int cal = 0;
        int n = 0;
        while (total < num) {
            ++cal;
            ++total;
            ++n;
            if (cal >= unit) {
                cal = 0;
                ++total;
            }
        }
        return n;
    }

    static int change2(int num, int unit, int bottle) {
        int total = 0;
        int n = 0;
        while (total < num) {
            ++n;
            total=n+drink(n,n);
        }
        return n;
    }

    public static int drink(int bottle, int top) {
        if (bottle >= 2 || top >= 4) {
            int leftBottle = (bottle / 2) + (bottle % 2) + (top / 4);
            int leftTop = (top / 4) + (top % 4) + (bottle / 2);
            return (bottle / 2) + (top / 4) + drink(leftBottle, leftTop);
        }
        return 0;
    }
}

package net;

import java.util.*;

public class MagicCoin {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            Stack<Integer> stack = new Stack<>();
            List<Integer[]> ll = new ArrayList<Integer[]>();
            getWay(n, stack, ll);
            Integer[] re=ll.get(0);
            StringBuilder s=new StringBuilder();
            for(int i=re.length-1;i>=0;--i){
                s.append(re[i]);
            }
            System.out.println(s);
        }
    }

    static void getWay(int n, Stack<Integer> stack, List<Integer[]> ll) {
        if (n == 0) {
            ll.add(stack.toArray(new Integer[0]));
            return;
        }
        if ((n - 1) % 2 == 0) {
            stack.push(1);
            getWay((n - 1) / 2, stack, ll);
            stack.pop();
        }
        if ((n - 2) % 2 == 0) {
            stack.push(2);
            getWay((n - 2) / 2, stack, ll);
            stack.pop();
        }
    }
}

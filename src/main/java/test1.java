import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class test1 {
    public static void main(String[] args) {
//        StringBuilder x = new StringBuilder("ab");
//        change(x);
//        System.out.println(x);
//        Stack<Integer> stack=new Stack<Integer>();
//        stack.push(9);
//        stack.push(8);
//        Integer[] s = stack.toArray(new Integer[0]);
//        System.out.println(Arrays.toString(s));
//        String s="0100";
//        System.out.println(Integer.valueOf(s));
        Node[] link=new Node[3];
        System.out.println(link[0].left);
    }

    public static void change(StringBuilder x) {
        x.delete(0, 2).append("cd");
    }
}
class Node{
    int left=0;
    int right=0;
}

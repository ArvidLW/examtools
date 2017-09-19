package xiaomi;

import java.math.BigInteger;
import java.util.Scanner;

public class JieChen {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            BigInteger b = in.nextBigInteger();
            BigInteger s=new BigInteger("1");
            BigInteger zero=new BigInteger("0");
            BigInteger one=new BigInteger("1");
            while (b.compareTo(one)>0){
//                System.out.println(s+" "+b.compareTo(zero));
                s=b.multiply(s);
                b=b.subtract(one);
                //System.out.println(s);
            }
            System.out.println(s);
        }
    }
}

//import java.util.Scanner;
//
//public class Main {
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        while (in.hasNext()) {
//            Long l=in.nextLong();
//            Long s=1L;
//            while (l>0){
//                s*=l--;
//            }
//            System.out.println(s);
//        }
//    }
//}

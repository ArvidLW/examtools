//import java.util.Arrays;
//import java.util.Comparator;
//import java.util.Scanner;
//
//public class meituan21 {
//    /*
//    思想：
//    1、不出现无卷可拿，即前面选的组的人数比后面多。
//    2、不出现改自己的卷，即自己的卷被别人改完了。
//    */
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        while (in.hasNextInt()) {
//            int n=in.nextInt();
//            Integer[] arr=new Integer[n];
//            for(int i=0;i<n;++i){
//                arr[i]=in.nextInt();
//            }
//            //降序排序，满足思想1
//            Arrays.sort(arr,new MyComparator());
//            //System.out.println(Arrays.toString(arr));
//            System.out.println(judge(arr));
//        }
//    }
//    static String judge(Integer[] arr){
//        int max=arr[0];
//        int total=0;
//        //判断前面是否能被后面消费完，满足2
//        for (int i=arr.length-1;i>=1;--i){
//            total+=arr[i];
//        }
//        if(total<=max){
//            return "No";
//        }
//        return "Yes";
//    }
//}
//class MyComparator implements Comparator {
//    public int compare(Object o1, Object o2) {
//        if( (int)o1 > (int)o2 ){
//            return -1;
//        }
//        return 1;
//    }
//}
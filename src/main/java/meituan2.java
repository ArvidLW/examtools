import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class meituan2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int n=in.nextInt();
            Integer[] arr=new Integer[n];
            for(int i=0;i<n;++i){
                arr[i]=in.nextInt();
            }
            Arrays.sort(arr,new MyComparator());
            //System.out.println(Arrays.toString(arr));
            System.out.println(judge(arr));
        }
    }
    static String judge(Integer[] arr){
        //对于每一个数后面的数加起来要比它大才行
        String flag="Yes";
        for(int p=0;p<arr.length-1;++p){
            int max=arr[p];
            int total=0;
            for(int k=p+1;k<arr.length;++k){
                total+=arr[k];
            }
            if(total<=max){
                flag="No";
                break;
            }
        }
        return flag;
    }
}
class MyComparator implements Comparator {
    public int compare(Object o1, Object o2) {
        if( (int)o1 > (int)o2 ){
            return -1;
        }
        return 1;
    }
}

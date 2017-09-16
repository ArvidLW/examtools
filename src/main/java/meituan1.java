import java.util.Scanner;

public class meituan1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int n=in.nextInt();
            int[] arr=new int[n];
            for(int i=0;i<n;++i){
                arr[i]=in.nextInt();
            }
            System.out.println(getXLen(arr));
        }
    }
    static int getXLen(int[] arr){
        int len=1;
        int tmp=arr[0];
        for(int i=1;i<arr.length;++i){
            if(Math.abs(tmp-arr[i])==1){
                tmp=arr[i];
                ++len;
            }
        }
        return len;
    }
}

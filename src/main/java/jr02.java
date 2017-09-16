import java.util.Scanner;

public class jr02 {
    public static void main(String args[]){
        Scanner in=new Scanner(System.in);
        while (in.hasNext()){
            int n=in.nextInt();
            int[] list=new int[n];
            for(int i=0;i<n;i++){
                list[i]=in.nextInt();
            }
            int max=getMax(n,list);
            System.out.println(max);
        }
        in.close();
    }
    private static int getMax(int n,int[] list){
        int max=0;
        for(int i=n-1;i>=0;i--){
            int sum_tmp=0;
            for(int j=0;j<=i;j++){
                sum_tmp=sum_tmp+list[j];
            }
            int max_temp=list[i]*sum_tmp;
            if (max_temp>max){
                max=max_temp;
            }
        }
        return max;
    }
}

